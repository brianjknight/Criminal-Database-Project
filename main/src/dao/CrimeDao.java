package dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import exceptions.NoCrimeFoundException;
import models.Crime;

public class CrimeDao {
    private final DynamoDBMapper dynamoDBMapper;

    public CrimeDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public Crime getCrime(String caseNumber) {
        Crime crime = dynamoDBMapper.load(Crime.class, caseNumber);

        if (crime == null) {
            throw new NoCrimeFoundException(caseNumber);
        }

        return crime;
    }
}
