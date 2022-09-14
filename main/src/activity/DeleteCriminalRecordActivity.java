package activity;

import dao.CriminalRecordDao;
import models.CriminalRecord;

public class DeleteCriminalRecordActivity {
    private final CriminalRecordDao criminalRecordDao;

    public DeleteCriminalRecordActivity(CriminalRecordDao criminalRecordDao) {
        this.criminalRecordDao = criminalRecordDao;
    }

    public String handleRequest(String ssn) {

        return criminalRecordDao.deleteCriminalRecord(ssn);
    }

}
