package activity;

import main.java.activity.AddCrimeToCriminalRecordActivity;
import main.java.activity.dao.CrimeDao;
import main.java.activity.dao.CriminalRecordDao;
import main.java.exceptions.CrimeAlreadyInCriminalRecordException;
import main.java.exceptions.CriminalRecordCrimeMismatchException;
import main.java.exceptions.NoCriminalRecordFoundException;
import main.java.models.Crime;
import main.java.models.CriminalRecord;
import main.java.models.requests.AddCrimeToCriminalRecordRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AddCrimeToCriminalRecordActivityTest {
    @Mock
    CriminalRecordDao criminalRecordDao;
    @Mock
    CrimeDao crimeDao;

    private AddCrimeToCriminalRecordActivity addCrimeToCriminalRecordActivity;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        addCrimeToCriminalRecordActivity = new AddCrimeToCriminalRecordActivity(criminalRecordDao, crimeDao);

    }

    @Test
    public void handleRequest_addCrimeToExistingCriminalRecordWithNoCrimes_returnsCriminalRecordsWithCrimeAdded() {
        //GIVEN
        String ssn = "000-00-0000";
        String caseNumber = "xx";

        Crime crimeToAdd = Crime.builder()
                .withCaseNumber(caseNumber)
                .withSsn(ssn)
                .build();
        CriminalRecord exampleRecord = CriminalRecord.builder()
                .withSsn(ssn)
                .withCrimes(new ArrayList<>())
                .withCrimeCount(0)
                .build();
        List<Crime> expectedList = exampleRecord.getCrimes();

        AddCrimeToCriminalRecordRequest addCrimeToCriminalRecordRequest = AddCrimeToCriminalRecordRequest.builder()
                .withSsn(ssn)
                .withCaseNumber(caseNumber)
                .build();

        when(crimeDao.getCrime(caseNumber)).thenReturn(crimeToAdd);
        when(criminalRecordDao.getCriminalRecord(ssn)).thenReturn(exampleRecord);

        //WHEN
        CriminalRecord resultRecord = addCrimeToCriminalRecordActivity.handleRequest(addCrimeToCriminalRecordRequest, null);
        List<Crime> actualList = resultRecord.getCrimes();

        //THEN
        assertEquals(expectedList, actualList, "Expected the list of crimes within the record to contain the added crime.");
    }

    @Test
    public void handleRequest_addCrimeToExistingCriminalRecordWithNoCrimes_makesCallToSaveCriminalRecord() {
        //GIVEN
        String ssn = "000-00-0000";
        String caseNumber = "xx";

        Crime crimeToAdd = Crime.builder()
                .withCaseNumber(caseNumber)
                .withSsn(ssn)
                .build();
        CriminalRecord exampleRecord = CriminalRecord.builder()
                .withSsn(ssn)
                .withCrimes(new ArrayList<>())
                .withCrimeCount(0)
                .build();

        AddCrimeToCriminalRecordRequest addCrimeToCriminalRecordRequest = AddCrimeToCriminalRecordRequest.builder()
                .withSsn(ssn)
                .withCaseNumber(caseNumber)
                .build();

        when(crimeDao.getCrime(caseNumber)).thenReturn(crimeToAdd);
        when(criminalRecordDao.getCriminalRecord(ssn)).thenReturn(exampleRecord);

        //WHEN
        CriminalRecord resultRecord = addCrimeToCriminalRecordActivity.handleRequest(addCrimeToCriminalRecordRequest, null);

        //THEN
        verify(criminalRecordDao).saveCriminalRecord(any());
    }



    @Test
    public void handleRequest_addCrimeToExistingCriminalRecordWithNoCrimes_returnsCriminalRecordsWithCrimeCountIncremented() {
        //GIVEN
        String ssn = "000-00-0000";
        String caseNumber = "xx";

        Crime crimeToAdd = Crime.builder()
                .withCaseNumber(caseNumber)
                .withSsn(ssn)
                .build();
        CriminalRecord exampleRecord = CriminalRecord.builder()
                .withSsn(ssn)
                .withCrimes(new ArrayList<>())
                .withCrimeCount(0)
                .build();

        AddCrimeToCriminalRecordRequest addCrimeToCriminalRecordRequest = AddCrimeToCriminalRecordRequest.builder()
                .withSsn(ssn)
                .withCaseNumber(caseNumber)
                .build();

        when(crimeDao.getCrime(caseNumber)).thenReturn(crimeToAdd);
        when(criminalRecordDao.getCriminalRecord(ssn)).thenReturn(exampleRecord);

        //WHEN
        CriminalRecord resultRecord = addCrimeToCriminalRecordActivity.handleRequest(addCrimeToCriminalRecordRequest, null);
        Integer actual = resultRecord.getCrimeCount();
        //THEN
        assertEquals(1, actual, "Expected the crime count attribute to be incremented by one.");
    }

    @Test
    public void handleRequest_addCrimeToCriminalRecordAlreadyContainsCrime_throwsCrimeAlreadyInCriminalRecordException() {
        //GIVEN
        String ssn = "000-00-0000";
        String caseNumber = "xx";

        Crime crimeToAdd = Crime.builder()
                .withCaseNumber(caseNumber)
                .withSsn(ssn)
                .build();
        CriminalRecord exampleRecord = CriminalRecord.builder()
                .withSsn(ssn)
                .withCrimes(new ArrayList<>(Arrays.asList(crimeToAdd)))
                .withCrimeCount(0)
                .build();
        List<Crime> expectedList = exampleRecord.getCrimes();

        AddCrimeToCriminalRecordRequest addCrimeToCriminalRecordRequest = AddCrimeToCriminalRecordRequest.builder()
                .withSsn(ssn)
                .withCaseNumber(caseNumber)
                .build();

        when(crimeDao.getCrime(caseNumber)).thenReturn(crimeToAdd);
        when(criminalRecordDao.getCriminalRecord(ssn)).thenReturn(exampleRecord);

        //WHEN THEN
        assertThrows(CrimeAlreadyInCriminalRecordException.class, () -> addCrimeToCriminalRecordActivity
                .handleRequest(addCrimeToCriminalRecordRequest, null),
                "Expected exception to be thrown for crime already in the person's record.");
    }

    @Test
    public void handleRequest_addCrimeToCriminalRecordWrongSSN_throwsCriminalRecordCrimeMismatchException() {
        //GIVEN
        String ssn = "000-00-0000";
        String caseNumber = "xx";

        Crime crimeToAdd = Crime.builder()
                .withCaseNumber(caseNumber)
                .withSsn(ssn)
                .build();

        String otherSSN = "111-11-1111";

        CriminalRecord exampleRecord = CriminalRecord.builder()
                .withSsn(otherSSN)
                .build();

        AddCrimeToCriminalRecordRequest addCrimeToCriminalRecordRequest = AddCrimeToCriminalRecordRequest.builder()
                .withSsn(otherSSN)
                .withCaseNumber(caseNumber)
                .build();

        when(crimeDao.getCrime(caseNumber)).thenReturn(crimeToAdd);
        when(criminalRecordDao.getCriminalRecord(otherSSN)).thenReturn(exampleRecord);

        //WHEN THEN
        assertThrows(CriminalRecordCrimeMismatchException.class, () -> addCrimeToCriminalRecordActivity
                .handleRequest(addCrimeToCriminalRecordRequest, null),
                "Expected exception to be thrown for crime not belonging to the record with different SSN.");
    }

    @Test
    public void handleRequest_addCrimeForNonExistingCriminalRecord_throwsNoCriminalRecordFoundException() {
        //GIVEN
        AddCrimeToCriminalRecordRequest addCrimeToCriminalRecordRequest = AddCrimeToCriminalRecordRequest.builder()
                .withSsn("XXX-XX-XXXX")
                .withCaseNumber("XX")
                .build();
        when(criminalRecordDao.getCriminalRecord("XXX-XX-XXXX")).thenThrow(NoCriminalRecordFoundException.class);

        //WHEN THEN
        assertThrows(NoCriminalRecordFoundException.class, () -> addCrimeToCriminalRecordActivity
                .handleRequest(addCrimeToCriminalRecordRequest, null));
    }

}
