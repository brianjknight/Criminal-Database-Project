package main.java.converter;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import main.java.models.Crime;

import java.util.List;

/**
 * Class for converting DynamoDB string JSON into a list of CriminalRecord obejcts.
 */
public class CrimeListConverter implements DynamoDBTypeConverter<String, List> {
    private static final Gson GSON = new Gson();

    @Override
    public String convert(List list) {
        return GSON.toJson(list);
    }

    @Override
    public List unconvert(String dynamoDbRepresentation) {
        return GSON.fromJson(dynamoDbRepresentation, new TypeToken<List<Crime>>() {} .getType());
    }
}
