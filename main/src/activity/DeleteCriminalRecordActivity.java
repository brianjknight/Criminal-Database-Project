package activity;

import dao.CriminalRecordDao;
import models.CriminalRecord;

import javax.inject.Inject;

public class DeleteCriminalRecordActivity {
    private final CriminalRecordDao criminalRecordDao;

    @Inject
    public DeleteCriminalRecordActivity(CriminalRecordDao criminalRecordDao) {
        this.criminalRecordDao = criminalRecordDao;
    }

    public String handleRequest(String ssn) {

        return criminalRecordDao.deleteCriminalRecord(ssn);
    }

}
