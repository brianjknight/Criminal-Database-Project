package main.java.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import main.java.activity.CreateCriminalRecordActivity;
import main.java.dependency.CriminalRecordServiceComponent;
import main.java.dependency.DaggerCriminalRecordServiceComponent;
import main.java.models.CriminalRecord;
import main.java.models.requests.CreateCriminalRecordRequest;

/**
 * Class to provide interaction with AWS Lambda function for CreateCriminalRecordActivity.
 */
public class CreateCriminalRecordActivityProvider implements
        RequestHandler<CreateCriminalRecordRequest, CriminalRecord> {
    private CriminalRecordServiceComponent dagger = DaggerCriminalRecordServiceComponent.create();
    private CreateCriminalRecordActivity createCriminalRecordActivity = dagger.provideCreateCriminalRecordActivity();

    public CriminalRecord handleRequest(CreateCriminalRecordRequest createCriminalRecordRequest, Context context) {
        return createCriminalRecordActivity.handleRequest(createCriminalRecordRequest, context);
    }
}
