package main.java.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import main.java.exceptions.MissingAttributeToSaveRecordException;
import main.java.exceptions.NoCriminalRecordForStateException;
import main.java.exceptions.NoCriminalRecordFoundException;
import main.java.models.CriminalRecord;
import main.java.models.requests.GetCriminalsRecordsByStateRequest;

import javax.inject.Inject;
import java.util.List;

public class CriminalRecordDao {
    private final DynamoDBMapper dynamoDBMapper;

    @Inject
    public CriminalRecordDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public CriminalRecord getCriminalRecord(String ssn) {
        CriminalRecord criminalRecord = dynamoDBMapper.load(CriminalRecord.class, ssn);

        if (criminalRecord == null) {
            throw new NoCriminalRecordFoundException(ssn);
        }

        return criminalRecord;
    }

    /////////////////////////////////////

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

        CriminalRecord criminalRecord = new CriminalRecord();
        criminalRecord.setState(state);
        DynamoDBQueryExpression<CriminalRecord> queryExpression = new DynamoDBQueryExpression<CriminalRecord>()
                .withIndexName(CriminalRecord.STATE_INDEX)
                .withConsistentRead(false)
                .withHashKeyValues(criminalRecord);

        PaginatedQueryList<CriminalRecord> criminalRecordsByStateList = dynamoDBMapper.query(CriminalRecord.class, queryExpression);
        if(criminalRecordsByStateList == null || criminalRecordsByStateList.size() == 0) {
            throw new NoCriminalRecordForStateException(state);
        }
        return criminalRecordsByStateList;
    }

    /////////////////////////////////////

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

    public String deleteCriminalRecord(String ssn) {
        CriminalRecord criminalRecord = dynamoDBMapper.load(CriminalRecord.class, ssn);

        if (criminalRecord == null) {
            throw new NoCriminalRecordFoundException(ssn);
        }

        dynamoDBMapper.delete(criminalRecord);
        return "Criminal record for SSN: " + ssn + " has been expunged from the database.";
    }
}
