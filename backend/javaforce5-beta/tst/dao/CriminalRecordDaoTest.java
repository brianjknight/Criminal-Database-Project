package dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import main.java.dao.CriminalRecordDao;
import main.java.exceptions.MissingAttributeToSaveRecordException;
import main.java.exceptions.NoCriminalRecordForStateException;
import main.java.exceptions.NoCriminalRecordFoundException;
import main.java.models.CriminalRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.stubbing.defaultanswers.ForwardsInvocations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class CriminalRecordDaoTest {
    @Mock
    DynamoDBMapper dynamoDBMapper;

    private CriminalRecordDao criminalRecordDao;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        criminalRecordDao = new CriminalRecordDao(dynamoDBMapper);
    }

    @Test
    public void getCriminalRecord_provideSSNForExistingRecord_returnCriminalRecord() {
        //GIVEN
        String ssn = "000-00-0000";
        CriminalRecord john = CriminalRecord.builder()
                .withSsn(ssn)
                .withName("John Doe")
                .withDob("1/1/1900")
                .withState("XX")
                .withCrimeCount(0)
                .build();

        when(dynamoDBMapper.load(CriminalRecord.class, ssn)).thenReturn(john);

        //WHEN
        CriminalRecord result = criminalRecordDao.getCriminalRecord(ssn);

        //THEN
        verify(dynamoDBMapper).load(CriminalRecord.class, ssn);
        assertEquals(john, result, "Expected matching returned criminal record.");
    }

    @Test
    public void getCriminalRecord_provideSSNForNONExistingRecord_throwNoCriminalRecordFoundException() {
        //GIVEN
        String ssn = "000-00-0000";

        when(dynamoDBMapper.load(CriminalRecord.class, ssn)).thenThrow(NoCriminalRecordFoundException.class);

        //WHEN THEN
        assertThrows(NoCriminalRecordFoundException.class, () -> criminalRecordDao.getCriminalRecord(ssn), "Expected exception to be thrown.");
    }

    @Test
    public void getCriminalRecordByState_provideStateWithExistingCriminalRecords_returnListOfCriminalRecords() {
        //GIVEN
        String state = "CO";
        CriminalRecord john = CriminalRecord.builder()
                .withSsn("000-00-0000")
                .withName("John Doe")
                .withDob("1/1/1900")
                .withState("CO")
                .withCrimeCount(0)
                .build();
        CriminalRecord bob = CriminalRecord.builder()
                .withSsn("111-11-111")
                .withName("Bob Doe")
                .withDob("1/1/1900")
                .withState("CO")
                .withCrimeCount(0)
                .build();
        List<CriminalRecord> criminalRecordList = new ArrayList<>(Arrays.asList(john, bob));

        when(dynamoDBMapper.query(eq(CriminalRecord.class), any(DynamoDBQueryExpression.class)))
                .thenReturn(mock(PaginatedQueryList.class, withSettings().defaultAnswer(new ForwardsInvocations(criminalRecordList))));

        //WHEN
        List<CriminalRecord> result = criminalRecordDao.getCriminalRecordsByState("CO");

        //THEN
        assertEquals(criminalRecordList, result, "Expected the resulting list of criminal records to be equal.");
    }

    @Test
    public void getCriminalRecordByState_provideStateWithNoCriminalRecords_throwsNoCriminalRecordForStateException() {
        //GIVEN
        List<CriminalRecord> emptyList = new ArrayList<>();
        when(dynamoDBMapper.query(eq(CriminalRecord.class), any(DynamoDBQueryExpression.class)))
                .thenReturn(mock(PaginatedQueryList.class, withSettings().defaultAnswer(new ForwardsInvocations(emptyList))));

        //WHEN THEN
        assertThrows(NoCriminalRecordForStateException.class, () -> criminalRecordDao.getCriminalRecordsByState("CO"));

    }

    @Test
    public void saveCriminalRecord_provideCriminalRecord_verifyCallsDynamoDBMapperSaveMethod() {
        //GIVEN
        CriminalRecord john = CriminalRecord.builder()
                .withSsn("000-00-0000")
                .build();

        //WHEN
        criminalRecordDao.saveCriminalRecord(john);

        //THEN
        verify(dynamoDBMapper).save(any());
    }

    @Test
    public void saveCriminalRecord_provideIncompleteRecord_throwsMissingAttributeToSaveRecordException() {
        //GIVEN
        CriminalRecord john = CriminalRecord.builder()
                .withSsn("000-00-0000")
                .build();

        //WHEN THEN
        assertThrows(MissingAttributeToSaveRecordException.class, () -> criminalRecordDao.saveCriminalRecord(john),
                "Expected exception to be throw for incomplete attributes.");
    }

    @Test
    public void deleteCriminalRecord_provideExistingRecordToDelete_verifyCallsDynamoDBMapperDeleteMethod() {
        //GIVEN
        String ssn = "xxx-xx-xxxx";

        //WHEN
        dynamoDBMapper.delete(ssn);

        //THEN
        verify(dynamoDBMapper).delete(any());
    }

}
