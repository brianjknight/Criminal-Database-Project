package main.java.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import main.java.activity.GetCrimesForCriminalRecordActivity;
import main.java.dependency.CriminalRecordServiceComponent;
import main.java.dependency.DaggerCriminalRecordServiceComponent;
import main.java.models.Crime;
import main.java.models.requests.GetCrimesForCriminalRecordRequest;

import java.util.List;

/**
 * Class to provide interaction with AWS Lambda function for GetCrimesForCriminalRecordActivity.
 */
public class GetCrimesForCriminalRecordActivityProvider implements RequestHandler<GetCrimesForCriminalRecordRequest, List<Crime>> {
    CriminalRecordServiceComponent dagger = DaggerCriminalRecordServiceComponent.create();
    GetCrimesForCriminalRecordActivity getCrimesForCriminalRecordActivity = dagger.provideGetCrimesForCriminalRecordActivity();

    /**
     * Request handler layer to access getting crimes for a criminal record activity class and DAO.
     * @param getCrimesForCriminalRecordRequest The Lambda Function input
     * @param context The Lambda execution environment context object.
     * @return
     */
    public List<Crime> handleRequest(GetCrimesForCriminalRecordRequest getCrimesForCriminalRecordRequest, Context context) {
        return getCrimesForCriminalRecordActivity.handleRequest(getCrimesForCriminalRecordRequest, context);
    }
}
