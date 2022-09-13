import activity.CreateCriminalRecordActivity;
import activity.GetCriminalRecordActivity;
import com.amazon.ata.aws.dynamodb.DynamoDbClientProvider;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dao.CriminalRecordDao;
import models.CriminalRecord;

public class MainTest {
    public static void main(String[] args) {

        DynamoDBMapper mapper = new DynamoDBMapper(DynamoDbClientProvider.getDynamoDBClient());
        CriminalRecordDao criminalRecordDao = new CriminalRecordDao(mapper);
        CreateCriminalRecordActivity create = new CreateCriminalRecordActivity(criminalRecordDao);

//        CriminalRecord testCR = create.handleRequest("abc-12-3456", "Joe Biden", "05/10/1930", "MA");
//        System.out.println(testCR);

        GetCriminalRecordActivity getCriminalRecordActivity = new GetCriminalRecordActivity(criminalRecordDao);
        CriminalRecord crJoeBiden = getCriminalRecordActivity.handleRequest("000-99-4444");
        System.out.println(crJoeBiden);

    }
}
