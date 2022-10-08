package main.java.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import main.java.dependency.CriminalRecordServiceComponent;
import main.java.dependency.DaggerCriminalRecordServiceComponent;
import main.java.models.CriminalRecord;
import main.java.models.requests.GetCriminalRecordRequest;

/**
 * Class to provide interaction with AWS Lambda function for GetCriminalRecordActivity.
 */
public class GetCriminalRecordActivityProvider implements RequestHandler<GetCriminalRecordRequest, CriminalRecord> {
    CriminalRecordServiceComponent dagger = DaggerCriminalRecordServiceComponent.create();

    /**
     * No parameter constructor.
     */
    public GetCriminalRecordActivityProvider(){}

    public CriminalRecord handleRequest(GetCriminalRecordRequest getCriminalRecordRequest, Context context) {
        return dagger.provideGetCriminalRecordActivity().handleRequest(getCriminalRecordRequest, context);
    }

}
