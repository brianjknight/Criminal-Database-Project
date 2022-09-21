package main.java.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import main.java.dao.CriminalRecordDao;
import main.java.models.requests.DeleteCriminalRecordRequest;

import javax.inject.Inject;

public class DeleteCriminalRecordActivity implements RequestHandler<DeleteCriminalRecordRequest, String> {
    private final CriminalRecordDao criminalRecordDao;

    @Inject
    public DeleteCriminalRecordActivity(CriminalRecordDao criminalRecordDao) {
        this.criminalRecordDao = criminalRecordDao;
    }

    public String handleRequest(DeleteCriminalRecordRequest deleteCriminalRecordRequest, Context context) {

        return criminalRecordDao.deleteCriminalRecord(deleteCriminalRecordRequest.getSsn());
    }

}
