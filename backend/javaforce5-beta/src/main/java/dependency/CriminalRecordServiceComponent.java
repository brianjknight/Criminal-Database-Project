package main.java.dependency;

import main.java.activity.AddCrimeToCriminalRecordActivity;
import main.java.activity.CreateCriminalRecordActivity;
import main.java.activity.DeleteCriminalRecordActivity;
import main.java.activity.GetCrimesForCriminalRecordActivity;
import main.java.activity.GetCriminalRecordActivity;
import main.java.activity.GetCriminalsRecordsByStateActivity;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {MapperModule.class})
public interface CriminalRecordServiceComponent {
    AddCrimeToCriminalRecordActivity provideAddCrimeToCriminalRecordActivity();
    CreateCriminalRecordActivity provideCreateCriminalRecordActivity();
    DeleteCriminalRecordActivity provideDeleteCriminalRecordActivity();
    GetCrimesForCriminalRecordActivity provideGetCrimesForCriminalRecordActivity();
    GetCriminalRecordActivity provideGetCriminalRecordActivity();
    GetCriminalsRecordsByStateActivity provideGetCriminalsRecordsByStateActivity();
}
