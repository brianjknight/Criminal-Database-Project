package activity;

import main.java.activity.CreateCriminalRecordActivity;
import main.java.activity.dao.CriminalRecordDao;
import main.java.models.CriminalRecord;
import main.java.models.requests.CreateCriminalRecordRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CreateCriminalRecordActivityTest {
    @Mock
    private CriminalRecordDao criminalRecordDao;

    private CreateCriminalRecordActivity createCriminalRecordActivity;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        createCriminalRecordActivity = new CreateCriminalRecordActivity(criminalRecordDao);
    }

    @Test
    public void handleRequest_provideParamsToCreateCriminalRecord_returnsCriminalRecord() {
        //GIVEN
        String ssn = "test-ssn";
        String name = "test name";
        String dob = "1/1/1900";
        String state = "test state";
        CreateCriminalRecordRequest createCriminalRecordRequest = CreateCriminalRecordRequest.builder()
                .withSsn(ssn)
                .withName(name)
                .withDob(dob)
                .withState(state)
                .build();

        CriminalRecord expectedCriminalRecord = CriminalRecord.builder()
                .withSsn(ssn)
                .withName(name)
                .withDob(dob)
                .withState(state)
                .withCrimeCount(0)
                .build();

        when(criminalRecordDao.saveCriminalRecord(expectedCriminalRecord)).thenReturn(expectedCriminalRecord);

        //WHEN
        CriminalRecord actualCriminalRecord = createCriminalRecordActivity.handleRequest(createCriminalRecordRequest, null);

        //THEN
        assertEquals(actualCriminalRecord, expectedCriminalRecord, "Expected CreateCriminalRecordActivity to return the created criminal record.");
    }

    @Test
    public void handleRequest_provideParamsToCreateCriminalRecord_verifyCallToSaveCriminalRecord() {
        //GIVEN
        String ssn = "test-ssn";
        String name = "test name";
        String dob = "1/1/1900";
        String state = "test state";
        CreateCriminalRecordRequest createCriminalRecordRequest = CreateCriminalRecordRequest.builder()
                .withSsn(ssn)
                .withName(name)
                .withDob(dob)
                .withState(state)
                .build();
        CriminalRecord expectedCriminalRecord = CriminalRecord.builder()
                .withSsn(ssn)
                .withName(name)
                .withDob(dob)
                .withState(state)
                .withCrimeCount(0)
                .build();
        when(criminalRecordDao.saveCriminalRecord(expectedCriminalRecord)).thenReturn(expectedCriminalRecord);

        //WHEN
        CriminalRecord actualCriminalRecord = createCriminalRecordActivity.handleRequest(createCriminalRecordRequest, null);

        //THEN
        verify(criminalRecordDao).saveCriminalRecord(any());
    }

}
