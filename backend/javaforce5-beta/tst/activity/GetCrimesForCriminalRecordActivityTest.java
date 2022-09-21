package activity;

import main.java.activity.GetCrimesForCriminalRecordActivity;
import main.java.dao.CriminalRecordDao;
import main.java.exceptions.NoCriminalRecordFoundException;
import main.java.models.Crime;
import main.java.models.CriminalRecord;
import main.java.models.requests.GetCrimesForCriminalRecordRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GetCrimesForCriminalRecordActivityTest {
    @Mock
    CriminalRecordDao criminalRecordDao;

    private GetCrimesForCriminalRecordActivity getCrimesForCriminalRecordActivity;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        getCrimesForCriminalRecordActivity = new GetCrimesForCriminalRecordActivity(criminalRecordDao);
    }

    @Test
    public void handleRequest_getCrimeListForExistingCriminalRecordWithACrime_returnCrimeList() {
        //GIVEN
        String ssn = "000-00-0000";
        String caseNumber = "xx";

        Crime crimeToAdd = Crime.builder()
                .withCaseNumber(caseNumber)
                .withSsn(ssn)
                .withCharge("example charge")
                .withOffenseLevel("level")
                .withStatus("example status")
                .withDate("1/1/1900")
                .withSentenceInDays(1)
                .build();
        List<Crime> crimeList = new ArrayList<>(Arrays.asList(crimeToAdd));

        CriminalRecord exampleRecord = CriminalRecord.builder()
                .withSsn(ssn)
                .withCrimes(crimeList)
                .withCrimeCount(0)
                .build();

        GetCrimesForCriminalRecordRequest getCrimesForCriminalRecordRequest = GetCrimesForCriminalRecordRequest.builder()
                .withSsn(ssn)
                .build();

        when(criminalRecordDao.getCriminalRecord(ssn)).thenReturn(exampleRecord);

        //WHEN
        List<Crime> result = getCrimesForCriminalRecordActivity.handleRequest(getCrimesForCriminalRecordRequest, null);

        //THEN
        assertEquals(crimeList, result, "Expected the list of crimes to be equal");
    }

    @Test
    public void handleRequest_getCrimeListForExistingCriminalRecord_verifyCallToGetCriminalRecord() {
        //GIVEN
        String ssn = "000-00-0000";
        String caseNumber = "xx";

        CriminalRecord exampleRecord = CriminalRecord.builder()
                .withSsn(ssn)
                .withCrimeCount(0)
                .build();

        GetCrimesForCriminalRecordRequest getCrimesForCriminalRecordRequest = GetCrimesForCriminalRecordRequest.builder()
                .withSsn(ssn)
                .build();

        when(criminalRecordDao.getCriminalRecord(ssn)).thenReturn(exampleRecord);

        //WHEN
        List<Crime> result = getCrimesForCriminalRecordActivity.handleRequest(getCrimesForCriminalRecordRequest, null);

        //THEN
        verify(criminalRecordDao, times(1)).getCriminalRecord(any());
    }

    @Test
    public void handleRequest_getCrimeListForExistingCriminalRecordWithNullCrime_returnsEmptyCrimeList() {
        //GIVEN
        String ssn = "000-00-0000";

        CriminalRecord exampleRecord = CriminalRecord.builder()
                .withSsn(ssn)
                .withCrimeCount(0)
                .build();

        GetCrimesForCriminalRecordRequest getCrimesForCriminalRecordRequest = GetCrimesForCriminalRecordRequest.builder()
                .withSsn(ssn)
                .build();

        when(criminalRecordDao.getCriminalRecord(ssn)).thenReturn(exampleRecord);

        //WHEN
        List<Crime> result = getCrimesForCriminalRecordActivity.handleRequest(getCrimesForCriminalRecordRequest, null);

        //THEN
        assertTrue(result.size() == 0, "Expected an empty list for a Criminal Record with no crimes added yet");
        assertNotNull(result, "Expected a non null list for a Criminal Record with no crimes added yet");
    }

    @Test
    public void handleRequest_getCrimeListForNonExistingCriminalRecord_throwsNoCriminalRecordFoundException() {
        //GIVEN
        GetCrimesForCriminalRecordRequest getCrimesForCriminalRecordRequest = GetCrimesForCriminalRecordRequest.builder()
                .withSsn("XXX-XX-XXXX")
                .build();
        when(criminalRecordDao.getCriminalRecord("XXX-XX-XXXX")).thenThrow(NoCriminalRecordFoundException.class);

        //WHEN THEN
        assertThrows(NoCriminalRecordFoundException.class, () -> getCrimesForCriminalRecordActivity
                .handleRequest(getCrimesForCriminalRecordRequest, null));
    }

}
