package activity;

import dao.CriminalRecordDao;
import models.CriminalRecord;

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
