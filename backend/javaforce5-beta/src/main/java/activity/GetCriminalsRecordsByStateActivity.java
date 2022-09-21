package main.java.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import main.java.dao.CriminalRecordDao;
import main.java.models.CriminalRecord;
import main.java.models.requests.GetCriminalsRecordsByStateRequest;

import javax.inject.Inject;
import java.util.List;

public class GetCriminalsRecordsByStateActivity implements RequestHandler<GetCriminalsRecordsByStateRequest, List<CriminalRecord>> {
    CriminalRecordDao criminalRecordDao;

    @Inject
    public GetCriminalsRecordsByStateActivity(CriminalRecordDao criminalRecordDao) {
        this.criminalRecordDao = criminalRecordDao;
    }

    public List<CriminalRecord> handleRequest(GetCriminalsRecordsByStateRequest getCriminalsRecordsByStateRequest, Context context) {
        List<CriminalRecord> resultList = criminalRecordDao.getCriminalRecordsByState(getCriminalsRecordsByStateRequest.getState());
        return resultList;
    }
}
