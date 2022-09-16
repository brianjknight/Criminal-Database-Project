package activity;

import dao.CriminalRecordDao;
import models.CriminalRecord;

import java.util.List;

public class GetCriminalsRecordsByStateActivity {
    CriminalRecordDao criminalRecordDao;

    public GetCriminalsRecordsByStateActivity(CriminalRecordDao criminalRecordDao) {
        this.criminalRecordDao = criminalRecordDao;
    }

    public List<CriminalRecord> handleRequest(String state) {
        List<CriminalRecord> resultList = criminalRecordDao.getCriminalRecordsByState(state);
        return resultList;
    }
}
