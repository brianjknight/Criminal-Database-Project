package main.java.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import main.java.activity.GetCriminalRecordActivity;
import main.java.dependency.CriminalRecordServiceComponent;
import main.java.dependency.DaggerCriminalRecordServiceComponent;
import main.java.models.CriminalRecord;
import main.java.models.requests.GetCriminalRecordRequest;

public class GetCriminalRecordActivityProvider implements RequestHandler<GetCriminalRecordRequest, CriminalRecord> {
    CriminalRecordServiceComponent dagger = DaggerCriminalRecordServiceComponent.create();
//    GetCriminalRecordActivity getCriminalRecordActivity = dagger.provideGetCriminalRecordActivity();

    public GetCriminalRecordActivityProvider(){}

    public CriminalRecord handleRequest(GetCriminalRecordRequest getCriminalRecordRequest, Context context) {
        return dagger.provideGetCriminalRecordActivity().handleRequest(getCriminalRecordRequest, context);
    }

}
