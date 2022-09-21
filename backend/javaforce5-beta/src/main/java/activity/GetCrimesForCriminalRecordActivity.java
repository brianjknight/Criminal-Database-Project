package main.java.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import main.java.dao.CriminalRecordDao;
import main.java.models.Crime;
import main.java.models.CriminalRecord;
import main.java.models.requests.GetCrimesForCriminalRecordRequest;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class GetCrimesForCriminalRecordActivity implements RequestHandler<GetCrimesForCriminalRecordRequest, List<Crime>> {

    CriminalRecordDao criminalRecordDao;

    @Inject
    public GetCrimesForCriminalRecordActivity(CriminalRecordDao criminalRecordDao) {
        this.criminalRecordDao = criminalRecordDao;
    }

    public List<Crime> handleRequest(GetCrimesForCriminalRecordRequest getCrimesForCriminalRecordRequest, Context context) {
        CriminalRecord requestCriminalRecord = criminalRecordDao.getCriminalRecord(getCrimesForCriminalRecordRequest.getSsn());
        List<Crime> crimeList = requestCriminalRecord.getCrimes();
        if(crimeList == null) {
            crimeList = new ArrayList<>();
        }

        return crimeList;
    }

}
