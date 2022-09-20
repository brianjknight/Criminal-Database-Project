package activity;

import dao.CriminalRecordDao;
import models.CriminalRecord;

import javax.inject.Inject;
import java.util.List;

public class GetCriminalsRecordsByStateActivity {
    CriminalRecordDao criminalRecordDao;

    @Inject
    public GetCriminalsRecordsByStateActivity(CriminalRecordDao criminalRecordDao) {
        this.criminalRecordDao = criminalRecordDao;
    }

    public List<CriminalRecord> handleRequest(String state) {
        List<CriminalRecord> resultList = criminalRecordDao.getCriminalRecordsByState(state);
        return resultList;
    }
}
