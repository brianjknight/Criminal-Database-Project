package main.java.activity;

import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import main.java.dao.CriminalRecordDao;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GetCriminalsRecordsByStateActivity_Factory
    implements Factory<GetCriminalsRecordsByStateActivity> {
  private final Provider<CriminalRecordDao> criminalRecordDaoProvider;

  public GetCriminalsRecordsByStateActivity_Factory(
      Provider<CriminalRecordDao> criminalRecordDaoProvider) {
    this.criminalRecordDaoProvider = criminalRecordDaoProvider;
  }

  @Override
  public GetCriminalsRecordsByStateActivity get() {
    return new GetCriminalsRecordsByStateActivity(criminalRecordDaoProvider.get());
  }

  public static GetCriminalsRecordsByStateActivity_Factory create(
      Provider<CriminalRecordDao> criminalRecordDaoProvider) {
    return new GetCriminalsRecordsByStateActivity_Factory(criminalRecordDaoProvider);
  }
}
