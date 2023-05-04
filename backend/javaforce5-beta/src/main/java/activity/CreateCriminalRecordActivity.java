package main.java.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import main.java.activity.dao.CriminalRecordDao;
import main.java.exceptions.CriminalRecordAlreadyExistsException;
import main.java.exceptions.NoCriminalRecordFoundException;
import main.java.models.CriminalRecord;
import main.java.models.requests.CreateCriminalRecordRequest;

import javax.inject.Inject;

/**
 * Implementation of the Criminal Record Service API for creating a new CriminalRecord.
 */
public class CreateCriminalRecordActivity implements RequestHandler<CreateCriminalRecordRequest, CriminalRecord> {
    private final CriminalRecordDao criminalRecordDao;

    /**
     * Instantiate a new CreateCriminalRecordActivity object.
     *
     * @param criminalRecordDao CriminalRecordDao to access CriminalRecords table.
     */
    @Inject
    public CreateCriminalRecordActivity(CriminalRecordDao criminalRecordDao) {
        this.criminalRecordDao = criminalRecordDao;
    }

    /**
     * This method handles the input request object by creating a new CriminalRecord.
     *
     * @param createCriminalRecordRequest request object containing a SSN, name, dob, and state.
     * @param context The Lambda execution environment context object.
     * @return returns the newly created CriminalRecord.
     */
    public CriminalRecord handleRequest(CreateCriminalRecordRequest createCriminalRecordRequest, Context context) {
        String ssn = createCriminalRecordRequest.getSsn();

        CriminalRecord criminalRecord = CriminalRecord.builder()
                .withSsn(ssn)
                .withName(createCriminalRecordRequest.getName())
                .withDob(createCriminalRecordRequest.getDob())
                .withState(createCriminalRecordRequest.getState())
                .withCrimeCount(0)
                .withCrimes(null)
                .build();

        try {
            CriminalRecord cr = criminalRecordDao.getCriminalRecord(ssn);
            throw new CriminalRecordAlreadyExistsException(ssn);
        } catch(NoCriminalRecordFoundException e) {
            criminalRecordDao.saveCriminalRecord(criminalRecord);
        }

        return criminalRecord;
    }

}
