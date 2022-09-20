package main.java.activity;

import main.java.dao.CriminalRecordDao;
import main.java.models.CriminalRecord;

import javax.inject.Inject;

public class CreateCriminalRecordActivity {
    private final CriminalRecordDao criminalRecordDao;

    @Inject
    public CreateCriminalRecordActivity(CriminalRecordDao criminalRecordDao) {
        this.criminalRecordDao = criminalRecordDao;
    }

    public CriminalRecord handleRequest(String ssn, String name, String dob, String state) {
        CriminalRecord criminalRecord = CriminalRecord.builder()
                .withSsn(ssn)
                .withName(name)
                .withDob(dob)
                .withState(state)
                .withCrimeCount(0)
                .withCrimes(null)
                .build();

        criminalRecordDao.saveCriminalRecord(criminalRecord);

        return criminalRecord;
    }

}
