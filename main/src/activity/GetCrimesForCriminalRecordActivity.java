package activity;

import dao.CriminalRecordDao;
import models.Crime;
import models.CriminalRecord;

import java.util.ArrayList;
import java.util.List;

public class GetCrimesForCriminalRecordActivity {

    CriminalRecordDao criminalRecordDao;

    public GetCrimesForCriminalRecordActivity(CriminalRecordDao criminalRecordDao) {
        this.criminalRecordDao = criminalRecordDao;
    }

    public List<Crime> handleRequest(String ssn) {
        CriminalRecord requestCriminalRecord = criminalRecordDao.getCriminalRecord(ssn);
        List<Crime> crimeList = requestCriminalRecord.getCrimes();
        if(crimeList == null) {
            crimeList = new ArrayList<>();
        }

        return crimeList;
    }

}
