package main.java.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import main.java.exceptions.NoCrimeFoundException;
import main.java.models.Crime;

import javax.inject.Inject;

public class CrimeDao {
    private final DynamoDBMapper dynamoDBMapper;

    @Inject
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
