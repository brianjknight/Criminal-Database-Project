package main.java.lambda;

import main.java.activity.AddCrimeToCriminalRecordActivity;
import main.java.dependency.CriminalRecordServiceComponent;
import main.java.dependency.DaggerCriminalRecordServiceComponent;
import main.java.models.CriminalRecord;

import java.util.List;

public class AddCrimeToCriminalRecordActivityProvider {
    CriminalRecordServiceComponent dagger = DaggerCriminalRecordServiceComponent.create();
    AddCrimeToCriminalRecordActivity addCrimeToCriminalRecordActivity = dagger.provideAddCrimeToCriminalRecordActivity();

    public CriminalRecord handleRequest(String ssn, String caseNumber) {
        return addCrimeToCriminalRecordActivity.handleRequest(ssn, caseNumber);
    }
}
