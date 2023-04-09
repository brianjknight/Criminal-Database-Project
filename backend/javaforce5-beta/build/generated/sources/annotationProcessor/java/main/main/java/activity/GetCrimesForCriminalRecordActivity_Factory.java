package main.java.activity;

import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import main.java.activity.dao.CriminalRecordDao;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GetCrimesForCriminalRecordActivity_Factory
    implements Factory<GetCrimesForCriminalRecordActivity> {
  private final Provider<CriminalRecordDao> criminalRecordDaoProvider;

  public GetCrimesForCriminalRecordActivity_Factory(
      Provider<CriminalRecordDao> criminalRecordDaoProvider) {
    this.criminalRecordDaoProvider = criminalRecordDaoProvider;
  }

  @Override
  public GetCrimesForCriminalRecordActivity get() {
    return new GetCrimesForCriminalRecordActivity(criminalRecordDaoProvider.get());
  }

  public static GetCrimesForCriminalRecordActivity_Factory create(
      Provider<CriminalRecordDao> criminalRecordDaoProvider) {
    return new GetCrimesForCriminalRecordActivity_Factory(criminalRecordDaoProvider);
  }
}
