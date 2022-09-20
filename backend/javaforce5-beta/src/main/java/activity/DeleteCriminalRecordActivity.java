package main.java.activity;

import main.java.dao.CriminalRecordDao;

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
