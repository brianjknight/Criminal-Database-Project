package main.java.App;

import com.amazon.ata.aws.dynamodb.DynamoDbClientProvider;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import main.java.activity.GetCriminalsRecordsByStateActivity;
import main.java.dao.CrimeDao;
import main.java.dao.CriminalRecordDao;
import main.java.models.CriminalRecord;

import java.util.List;

public class TestApp {
    public static void main(String[] args) {

        DynamoDBMapper mapper = new DynamoDBMapper(DynamoDbClientProvider.getDynamoDBClient());
        CriminalRecordDao criminalRecordDao = new CriminalRecordDao(mapper);
        CrimeDao crimeDao = new CrimeDao(mapper);

//        GetCriminalRecordActivity getCriminalRecordActivity = new GetCriminalRecordActivity(criminalRecordDao);
//        CriminalRecord crJoeBiden = getCriminalRecordActivity.handleRequest("000-99-4444");
//        System.out.println(crJoeBiden);

//        DeleteCriminalRecordActivity deleteCriminalRecordActivity = new DeleteCriminalRecordActivity(criminalRecordDao);
//        System.out.println(deleteCriminalRecordActivity.handleRequest("000-99-4444"));

//        AddCrimeToCriminalRecordActivity addCrime = new AddCrimeToCriminalRecordActivity(criminalRecordDao, crimeDao);
//        CriminalRecord joeB1 = addCrime.handleRequest("000-99-4444", "XY987654");
//        System.out.println(joeB1);
//        System.out.println("-".repeat(80));
//        CriminalRecord joeB2 = addCrime.handleRequest("000-99-4444", "BB009900");
//        System.out.println(joeB2);
//        System.out.println("-".repeat(80));
//        CriminalRecord joeB3 = addCrime.handleRequest("000-99-4444", "PP010101");
//        System.out.println(joeB3);
//        System.out.println("-".repeat(80));

        GetCriminalsRecordsByStateActivity getCRbyState = new GetCriminalsRecordsByStateActivity(criminalRecordDao);
        List<CriminalRecord> recordsForCA = getCRbyState.handleRequest("CA");
        for (CriminalRecord cr : recordsForCA) {
            System.out.println(cr);
        }

    }

}
