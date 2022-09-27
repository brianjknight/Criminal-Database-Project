package activity;

import main.java.activity.GetCriminalsRecordsByStateActivity;
import main.java.dao.CriminalRecordDao;
import main.java.exceptions.NoCriminalRecordForStateException;
import main.java.models.CriminalRecord;
import main.java.models.requests.GetCriminalsRecordsByStateRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class GetCriminalsRecordsByStateActivityTest {
    @Mock
    CriminalRecordDao criminalRecordDao;

    private GetCriminalsRecordsByStateActivity getCriminalsRecordsByStateActivity;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        getCriminalsRecordsByStateActivity = new GetCriminalsRecordsByStateActivity(criminalRecordDao);
    }

    @Test
    public void handleRequest_provideStateWithExistingCriminalRecords_returnListOfCriminalRecords() {
        //GIVEN
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
        List<CriminalRecord> expectedList = new ArrayList<>(Arrays.asList(john, bob));


        GetCriminalsRecordsByStateRequest getRecordsCO = GetCriminalsRecordsByStateRequest.builder()
                .withState("CO")
                .build();

        when(criminalRecordDao.getCriminalRecordsByState(getRecordsCO)).thenReturn(expectedList);


        //WHEN
        List<CriminalRecord> actualList = getCriminalsRecordsByStateActivity.handleRequest(getRecordsCO, null);

        //THEN
        assertEquals(expectedList, actualList, "Expected the list of CriminalRecords to match.");
    }

    @Test
    public void handleRequest_provideStateWithNoCriminalRecords_throwsNoCriminalRecordForStateException() {
        //GIVEN
        GetCriminalsRecordsByStateRequest getCriminalsRecordsNM = GetCriminalsRecordsByStateRequest.builder()
                .withState("NM")
                .build();

        when(criminalRecordDao.getCriminalRecordsByState(getCriminalsRecordsNM)).thenThrow(NoCriminalRecordForStateException.class);

        //WHEN THEN
        assertThrows(NoCriminalRecordForStateException.class, () ->
                getCriminalsRecordsByStateActivity.handleRequest(getCriminalsRecordsNM, null),
                "Expected exception to be thrown when no records exist for that state.");
    }

}
