package main.java.lambda;

import main.java.activity.DeleteCriminalRecordActivity;
import main.java.dependency.CriminalRecordServiceComponent;
import main.java.dependency.DaggerCriminalRecordServiceComponent;

public class DeleteCriminalRecordActivityProvider {
    private CriminalRecordServiceComponent dagger = DaggerCriminalRecordServiceComponent.create();
    private DeleteCriminalRecordActivity deleteCriminalRecordActivity = dagger.provideDeleteCriminalRecordActivity();

    public String handleRequest(String ssn) {
        return deleteCriminalRecordActivity.handleRequest(ssn);
    }
}
