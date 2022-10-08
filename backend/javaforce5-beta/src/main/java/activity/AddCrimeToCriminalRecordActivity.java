package main.java.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import main.java.dao.CrimeDao;
import main.java.dao.CriminalRecordDao;
import main.java.exceptions.CrimeAlreadyInCriminalRecordException;
import main.java.exceptions.CriminalRecordCrimeMismatchException;
import main.java.models.Crime;
import main.java.models.CriminalRecord;
import main.java.models.requests.AddCrimeToCriminalRecordRequest;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;


/**
 * Implementation of the Criminal Record Service API for adding a crime to a criminal record.
 *
 */
public class AddCrimeToCriminalRecordActivity implements RequestHandler<AddCrimeToCriminalRecordRequest, CriminalRecord> {

    private CriminalRecordDao criminalRecordDao;
    private CrimeDao crimeDao;

    /**
     * Instantiate a new AddCrimeToCriminalRecordActivity object.
     *
     * @param criminalRecordDao CriminalRecordDao to access CriminalRecords table.
     * @param crimeDao CrimeDao to access the Crimes table.
     */
    @Inject
    public AddCrimeToCriminalRecordActivity(CriminalRecordDao criminalRecordDao, CrimeDao crimeDao) {
        this.criminalRecordDao = criminalRecordDao;
        this.crimeDao = crimeDao;
    }

    /**
     * This method handles the input request object by adding a Crime to a Criminal Record.
     *
     * @param addCrimeToCriminalRecordRequest request object containing a SSN and caseNumber.
     * @param context The Lambda execution environment context object.
     * @return returns the updated CriminalRecord.
     */
    public CriminalRecord handleRequest(AddCrimeToCriminalRecordRequest addCrimeToCriminalRecordRequest, Context context) {
        String ssn = addCrimeToCriminalRecordRequest.getSsn();
        String caseNumber = addCrimeToCriminalRecordRequest.getCaseNumber();

        Crime requestedCrime = crimeDao.getCrime(caseNumber);
        CriminalRecord requestedCriminalRecord = criminalRecordDao.getCriminalRecord(ssn);

        if(!ssn.equals(requestedCrime.getSsn())) {
            throw new CriminalRecordCrimeMismatchException(ssn, caseNumber);
        }

        List<Crime> crimeList = requestedCriminalRecord.getCrimes();

        if(crimeList == null) {
            crimeList = new ArrayList<>();
        }
        if(crimeList.contains(requestedCrime)) {
            throw new CrimeAlreadyInCriminalRecordException(caseNumber);
        }

        crimeList.add(requestedCrime);
        requestedCriminalRecord.setCrimes(crimeList);

        Integer currentCrimeCount = requestedCriminalRecord.getCrimeCount();
        if (currentCrimeCount == null) {
            currentCrimeCount = 0;
        }
        currentCrimeCount++;
        requestedCriminalRecord.setCrimeCount(currentCrimeCount);

        criminalRecordDao.saveCriminalRecord(requestedCriminalRecord);

        return requestedCriminalRecord;
    }

}
