package main.java.lambda;

import main.java.activity.CreateCriminalRecordActivity;
import main.java.dependency.CriminalRecordServiceComponent;
import main.java.dependency.DaggerCriminalRecordServiceComponent;
import main.java.models.CriminalRecord;

public class CreateCriminalRecordActivityProvider {
    private CriminalRecordServiceComponent dagger = DaggerCriminalRecordServiceComponent.create();
    private CreateCriminalRecordActivity createCriminalRecordActivity = dagger.provideCreateCriminalRecordActivity();

    public CriminalRecord handleRequest(String ssn, String name, String dob, String state) {
        return createCriminalRecordActivity.handleRequest(ssn, name, dob, state);
    }
}
