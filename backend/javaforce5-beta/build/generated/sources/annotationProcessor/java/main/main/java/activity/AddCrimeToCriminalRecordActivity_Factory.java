package main.java.activity;

import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import main.java.activity.dao.CrimeDao;
import main.java.activity.dao.CriminalRecordDao;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AddCrimeToCriminalRecordActivity_Factory
    implements Factory<AddCrimeToCriminalRecordActivity> {
  private final Provider<CriminalRecordDao> criminalRecordDaoProvider;

  private final Provider<CrimeDao> crimeDaoProvider;

  public AddCrimeToCriminalRecordActivity_Factory(
      Provider<CriminalRecordDao> criminalRecordDaoProvider, Provider<CrimeDao> crimeDaoProvider) {
    this.criminalRecordDaoProvider = criminalRecordDaoProvider;
    this.crimeDaoProvider = crimeDaoProvider;
  }

  @Override
  public AddCrimeToCriminalRecordActivity get() {
    return new AddCrimeToCriminalRecordActivity(
        criminalRecordDaoProvider.get(), crimeDaoProvider.get());
  }

  public static AddCrimeToCriminalRecordActivity_Factory create(
      Provider<CriminalRecordDao> criminalRecordDaoProvider, Provider<CrimeDao> crimeDaoProvider) {
    return new AddCrimeToCriminalRecordActivity_Factory(
        criminalRecordDaoProvider, crimeDaoProvider);
  }
}
