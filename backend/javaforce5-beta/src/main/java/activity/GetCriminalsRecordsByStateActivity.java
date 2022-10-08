package main.java.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import main.java.dao.CriminalRecordDao;
import main.java.models.CriminalRecord;
import main.java.models.requests.GetCriminalsRecordsByStateRequest;

import javax.inject.Inject;
import java.util.List;

/**
 * Implementation of the Criminal Record Service API for retrieving CriminalRecords by state with optional crimeCount query.
 */
public class GetCriminalsRecordsByStateActivity implements RequestHandler<GetCriminalsRecordsByStateRequest, List<CriminalRecord>> {
    CriminalRecordDao criminalRecordDao;

    /**
     * Instantiate a new GetCriminalsRecordsByStateActivity object.
     *
     * @param criminalRecordDao CriminalRecordDao to access CriminalRecords table.
     */
    @Inject
    public GetCriminalsRecordsByStateActivity(CriminalRecordDao criminalRecordDao) {
        this.criminalRecordDao = criminalRecordDao;
    }

    /**
     * This method handles the input request object by creating a new CriminalRecord.
     *
     * @param getCriminalsRecordsByStateRequest request object containing a state and optional minimum and maximum number of crimes.
     * @param context The Lambda execution environment context object.
     * @return returns a list of CriminalRecord objects.
     */
    public List<CriminalRecord> handleRequest(GetCriminalsRecordsByStateRequest getCriminalsRecordsByStateRequest, Context context) {
        List<CriminalRecord> resultList = criminalRecordDao.getCriminalRecordsByState(getCriminalsRecordsByStateRequest);
        return resultList;
    }
}
