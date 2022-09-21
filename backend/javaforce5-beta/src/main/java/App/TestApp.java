package main.java.App;

import com.amazon.ata.aws.dynamodb.DynamoDbClientProvider;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import main.java.activity.GetCriminalRecordActivity;
import main.java.activity.GetCriminalsRecordsByStateActivity;
import main.java.dao.CrimeDao;
import main.java.dao.CriminalRecordDao;
import main.java.models.CriminalRecord;
import main.java.models.requests.GetCriminalRecordRequest;

import java.util.List;

public class TestApp {
    public static void main(String[] args) {

        DynamoDBMapper mapper = new DynamoDBMapper(DynamoDbClientProvider.getDynamoDBClient());
        CriminalRecordDao criminalRecordDao = new CriminalRecordDao(mapper);
        CrimeDao crimeDao = new CrimeDao(mapper);

        GetCriminalRecordRequest getBartFart = GetCriminalRecordRequest.builder()
                .withSsn("777-66-5555")
                .build();

        GetCriminalRecordActivity getCriminalRecordActivity = new GetCriminalRecordActivity(criminalRecordDao);

        CriminalRecord bartFart = getCriminalRecordActivity.handleRequest(getBartFart, null);
        System.out.println(bartFart);
    }

}
