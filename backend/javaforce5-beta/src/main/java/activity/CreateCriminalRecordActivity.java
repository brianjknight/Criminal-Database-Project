package main.java.activity;

import com.amazonaws.Request;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import main.java.dao.CriminalRecordDao;
import main.java.models.CriminalRecord;
import main.java.models.requests.CreateCriminalRecordRequest;

import javax.inject.Inject;

public class CreateCriminalRecordActivity implements RequestHandler<CreateCriminalRecordRequest, CriminalRecord> {
    private final CriminalRecordDao criminalRecordDao;

    @Inject
    public CreateCriminalRecordActivity(CriminalRecordDao criminalRecordDao) {
        this.criminalRecordDao = criminalRecordDao;
    }

    public CriminalRecord handleRequest(CreateCriminalRecordRequest createCriminalRecordRequest, Context context) {
        CriminalRecord criminalRecord = CriminalRecord.builder()
                .withSsn(createCriminalRecordRequest.getSsn())
                .withName(createCriminalRecordRequest.getName())
                .withDob(createCriminalRecordRequest.getDob())
                .withState(createCriminalRecordRequest.getState())
                .withCrimeCount(0)
                .withCrimes(null)
                .build();

        criminalRecordDao.saveCriminalRecord(criminalRecord);

        return criminalRecord;
    }

}
