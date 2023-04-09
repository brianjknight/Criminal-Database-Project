package main.java.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import main.java.activity.dao.CriminalRecordDao;
import main.java.models.Crime;
import main.java.models.CriminalRecord;
import main.java.models.requests.GetCrimesForCriminalRecordRequest;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 * Implementation of the Criminal Record Service API for retrieving the Crimes for a given CriminalRecord.
 */
public class GetCrimesForCriminalRecordActivity implements
        RequestHandler<GetCrimesForCriminalRecordRequest, List<Crime>> {

    CriminalRecordDao criminalRecordDao;

    /**
     * Instantiate a new GetCrimesForCriminalRecordActivity object.
     *
     * @param criminalRecordDao CriminalRecordDao to access CriminalRecords table.
     */
    @Inject
    public GetCrimesForCriminalRecordActivity(CriminalRecordDao criminalRecordDao) {
        this.criminalRecordDao = criminalRecordDao;
    }

    /**
     * This method handles the input request object by retrieving Crimes for a given CriminalRecord.
     *
     * @param getCrimesForCriminalRecordRequest request object containing a SSN.
     * @param context The Lambda execution environment context object.
     * @return returns a list of Crime objects for the given SSN.
     */
    public List<Crime> handleRequest(GetCrimesForCriminalRecordRequest getCrimesForCriminalRecordRequest,
                                     Context context) {
        CriminalRecord requestCriminalRecord =
                criminalRecordDao.getCriminalRecord(getCrimesForCriminalRecordRequest.getSsn());
        List<Crime> crimeList = requestCriminalRecord.getCrimes();
        if (crimeList == null) {
            crimeList = new ArrayList<>();
        }

        return crimeList;
    }

}
