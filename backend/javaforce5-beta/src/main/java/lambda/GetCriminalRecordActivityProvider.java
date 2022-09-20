package main.java.lambda;


import com.amazon.ata.aws.dynamodb.DynamoDbClientProvider;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import main.java.activity.GetCriminalRecordActivity;
import main.java.dao.CriminalRecordDao;
import main.java.dependency.CriminalRecordServiceComponent;
import main.java.models.CriminalRecord;

public class GetCriminalRecordActivityProvider {
    DynamoDBMapper mapper = new DynamoDBMapper(DynamoDbClientProvider.getDynamoDBClient());
    CriminalRecordDao criminalRecordDao = new CriminalRecordDao(mapper);
    GetCriminalRecordActivity getCriminalRecordActivity = new GetCriminalRecordActivity(criminalRecordDao);

//    CriminalRecordServiceComponent dagger = DaggerCriminalRecordServiceComponent.create();
//    GetCriminalRecordActivity getCriminalRecordActivity = null;

    public GetCriminalRecordActivityProvider(){}

    public CriminalRecord handleRequest(String ssn) {
        return getCriminalRecordActivity.handleRequest(ssn);
    }

}
