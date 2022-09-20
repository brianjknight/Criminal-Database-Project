package activitytests;

import main.java.activity.GetCriminalRecordActivity;
import main.java.dao.CriminalRecordDao;
import main.java.exceptions.NoCriminalRecordFoundException;
import main.java.models.CriminalRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class GetCriminalRecordActivityTest {

    @Mock
    private CriminalRecordDao criminalRecordDao;

    private GetCriminalRecordActivity getCriminalRecordActivity;

    @BeforeEach
    public void setup() {
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
        when(criminalRecordDao.getCriminalRecord("000-00-0000")).thenReturn(john);

        //WHEN
        CriminalRecord result = getCriminalRecordActivity.handleRequest("000-00-0000");

        //THEN
        assertEquals(john, result, "Expected the criminal record returned to be for provided SSN.");
    }

    @Test
    public void handleRequest_provideSSNWithNoRecords_throwsNoCriminalRecordFoundException() {
        //GIVEN
        CriminalRecord noCriminal = CriminalRecord.builder()
                .withSsn("XXX-XX-XXXX")
                .build();
        when(criminalRecordDao.getCriminalRecord("XXX-XX-XXXX")).thenThrow(NoCriminalRecordFoundException.class);

        //WHEN THEN
        assertThrows(NoCriminalRecordFoundException.class, () -> getCriminalRecordActivity.handleRequest("XXX-XX-XXXX"));
    }
}
