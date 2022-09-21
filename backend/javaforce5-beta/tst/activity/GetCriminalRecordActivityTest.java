package activity;

import main.java.activity.GetCriminalRecordActivity;
import main.java.dao.CriminalRecordDao;
import main.java.exceptions.NoCriminalRecordFoundException;
import main.java.models.CriminalRecord;
import main.java.models.requests.GetCriminalRecordRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class GetCriminalRecordActivityTest {

    @Mock
    private CriminalRecordDao criminalRecordDao;

    private GetCriminalRecordActivity getCriminalRecordActivity;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        getCriminalRecordActivity = new GetCriminalRecordActivity(criminalRecordDao);
    }

    @Test
    public void handleRequest_provideSSN_returnCriminalRecord() {
        //GIVEN
        CriminalRecord john = CriminalRecord.builder()
                .withSsn("000-00-0000")
                .withName("John Doe")
                .withDob("1/1/1900")
                .withState("XX")
                .withCrimeCount(0)
                .build();

        GetCriminalRecordRequest getCriminalRecordRequest = GetCriminalRecordRequest.builder()
                .withSsn("000-00-0000")
                .build();

        when(criminalRecordDao.getCriminalRecord("000-00-0000")).thenReturn(john);

        //WHEN
        CriminalRecord result = getCriminalRecordActivity.handleRequest(getCriminalRecordRequest, null);

        //THEN
        assertEquals(john, result, "Expected the criminal record returned to be for provided SSN.");
    }

    @Test
    public void handleRequest_provideSSN_verifyCallToGetCriminalRecord() {
        //GIVEN
        CriminalRecord john = CriminalRecord.builder()
                .withSsn("000-00-0000")
                .withName("John Doe")
                .withDob("1/1/1900")
                .withState("XX")
                .withCrimeCount(0)
                .build();

        GetCriminalRecordRequest getCriminalRecordRequest = GetCriminalRecordRequest.builder()
                .withSsn("000-00-0000")
                .build();

        when(criminalRecordDao.getCriminalRecord("000-00-0000")).thenReturn(john);

        //WHEN
        CriminalRecord result = getCriminalRecordActivity.handleRequest(getCriminalRecordRequest, null);

        //THEN
        verify(criminalRecordDao, times(1)).getCriminalRecord(any());
    }



    @Test
    public void handleRequest_provideSSNWithNoRecords_throwsNoCriminalRecordFoundException() {
        //GIVEN
        GetCriminalRecordRequest getCriminalRecordRequest = GetCriminalRecordRequest.builder()
                .withSsn("XXX-XX-XXXX")
                .build();

        when(criminalRecordDao.getCriminalRecord("XXX-XX-XXXX")).thenThrow(NoCriminalRecordFoundException.class);

        //WHEN THEN
        assertThrows(NoCriminalRecordFoundException.class, () -> getCriminalRecordActivity.handleRequest(getCriminalRecordRequest, null));
    }
}
