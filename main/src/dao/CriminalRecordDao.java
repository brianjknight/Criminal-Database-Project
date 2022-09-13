package dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import exceptions.NoCriminalRecordFoundException;
import models.CriminalRecord;

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

    public CriminalRecord saveCriminalRecord(CriminalRecord criminalRecord) {
        dynamoDBMapper.save(criminalRecord);
        return criminalRecord;
    }

    public String deleteCriminalRecord(String ssn) {
        CriminalRecord criminalRecord = dynamoDBMapper.load(CriminalRecord.class, ssn);

        if (criminalRecord == null) {
            throw new NoCriminalRecordFoundException(ssn);
        }

        dynamoDBMapper.delete(ssn);
        return "Criminal record for SSN: " + ssn + " has been expunged from the database.";
    }
}
