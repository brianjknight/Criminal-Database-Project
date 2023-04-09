package main.java.activity;

import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import main.java.activity.dao.CriminalRecordDao;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GetCriminalRecordActivity_Factory implements Factory<GetCriminalRecordActivity> {
  private final Provider<CriminalRecordDao> criminalRecordDaoProvider;

  public GetCriminalRecordActivity_Factory(Provider<CriminalRecordDao> criminalRecordDaoProvider) {
    this.criminalRecordDaoProvider = criminalRecordDaoProvider;
  }

  @Override
  public GetCriminalRecordActivity get() {
    return new GetCriminalRecordActivity(criminalRecordDaoProvider.get());
  }

  public static GetCriminalRecordActivity_Factory create(
      Provider<CriminalRecordDao> criminalRecordDaoProvider) {
    return new GetCriminalRecordActivity_Factory(criminalRecordDaoProvider);
  }
}
