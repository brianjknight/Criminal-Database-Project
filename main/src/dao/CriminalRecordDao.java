package dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import exceptions.NoCriminalRecordForStateException;
import exceptions.NoCriminalRecordFoundException;
import models.CriminalRecord;

import java.util.ArrayList;
import java.util.List;

public class CriminalRecordDao {
    private final DynamoDBMapper dynamoDBMapper;

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

    public List<CriminalRecord> getCriminalRecordsByState(String state) {
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

    public CriminalRecord saveCriminalRecord(CriminalRecord criminalRecord) {
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
