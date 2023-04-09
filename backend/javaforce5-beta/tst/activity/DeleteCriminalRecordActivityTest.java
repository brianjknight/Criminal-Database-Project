package activity;

import main.java.activity.DeleteCriminalRecordActivity;
import main.java.activity.dao.CriminalRecordDao;
import main.java.exceptions.NoCriminalRecordFoundException;
import main.java.models.requests.DeleteCriminalRecordRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DeleteCriminalRecordActivityTest {
    @Mock
    CriminalRecordDao criminalRecordDao;

    private DeleteCriminalRecordActivity deleteCriminalRecordActivity;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        deleteCriminalRecordActivity = new DeleteCriminalRecordActivity(criminalRecordDao);
    }

    @Test
    public void handleRequest_deleteExistingCriminalRecord_returnConfirmationMessage() {
        //GIVEN
        String ssn = "000-00-0000";
        String expected = "Criminal record for SSN: " + ssn + " has been expunged from the database.";
        when(criminalRecordDao.deleteCriminalRecord(ssn)).thenReturn(expected);

        DeleteCriminalRecordRequest deleteCriminalRecordRequest = DeleteCriminalRecordRequest.builder()
                .withSsn(ssn)
                .build();

        //WHEN
        String actual = deleteCriminalRecordActivity.handleRequest(deleteCriminalRecordRequest, null);

        //THEN
        assertEquals(expected, actual, "Expected the confirmation string message to be returned.");
    }

    @Test
    public void handleRequest_deleteExistingCriminalRecord_verifyCallToDeleteCriminalRecord() {
        //GIVEN
        String ssn = "000-00-0000";
        String expected = "Criminal record for SSN: " + ssn + " has been expunged from the database.";
        when(criminalRecordDao.deleteCriminalRecord(ssn)).thenReturn(expected);

        DeleteCriminalRecordRequest deleteCriminalRecordRequest = DeleteCriminalRecordRequest.builder()
                .withSsn(ssn)
                .build();

        //WHEN
        String actual = deleteCriminalRecordActivity.handleRequest(deleteCriminalRecordRequest, null);

        //THEN
        verify(criminalRecordDao).deleteCriminalRecord(any());
    }



    @Test
    public void handleRequest_deleteNonExistingCriminalRecord_throwsNoCriminalRecordFoundException() {
        //GIVEN
        String ssn = "000-00-0000";
        when(criminalRecordDao.deleteCriminalRecord(ssn)).thenThrow(NoCriminalRecordFoundException.class);

        DeleteCriminalRecordRequest deleteCriminalRecordRequest = DeleteCriminalRecordRequest.builder()
                .withSsn(ssn)
                .build();

        //WHEN THEN
        assertThrows(NoCriminalRecordFoundException.class, () -> deleteCriminalRecordActivity.handleRequest(deleteCriminalRecordRequest, null));
    }
}
