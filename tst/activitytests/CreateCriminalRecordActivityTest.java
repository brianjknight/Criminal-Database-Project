package activitytests;

import activity.CreateCriminalRecordActivity;
import dao.CriminalRecordDao;
import models.CriminalRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
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
        CriminalRecord testCriminalRecord = CriminalRecord.builder()
                .withSsn(ssn)
                .withName(name)
                .withDob(dob)
                .withState(state)
                .withCrimeCount(0)
                .build();
        when(criminalRecordDao.saveCriminalRecord(any())).thenReturn(testCriminalRecord);

        //WHEN
        CriminalRecord criminalRecord = createCriminalRecordActivity.handleRequest(ssn, name, dob, state);

        //THEN
        assertEquals(criminalRecord, testCriminalRecord, "Expected CreateCriminalRecordActivity to return the created criminal record.");
    }



}
