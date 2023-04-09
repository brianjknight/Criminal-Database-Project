package dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import main.java.activity.dao.CrimeDao;
import main.java.exceptions.NoCrimeFoundException;
import main.java.models.Crime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CrimeDaoTest {
    @Mock
    DynamoDBMapper dynamoDBMapper;

    private CrimeDao crimeDao;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        crimeDao = new CrimeDao(dynamoDBMapper);
    }

    @Test
    public void getCrime_provideCaseNumberExistingCrime_returnCrime() {
        //GIVEN
        String caseNumber = "123";
        Crime expectedCrime = Crime.builder()
                .withCaseNumber(caseNumber)
                .withSsn("xxx-xx-xxxx")
                .build();
        when(dynamoDBMapper.load(Crime.class, caseNumber)).thenReturn(expectedCrime);

        //WHEN
        Crime result = crimeDao.getCrime(caseNumber);

        //THEN
        verify(dynamoDBMapper).load(Crime.class, caseNumber);
        assertEquals(expectedCrime, result, "Expected the existing crime for given case number to be returned.");
    }

    @Test
    public void getCrime_provideNonExistingCaseNumber_throwsNoCrimeFoundException() {
        //GIVEN
        String nonExistentCase = "xx";
        when(dynamoDBMapper.load(nonExistentCase)).thenThrow(NoCrimeFoundException.class);

        //WHEN THEN
        assertThrows(NoCrimeFoundException.class, () -> crimeDao.getCrime(nonExistentCase), "Expected exception to be thrown.");
    }


}
