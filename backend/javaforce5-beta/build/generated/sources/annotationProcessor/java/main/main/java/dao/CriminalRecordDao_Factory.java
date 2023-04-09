package main.java.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dagger.internal.Factory;
import main.java.activity.dao.CriminalRecordDao;

import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CriminalRecordDao_Factory implements Factory<CriminalRecordDao> {
  private final Provider<DynamoDBMapper> dynamoDBMapperProvider;

  public CriminalRecordDao_Factory(Provider<DynamoDBMapper> dynamoDBMapperProvider) {
    this.dynamoDBMapperProvider = dynamoDBMapperProvider;
  }

  @Override
  public CriminalRecordDao get() {
    return new CriminalRecordDao(dynamoDBMapperProvider.get());
  }

  public static CriminalRecordDao_Factory create(Provider<DynamoDBMapper> dynamoDBMapperProvider) {
    return new CriminalRecordDao_Factory(dynamoDBMapperProvider);
  }
}
