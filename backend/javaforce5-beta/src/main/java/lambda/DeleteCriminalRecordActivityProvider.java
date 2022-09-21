package main.java.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import main.java.activity.DeleteCriminalRecordActivity;
import main.java.dependency.CriminalRecordServiceComponent;
import main.java.dependency.DaggerCriminalRecordServiceComponent;
import main.java.models.requests.DeleteCriminalRecordRequest;

import java.awt.*;

public class DeleteCriminalRecordActivityProvider implements RequestHandler<DeleteCriminalRecordRequest, String> {
    private CriminalRecordServiceComponent dagger = DaggerCriminalRecordServiceComponent.create();
    private DeleteCriminalRecordActivity deleteCriminalRecordActivity = dagger.provideDeleteCriminalRecordActivity();

    public String handleRequest(DeleteCriminalRecordRequest deleteCriminalRecordRequest, Context context) {
        return deleteCriminalRecordActivity.handleRequest(deleteCriminalRecordRequest, context);
    }
}
