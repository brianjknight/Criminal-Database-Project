package main.java.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import main.java.activity.dao.CriminalRecordDao;
import main.java.models.CriminalRecord;
import main.java.models.requests.GetCriminalRecordRequest;

import javax.inject.Inject;

/**
 * Implementation of the Criminal Record Service API for retrieving a CriminalRecord.
 */
public class GetCriminalRecordActivity implements RequestHandler<GetCriminalRecordRequest, CriminalRecord> {
    private final CriminalRecordDao criminalRecordDao;

    /**
     * Instantiate a new GetCriminalRecordActivity object.
     *
     * @param criminalRecordDao CriminalRecordDao to access CriminalRecords table.
     */
    @Inject
    public GetCriminalRecordActivity(CriminalRecordDao criminalRecordDao) {
        this.criminalRecordDao = criminalRecordDao;
    }

    /**
     * This method handles the input request object by retrieving a CriminalRecord.
     *
     * @param getCriminalRecordRequest request object containing a SSN.
     * @param context The Lambda execution environment context object.
     * @return returns a CriminalRecord object.
     */
    public CriminalRecord handleRequest(GetCriminalRecordRequest getCriminalRecordRequest, Context context) {
        return criminalRecordDao.getCriminalRecord(getCriminalRecordRequest.getSsn());
    }
}
