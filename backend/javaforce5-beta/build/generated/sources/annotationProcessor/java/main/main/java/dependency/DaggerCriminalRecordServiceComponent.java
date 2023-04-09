package main.java.dependency;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import main.java.activity.AddCrimeToCriminalRecordActivity;
import main.java.activity.CreateCriminalRecordActivity;
import main.java.activity.DeleteCriminalRecordActivity;
import main.java.activity.GetCrimesForCriminalRecordActivity;
import main.java.activity.GetCriminalRecordActivity;
import main.java.activity.GetCriminalsRecordsByStateActivity;
import main.java.activity.dao.CrimeDao;
import main.java.activity.dao.CriminalRecordDao;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerCriminalRecordServiceComponent implements CriminalRecordServiceComponent {
  private Provider<DynamoDBMapper> provideDynamoDBMapperProvider;

  private DaggerCriminalRecordServiceComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static CriminalRecordServiceComponent create() {
    return new Builder().build();
  }

  private CriminalRecordDao getCriminalRecordDao() {
    return new CriminalRecordDao(provideDynamoDBMapperProvider.get());
  }

  private CrimeDao getCrimeDao() {
    return new CrimeDao(provideDynamoDBMapperProvider.get());
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.provideDynamoDBMapperProvider =
        DoubleCheck.provider(
            MapperModule_ProvideDynamoDBMapperFactory.create(builder.mapperModule));
  }

  @Override
  public AddCrimeToCriminalRecordActivity provideAddCrimeToCriminalRecordActivity() {
    return new AddCrimeToCriminalRecordActivity(getCriminalRecordDao(), getCrimeDao());
  }

  @Override
  public CreateCriminalRecordActivity provideCreateCriminalRecordActivity() {
    return new CreateCriminalRecordActivity(getCriminalRecordDao());
  }

  @Override
  public DeleteCriminalRecordActivity provideDeleteCriminalRecordActivity() {
    return new DeleteCriminalRecordActivity(getCriminalRecordDao());
  }

  @Override
  public GetCrimesForCriminalRecordActivity provideGetCrimesForCriminalRecordActivity() {
    return new GetCrimesForCriminalRecordActivity(getCriminalRecordDao());
  }

  @Override
  public GetCriminalRecordActivity provideGetCriminalRecordActivity() {
    return new GetCriminalRecordActivity(getCriminalRecordDao());
  }

  @Override
  public GetCriminalsRecordsByStateActivity provideGetCriminalsRecordsByStateActivity() {
    return new GetCriminalsRecordsByStateActivity(getCriminalRecordDao());
  }

  public static final class Builder {
    private MapperModule mapperModule;

    private Builder() {}

    public CriminalRecordServiceComponent build() {
      if (mapperModule == null) {
        this.mapperModule = new MapperModule();
      }
      return new DaggerCriminalRecordServiceComponent(this);
    }

    public Builder mapperModule(MapperModule mapperModule) {
      this.mapperModule = Preconditions.checkNotNull(mapperModule);
      return this;
    }
  }
}
