package main.java.lambda;

import main.java.activity.GetCriminalRecordActivity;
import main.java.dependency.CriminalRecordServiceComponent;
import main.java.dependency.DaggerCriminalRecordServiceComponent;
import main.java.models.CriminalRecord;

public class GetCriminalRecordActivityProvider {
    CriminalRecordServiceComponent dagger = DaggerCriminalRecordServiceComponent.create();
    GetCriminalRecordActivity getCriminalRecordActivity = dagger.provideGetCriminalRecordActivity();

    public GetCriminalRecordActivityProvider(){}

    public CriminalRecord handleRequest(String ssn) {
        return getCriminalRecordActivity.handleRequest(ssn);
    }

}
