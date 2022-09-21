package main.java.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import main.java.dao.CriminalRecordDao;
import main.java.models.CriminalRecord;
import main.java.models.requests.GetCriminalRecordRequest;

import javax.inject.Inject;

public class GetCriminalRecordActivity implements RequestHandler<GetCriminalRecordRequest, CriminalRecord> {
    private final CriminalRecordDao criminalRecordDao;

    @Inject
    public GetCriminalRecordActivity(CriminalRecordDao criminalRecordDao) {
        this.criminalRecordDao = criminalRecordDao;
    }

    public CriminalRecord handleRequest(GetCriminalRecordRequest getCriminalRecordRequest, Context context) {
        return criminalRecordDao.getCriminalRecord(getCriminalRecordRequest.getSsn());
    }
}
