package main.java.dependency;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MapperModule_ProvideDynamoDBMapperFactory implements Factory<DynamoDBMapper> {
  private final MapperModule module;

  public MapperModule_ProvideDynamoDBMapperFactory(MapperModule module) {
    this.module = module;
  }

  @Override
  public DynamoDBMapper get() {
    return Preconditions.checkNotNull(
        module.provideDynamoDBMapper(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static MapperModule_ProvideDynamoDBMapperFactory create(MapperModule module) {
    return new MapperModule_ProvideDynamoDBMapperFactory(module);
  }

  public static DynamoDBMapper proxyProvideDynamoDBMapper(MapperModule instance) {
    return Preconditions.checkNotNull(
        instance.provideDynamoDBMapper(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
