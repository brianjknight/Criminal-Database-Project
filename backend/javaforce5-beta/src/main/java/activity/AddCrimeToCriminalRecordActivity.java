package main.java.activity;

import main.java.dao.CrimeDao;
import main.java.dao.CriminalRecordDao;
import main.java.exceptions.CrimeAlreadyInCriminalRecordException;
import main.java.exceptions.CriminalRecordCrimeMismatchException;
import main.java.models.Crime;
import main.java.models.CriminalRecord;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class AddCrimeToCriminalRecordActivity {

    private CriminalRecordDao criminalRecordDao;
    private CrimeDao crimeDao;

    @Inject
    public AddCrimeToCriminalRecordActivity(CriminalRecordDao criminalRecordDao, CrimeDao crimeDao) {
        this.criminalRecordDao = criminalRecordDao;
        this.crimeDao = crimeDao;
    }

    public CriminalRecord handleRequest(String ssn, String caseNumber) {
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
        currentCrimeCount++;
        requestedCriminalRecord.setCrimeCount(currentCrimeCount);

        criminalRecordDao.saveCriminalRecord(requestedCriminalRecord);

        return requestedCriminalRecord;
    }

}
