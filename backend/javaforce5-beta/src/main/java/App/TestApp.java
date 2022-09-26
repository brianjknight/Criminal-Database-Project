package main.java.App;

import com.amazon.ata.aws.dynamodb.DynamoDbClientProvider;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import main.java.activity.GetCriminalRecordActivity;
import main.java.activity.GetCriminalsRecordsByStateActivity;
import main.java.dao.CrimeDao;
import main.java.dao.CriminalRecordDao;
import main.java.models.CriminalRecord;
import main.java.models.requests.GetCriminalRecordRequest;
import main.java.models.requests.GetCriminalsRecordsByStateRequest;

import java.util.List;

public class TestApp {
    public static void main(String[] args) {

        DynamoDBMapper mapper = new DynamoDBMapper(DynamoDbClientProvider.getDynamoDBClient());
        CriminalRecordDao criminalRecordDao = new CriminalRecordDao(mapper);
        CrimeDao crimeDao = new CrimeDao(mapper);

        //Test get one record
        GetCriminalRecordRequest getBartFart = GetCriminalRecordRequest.builder()
                .withSsn("777-66-5555")
                .build();
        GetCriminalRecordActivity getCriminalRecordActivity = new GetCriminalRecordActivity(criminalRecordDao);
        CriminalRecord bart = getCriminalRecordActivity.handleRequest(getBartFart, null);
        System.out.println(bart);
        System.out.println("-".repeat(80));

        //Test get records by state:
        GetCriminalsRecordsByStateRequest getRecordsCalifornia = GetCriminalsRecordsByStateRequest.builder()
                .withState("CA")
                .build();
        GetCriminalsRecordsByStateActivity getCriminalsRecordsByStateActivity = new GetCriminalsRecordsByStateActivity(criminalRecordDao);
        List<CriminalRecord> result = getCriminalsRecordsByStateActivity.handleRequest(getRecordsCalifornia, null);
        for(CriminalRecord criminalRecord : result) {
            System.out.println(criminalRecord);
        }
        System.out.println("-".repeat(80));

    }

}
