package lambda;

import activity.GetCriminalRecordActivity;
import com.amazon.ata.aws.dynamodb.DynamoDbClientProvider;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dao.CriminalRecordDao;
import models.CriminalRecord;

public class GetCriminalRecordActivityProvider {
    DynamoDBMapper mapper = new DynamoDBMapper(DynamoDbClientProvider.getDynamoDBClient());
    CriminalRecordDao criminalRecordDao = new CriminalRecordDao(mapper);
    GetCriminalRecordActivity getCriminalRecordActivity = new GetCriminalRecordActivity(criminalRecordDao);

    public GetCriminalRecordActivityProvider(){}

    public CriminalRecord handleRequest(String ssn) {
        return getCriminalRecordActivity.handleRequest(ssn);
    }

}
