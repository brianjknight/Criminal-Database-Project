package main.java.activity;

import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import main.java.activity.dao.CriminalRecordDao;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CreateCriminalRecordActivity_Factory
    implements Factory<CreateCriminalRecordActivity> {
  private final Provider<CriminalRecordDao> criminalRecordDaoProvider;

  public CreateCriminalRecordActivity_Factory(
      Provider<CriminalRecordDao> criminalRecordDaoProvider) {
    this.criminalRecordDaoProvider = criminalRecordDaoProvider;
  }

  @Override
  public CreateCriminalRecordActivity get() {
    return new CreateCriminalRecordActivity(criminalRecordDaoProvider.get());
  }

  public static CreateCriminalRecordActivity_Factory create(
      Provider<CriminalRecordDao> criminalRecordDaoProvider) {
    return new CreateCriminalRecordActivity_Factory(criminalRecordDaoProvider);
  }
}
