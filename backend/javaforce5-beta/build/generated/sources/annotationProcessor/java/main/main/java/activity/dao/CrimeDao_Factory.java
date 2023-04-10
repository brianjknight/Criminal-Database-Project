package main.java.activity.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CrimeDao_Factory implements Factory<CrimeDao> {
  private final Provider<DynamoDBMapper> dynamoDBMapperProvider;

  public CrimeDao_Factory(Provider<DynamoDBMapper> dynamoDBMapperProvider) {
    this.dynamoDBMapperProvider = dynamoDBMapperProvider;
  }

  @Override
  public CrimeDao get() {
    return new CrimeDao(dynamoDBMapperProvider.get());
  }

  public static CrimeDao_Factory create(Provider<DynamoDBMapper> dynamoDBMapperProvider) {
    return new CrimeDao_Factory(dynamoDBMapperProvider);
  }
}
