package main.java.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import main.java.dao.CriminalRecordDao;
import main.java.models.CriminalRecord;
import main.java.models.requests.CreateCriminalRecordRequest;

import javax.inject.Inject;

/**
 * Implementation of the Criminal Record Service API for creating a new CriminalRecord.
 */
public class CreateCriminalRecordActivity implements RequestHandler<CreateCriminalRecordRequest, CriminalRecord> {
    private final CriminalRecordDao criminalRecordDao;

    /**
     * 
     * @param criminalRecordDao
     */
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

        //TODO make an exception to throw if a criminal record already exists for the person you are trying to create a new record for.

        criminalRecordDao.saveCriminalRecord(criminalRecord);

        return criminalRecord;
    }

}
