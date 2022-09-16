package activity;

import dao.CriminalRecordDao;
import models.CriminalRecord;

public class GetCriminalRecordActivity {
    private final CriminalRecordDao criminalRecordDao;

    public GetCriminalRecordActivity(CriminalRecordDao criminalRecordDao) {
        this.criminalRecordDao = criminalRecordDao;
    }

    public CriminalRecord handleRequest(String ssn) {
        CriminalRecord criminalRecord = criminalRecordDao.getCriminalRecord(ssn);

        return criminalRecord;
    }
}
