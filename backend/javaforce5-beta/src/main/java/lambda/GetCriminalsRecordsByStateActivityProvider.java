package main.java.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import main.java.activity.GetCriminalsRecordsByStateActivity;
import main.java.dependency.CriminalRecordServiceComponent;
import main.java.dependency.DaggerCriminalRecordServiceComponent;
import main.java.models.CriminalRecord;
import main.java.models.requests.GetCriminalsRecordsByStateRequest;

import java.util.List;

/**
 * Class to provide interaction with AWS Lambda function for GetCriminalsRecordsByStateActivity.
 */
public class GetCriminalsRecordsByStateActivityProvider implements RequestHandler<GetCriminalsRecordsByStateRequest, List<CriminalRecord>> {
    CriminalRecordServiceComponent dagger = DaggerCriminalRecordServiceComponent.create();
    GetCriminalsRecordsByStateActivity getCriminalsRecordsByStateActivity = dagger.provideGetCriminalsRecordsByStateActivity();

    public List<CriminalRecord> handleRequest(GetCriminalsRecordsByStateRequest getCriminalsRecordsByStateRequest, Context context) {
        return getCriminalsRecordsByStateActivity.handleRequest(getCriminalsRecordsByStateRequest, context);
    }
}
