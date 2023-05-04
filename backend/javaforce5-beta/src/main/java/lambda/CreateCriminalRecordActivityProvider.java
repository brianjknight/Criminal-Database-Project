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

    /**
     * Request handler layer to access adding new criminal record activity class and DAO.
     * @param createCriminalRecordRequest The Lambda Function input
     * @param context The Lambda execution environment context object.
     * @return
     */
    public CriminalRecord handleRequest(CreateCriminalRecordRequest createCriminalRecordRequest, Context context) {
        return createCriminalRecordActivity.handleRequest(createCriminalRecordRequest, context);
    }
}
