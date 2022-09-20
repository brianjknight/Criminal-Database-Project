package main.java.lambda;

import main.java.activity.GetCriminalsRecordsByStateActivity;
import main.java.dependency.CriminalRecordServiceComponent;
import main.java.dependency.DaggerCriminalRecordServiceComponent;
import main.java.models.CriminalRecord;

import java.util.List;

public class GetCriminalsRecordsByStateActivityProvider {
    CriminalRecordServiceComponent dagger = DaggerCriminalRecordServiceComponent.create();
    GetCriminalsRecordsByStateActivity getCriminalsRecordsByStateActivity = dagger.provideGetCriminalsRecordsByStateActivity();

    public List<CriminalRecord> handleRequest(String state) {
        return getCriminalsRecordsByStateActivity.handleRequest(state);
    }
}
