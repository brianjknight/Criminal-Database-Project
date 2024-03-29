package main.java.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import main.java.activity.AddCrimeToCriminalRecordActivity;
import main.java.dependency.CriminalRecordServiceComponent;
import main.java.dependency.DaggerCriminalRecordServiceComponent;
import main.java.models.CriminalRecord;
import main.java.models.requests.AddCrimeToCriminalRecordRequest;

/**
 * Class to provide interaction with AWS Lambda function for AddCrimeToCriminalRecordActivity.
 */
public class AddCrimeToCriminalRecordActivityProvider implements
        RequestHandler<AddCrimeToCriminalRecordRequest, CriminalRecord> {
    CriminalRecordServiceComponent dagger = DaggerCriminalRecordServiceComponent.create();
    AddCrimeToCriminalRecordActivity addCrimeToCriminalRecordActivity =
            dagger.provideAddCrimeToCriminalRecordActivity();

    /**
     * Request handler layer to access adding crime to a criminal record activity class and DAO.
     * @param addCrimeToCriminalRecordRequest The Lambda Function input
     * @param context The Lambda execution environment context object.
     * @return
     */
    public CriminalRecord handleRequest(AddCrimeToCriminalRecordRequest addCrimeToCriminalRecordRequest,
                                        Context context) {
        return addCrimeToCriminalRecordActivity.handleRequest(addCrimeToCriminalRecordRequest, context);
    }
}
