package main.java.App;

import com.amazon.ata.aws.dynamodb.DynamoDbClientProvider;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import main.java.activity.GetCriminalsRecordsByStateActivity;
import main.java.activity.dao.CrimeDao;
import main.java.activity.dao.CriminalRecordDao;
import main.java.models.CriminalRecord;
import main.java.models.requests.GetCriminalsRecordsByStateRequest;

import java.util.List;

/**
 * App for testing activities and accessing the DynamoDB tables.
 */
public class TestApp {

    /**
     * Main method to test activities.
     * @param args main method.
     */
    public static void main(String[] args) {

        DynamoDBMapper mapper = new DynamoDBMapper(DynamoDbClientProvider.getDynamoDBClient());
        CriminalRecordDao criminalRecordDao = new CriminalRecordDao(mapper);
        CrimeDao crimeDao = new CrimeDao(mapper);

        //Test get one record
        //        GetCriminalRecordRequest getBartFart = GetCriminalRecordRequest.builder()
        //                .withSsn("777-66-5555")
        //                .build();
        //        GetCriminalRecordActivity getCriminalRecordActivity =
        //        new GetCriminalRecordActivity(criminalRecordDao);
        //        CriminalRecord bart = getCriminalRecordActivity.handleRequest(getBartFart, null);
        //        System.out.println(bart);
        System.out.println("-".repeat(150));

        //Test get records by state:
        GetCriminalsRecordsByStateRequest getRecordsByStateRequest = GetCriminalsRecordsByStateRequest.builder()
                .withState("CA")
                .withMinNumCrimes(3)
                .withMaxNumCrimes(5)
                .build();
        GetCriminalsRecordsByStateActivity getCriminalsRecordsByStateActivity =
                new GetCriminalsRecordsByStateActivity(criminalRecordDao);
        List<CriminalRecord> result = getCriminalsRecordsByStateActivity
                .handleRequest(getRecordsByStateRequest, null);
        for (CriminalRecord criminalRecord : result) {
            System.out.println(criminalRecord);
        }
        System.out.println("-".repeat(150));

    }

}
