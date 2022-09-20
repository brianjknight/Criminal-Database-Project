package main.java.lambda;

import main.java.activity.GetCrimesForCriminalRecordActivity;
import main.java.dependency.CriminalRecordServiceComponent;
import main.java.dependency.DaggerCriminalRecordServiceComponent;
import main.java.models.Crime;

import java.util.List;

public class GetCrimesForCriminalRecordActivityProvider {
    CriminalRecordServiceComponent dagger = DaggerCriminalRecordServiceComponent.create();
    GetCrimesForCriminalRecordActivity getCrimesForCriminalRecordActivity = dagger.provideGetCrimesForCriminalRecordActivity();

    public List<Crime> handleRequest(String ssn) {
        return getCrimesForCriminalRecordActivity.handleRequest(ssn);
    }
}
