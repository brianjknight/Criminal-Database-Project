package main.java.activity;

import main.java.dao.CriminalRecordDao;
import main.java.models.CriminalRecord;

import javax.inject.Inject;

public class GetCriminalRecordActivity {
    private final CriminalRecordDao criminalRecordDao;

    @Inject
    public GetCriminalRecordActivity(CriminalRecordDao criminalRecordDao) {
        this.criminalRecordDao = criminalRecordDao;
    }

    public CriminalRecord handleRequest(String ssn) {
        CriminalRecord criminalRecord = criminalRecordDao.getCriminalRecord(ssn);

        return criminalRecord;
    }
}
