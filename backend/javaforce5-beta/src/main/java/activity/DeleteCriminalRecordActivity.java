package main.java.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import main.java.activity.dao.CriminalRecordDao;
import main.java.models.requests.DeleteCriminalRecordRequest;

import javax.inject.Inject;

/**
 * Implementation of the Criminal Record Service API for deleting a CriminalRecord from the database.
 */
public class DeleteCriminalRecordActivity implements RequestHandler<DeleteCriminalRecordRequest, String> {
    private final CriminalRecordDao criminalRecordDao;

    /**
     * Instantiate a new DeleteCriminalRecordActivity object.
     *
     * @param criminalRecordDao CriminalRecordDao to access CriminalRecords table.
     */
    @Inject
    public DeleteCriminalRecordActivity(CriminalRecordDao criminalRecordDao) {
        this.criminalRecordDao = criminalRecordDao;
    }

    /**
     * This method handles the input request object by deleting an existing CriminalRecord.
     *
     * @param deleteCriminalRecordRequest request object containing a SSN.
     * @param context The Lambda execution environment context object.
     * @return returns a string message confirming deletion of the record.
     */
    public String handleRequest(DeleteCriminalRecordRequest deleteCriminalRecordRequest, Context context) {

        return criminalRecordDao.deleteCriminalRecord(deleteCriminalRecordRequest.getSsn());
    }

}
