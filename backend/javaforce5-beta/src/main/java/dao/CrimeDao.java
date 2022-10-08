package main.java.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import main.java.exceptions.NoCrimeFoundException;
import main.java.models.Crime;

import javax.inject.Inject;

/**
 * Accesses the Crimes table in DynamoDB.
 */
public class CrimeDao {
    private final DynamoDBMapper dynamoDBMapper;

    /**
     * Instantiates a CrimeDao object.
     *
     * @param dynamoDBMapper used to interact with Crimes table.
     */
    @Inject
    public CrimeDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    /**
     * Returns the corresponding Crime object.
     *
     * @param caseNumber case ID (partition only primary key).
     * @return Crime object.
     */
    public Crime getCrime(String caseNumber) {
        Crime crime = dynamoDBMapper.load(Crime.class, caseNumber);

        if (crime == null) {
            throw new NoCrimeFoundException(caseNumber);
        }

        return crime;
    }
}
