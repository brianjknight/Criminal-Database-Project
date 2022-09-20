package main.java.data;

import main.java.activity.AddCrimeToCriminalRecordActivity;
import main.java.activity.CreateCriminalRecordActivity;
import com.amazon.ata.aws.dynamodb.DynamoDbClientProvider;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import main.java.dao.CrimeDao;
import main.java.dao.CriminalRecordDao;
import main.java.models.CriminalRecord;

public class PopulateCriminalRecords {
    public static void main(String[] args) {
        DynamoDBMapper mapper = new DynamoDBMapper(DynamoDbClientProvider.getDynamoDBClient());
        CriminalRecordDao criminalRecordDao = new CriminalRecordDao(mapper);
        CrimeDao crimeDao = new CrimeDao(mapper);

        CreateCriminalRecordActivity create = new CreateCriminalRecordActivity(criminalRecordDao);
        CriminalRecord john = create.handleRequest("111-22-0000", "John McClane", "01/30/1953", "CA");
        CriminalRecord marsellus = create.handleRequest("121-99-7777", "Marsellus Wallace", "10/31/1948", "CA");
        CriminalRecord billy = create.handleRequest("123-11-8888", "Billy Joe Bob III", "3/1/2010", "AL");
        CriminalRecord pink = create.handleRequest("123-45-6789", "Mr. Pink", "8/27/1970", "CA");
        CriminalRecord beatrix = create.handleRequest("123-45-8888", "Beatrix Kiddo", "1977", "CA");
        CriminalRecord django = create.handleRequest("222-22-2020", "Django", "7/5/1825", "AL");
        CriminalRecord aldo = create.handleRequest("333-22-1111", "Lt. Aldo Raine", "6/6/1915", "AL");
        CriminalRecord indiana = create.handleRequest("555-00-5555", "Indiana Jones", "4/20/1905", "CA");
        CriminalRecord bart = create.handleRequest("777-66-5555", "Bart Fart", "1/1/2015", "CA");
        CriminalRecord ivan  = create.handleRequest("999-77-5555", "Ivan the Insubordinate", "11/22/1517", "n/a");

        AddCrimeToCriminalRecordActivity addCrime = new AddCrimeToCriminalRecordActivity(criminalRecordDao, crimeDao);
        addCrime.handleRequest("111-22-0000", "AB110033");
        addCrime.handleRequest("121-99-7777", "VC991133");
        addCrime.handleRequest("123-11-8888", "LM123132");
        addCrime.handleRequest("123-45-6789", "XY123456");
        addCrime.handleRequest("123-45-8888", "QQ010199");
        addCrime.handleRequest("222-22-2020", "HH112200");
        addCrime.handleRequest("333-22-1111", "DD242424");
        addCrime.handleRequest("555-00-5555", "KK990099");
        addCrime.handleRequest("777-66-5555", "EW001122");
        addCrime.handleRequest("777-66-5555", "TR440912");
        addCrime.handleRequest("999-77-5555", "TU789789");
    }
}
