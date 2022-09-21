package main.java.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import main.java.activity.AddCrimeToCriminalRecordActivity;
import main.java.dependency.CriminalRecordServiceComponent;
import main.java.dependency.DaggerCriminalRecordServiceComponent;
import main.java.models.CriminalRecord;
import main.java.models.requests.AddCrimeToCriminalRecordRequest;

import java.util.List;

public class AddCrimeToCriminalRecordActivityProvider implements RequestHandler<AddCrimeToCriminalRecordRequest, CriminalRecord> {
    CriminalRecordServiceComponent dagger = DaggerCriminalRecordServiceComponent.create();
    AddCrimeToCriminalRecordActivity addCrimeToCriminalRecordActivity = dagger.provideAddCrimeToCriminalRecordActivity();

    public CriminalRecord handleRequest(AddCrimeToCriminalRecordRequest addCrimeToCriminalRecordRequest, Context context) {
        return addCrimeToCriminalRecordActivity.handleRequest(addCrimeToCriminalRecordRequest, context);
    }
}
