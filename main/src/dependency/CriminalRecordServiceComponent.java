package dependency;

import activity.AddCrimeToCriminalRecordActivity;
import activity.CreateCriminalRecordActivity;
import activity.DeleteCriminalRecordActivity;
import activity.GetCrimesForCriminalRecordActivity;
import activity.GetCriminalRecordActivity;
import activity.GetCriminalsRecordsByStateActivity;
import dagger.Component;

import javax.inject.Singleton;

@Component(modules = {DaoModule.class})
@Singleton
public interface CriminalRecordServiceComponent {
    AddCrimeToCriminalRecordActivity provideAddCrimeToCriminalRecordActivity();
    CreateCriminalRecordActivity provideCreateCriminalRecordActivity();
    DeleteCriminalRecordActivity provideDeleteCriminalRecordActivity();
    GetCrimesForCriminalRecordActivity provideGetCrimesForCriminalRecordActivity();
    GetCriminalRecordActivity provideGetCriminalRecordActivity();
    GetCriminalsRecordsByStateActivity provideGetCriminalsRecordsByStateActivity();
}
