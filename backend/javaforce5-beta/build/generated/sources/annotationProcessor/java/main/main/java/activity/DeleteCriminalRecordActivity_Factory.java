package main.java.activity;

import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import main.java.activity.dao.CriminalRecordDao;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DeleteCriminalRecordActivity_Factory
    implements Factory<DeleteCriminalRecordActivity> {
  private final Provider<CriminalRecordDao> criminalRecordDaoProvider;

  public DeleteCriminalRecordActivity_Factory(
      Provider<CriminalRecordDao> criminalRecordDaoProvider) {
    this.criminalRecordDaoProvider = criminalRecordDaoProvider;
  }

  @Override
  public DeleteCriminalRecordActivity get() {
    return new DeleteCriminalRecordActivity(criminalRecordDaoProvider.get());
  }

  public static DeleteCriminalRecordActivity_Factory create(
      Provider<CriminalRecordDao> criminalRecordDaoProvider) {
    return new DeleteCriminalRecordActivity_Factory(criminalRecordDaoProvider);
  }
}
