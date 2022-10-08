package main.java.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.Condition;
import main.java.exceptions.MissingAttributeToSaveRecordException;
import main.java.exceptions.NoCriminalRecordForStateException;
import main.java.exceptions.NoCriminalRecordFoundException;
import main.java.models.CriminalRecord;
import main.java.models.requests.GetCriminalsRecordsByStateRequest;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Accesses data in the CriminalRecords table in DynamoDB.
 */
public class CriminalRecordDao {
    private final DynamoDBMapper dynamoDBMapper;

    /**
     * Instaniates a CriminalRecordDao object.
     *
     * @param dynamoDBMapper used to interact with the CriminalRecords table.
     */
    @Inject
    public CriminalRecordDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    /**
     * This method retrieves a CriminalRecord for the given SSN.
     *
     * @param ssn social security number (SSN) partition only primary key.
     * @return returns a CriminalRecord object for the given ssn.
     */
    public CriminalRecord getCriminalRecord(String ssn) {
        CriminalRecord criminalRecord = dynamoDBMapper.load(CriminalRecord.class, ssn);

        if (criminalRecord == null) {
            throw new NoCriminalRecordFoundException(ssn);
        }

        return criminalRecord;
    }

    /**
     * This method retrieves a list of CriminalRecords matching the given state and filtering on optional number of crimes.
     *
     * @param getCriminalsRecordsByStateRequest request object containing a state and optional minimum and maximum number of crimes.
     * @return returns a list of CriminalRecord objects.
     */
    public List<CriminalRecord> getCriminalRecordsByState(GetCriminalsRecordsByStateRequest getCriminalsRecordsByStateRequest) {
        String state;
        Integer minNumCrimes;
        Integer maxNumCrimes;

        state = getCriminalsRecordsByStateRequest.getState();
        if(getCriminalsRecordsByStateRequest.getMinNumCrimes() == null) {
            minNumCrimes = 0;
        }
        else {
            minNumCrimes = getCriminalsRecordsByStateRequest.getMinNumCrimes();
        }
        if(getCriminalsRecordsByStateRequest.getMaxNumCrimes() == null) {
            maxNumCrimes = Integer.MAX_VALUE;
        }
        else {
            maxNumCrimes = getCriminalsRecordsByStateRequest.getMaxNumCrimes();
        }

        Map<String, AttributeValue> valueMap = new HashMap<>();
        valueMap.put(":stateValue",  new AttributeValue().withS(state));
        valueMap.put(":minCrimeCount", new AttributeValue().withN(Integer.toString(minNumCrimes)));
        valueMap.put(":maxCrimeCount", new AttributeValue().withN(Integer.toString(maxNumCrimes)));

        Map<String, String> valueNames = new HashMap<>();
        valueNames.put("#s", "state");

        DynamoDBQueryExpression<CriminalRecord> queryExpression = new DynamoDBQueryExpression<CriminalRecord>()
                .withIndexName(CriminalRecord.STATE_INDEX)
                .withConsistentRead(false)
                .withExpressionAttributeNames(valueNames)
                .withKeyConditionExpression("#s = :stateValue")
                .withFilterExpression("crimeCount >= :minCrimeCount and crimeCount <= :maxCrimeCount")
                .withExpressionAttributeValues(valueMap);

        PaginatedQueryList<CriminalRecord> criminalRecordsByStateList = dynamoDBMapper.query(CriminalRecord.class, queryExpression);
        if(criminalRecordsByStateList == null || criminalRecordsByStateList.size() == 0) {
            throw new NoCriminalRecordForStateException(state);
        }
        return criminalRecordsByStateList;
    }

    /**
     * This method saves/updates a CriminalRecord item to the DDB CriminalRecords table.
     *
     * @param criminalRecord CriminalRecord object to save in the talbe.
     * @return returns the updated/saved CriminalRecord.
     */
    public CriminalRecord saveCriminalRecord(CriminalRecord criminalRecord) {
        boolean missingSSN = criminalRecord.getSsn() == null || "".equals(criminalRecord.getSsn());
        boolean missingName = criminalRecord.getName() == null || "".equals(criminalRecord.getName());
        boolean missingDob = criminalRecord.getDob() == null || "".equals(criminalRecord.getDob());
        boolean missingState = criminalRecord.getState() == null || "".equals(criminalRecord.getState());

        if(missingSSN || missingName || missingDob || missingState) {
            throw new MissingAttributeToSaveRecordException();
        }

        dynamoDBMapper.save(criminalRecord);
        return criminalRecord;
    }

    /**
     * This method deletes an item from the CriminalRecords table in DynamoDB.
     *
     * @param ssn social security number (SSN) partition only primary key.
     * @return string message confirming the record was deleted.
     */
    public String deleteCriminalRecord(String ssn) {
        CriminalRecord criminalRecord = dynamoDBMapper.load(CriminalRecord.class, ssn);

        if (criminalRecord == null) {
            throw new NoCriminalRecordFoundException(ssn);
        }

        dynamoDBMapper.delete(criminalRecord);
        return "Criminal record for SSN: " + ssn + " has been expunged from the database.";
    }
}
