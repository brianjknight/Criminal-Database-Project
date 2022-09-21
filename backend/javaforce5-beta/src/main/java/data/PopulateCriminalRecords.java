package main.java.data;

import main.java.activity.AddCrimeToCriminalRecordActivity;
import main.java.activity.CreateCriminalRecordActivity;
import com.amazon.ata.aws.dynamodb.DynamoDbClientProvider;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import main.java.dao.CrimeDao;
import main.java.dao.CriminalRecordDao;
import main.java.models.CriminalRecord;
import main.java.models.requests.AddCrimeToCriminalRecordRequest;

public class PopulateCriminalRecords {
    public static void main(String[] args) {
        DynamoDBMapper mapper = new DynamoDBMapper(DynamoDbClientProvider.getDynamoDBClient());
        CriminalRecordDao criminalRecordDao = new CriminalRecordDao(mapper);
        CrimeDao crimeDao = new CrimeDao(mapper);

//        CreateCriminalRecordActivity create = new CreateCriminalRecordActivity(criminalRecordDao);
//        CriminalRecord john = create.handleRequest("111-22-0000", "John McClane", "01/30/1953", "CA");
//        CriminalRecord marsellus = create.handleRequest("121-99-7777", "Marsellus Wallace", "10/31/1948", "CA");
//        CriminalRecord billy = create.handleRequest("123-11-8888", "Billy Joe Bob III", "3/1/2010", "AL");
//        CriminalRecord pink = create.handleRequest("123-45-6789", "Mr. Pink", "8/27/1970", "CA");
//        CriminalRecord beatrix = create.handleRequest("123-45-8888", "Beatrix Kiddo", "1977", "CA");
//        CriminalRecord django = create.handleRequest("222-22-2020", "Django", "7/5/1825", "AL");
//        CriminalRecord aldo = create.handleRequest("333-22-1111", "Lt. Aldo Raine", "6/6/1915", "AL");
//        CriminalRecord indiana = create.handleRequest("555-00-5555", "Indiana Jones", "4/20/1905", "CA");
//        CriminalRecord bart = create.handleRequest("777-66-5555", "Bart Fart", "1/1/2015", "CA");
//        CriminalRecord ivan  = create.handleRequest("999-77-5555", "Ivan the Insubordinate", "11/22/1517", "n/a");

        AddCrimeToCriminalRecordActivity addCrime = new AddCrimeToCriminalRecordActivity(criminalRecordDao, crimeDao);

        AddCrimeToCriminalRecordRequest request1 = AddCrimeToCriminalRecordRequest.builder()
                .withSsn("111-22-0000")
                .withCaseNumber("AB110033")
                .build();
        addCrime.handleRequest(request1, null);

        AddCrimeToCriminalRecordRequest request2 = AddCrimeToCriminalRecordRequest.builder()
                .withSsn("121-99-7777")
                .withCaseNumber("VC991133")
                .build();
        addCrime.handleRequest(request2, null);

        AddCrimeToCriminalRecordRequest request3 = AddCrimeToCriminalRecordRequest.builder()
                .withSsn("123-11-8888")
                .withCaseNumber("LM123132")
                .build();
        addCrime.handleRequest(request3, null);

        AddCrimeToCriminalRecordRequest request4 = AddCrimeToCriminalRecordRequest.builder()
                .withSsn("123-45-6789")
                .withCaseNumber("XY123456")
                .build();
        addCrime.handleRequest(request4, null);

        AddCrimeToCriminalRecordRequest request5 = AddCrimeToCriminalRecordRequest.builder()
                .withSsn("123-45-8888")
                .withCaseNumber("QQ010199")
                .build();
        addCrime.handleRequest(request5,null);

        AddCrimeToCriminalRecordRequest request6 = AddCrimeToCriminalRecordRequest.builder()
                .withSsn("222-22-2020")
                .withCaseNumber("HH112200")
                .build();
        addCrime.handleRequest(request6, null);

        AddCrimeToCriminalRecordRequest request7 = AddCrimeToCriminalRecordRequest.builder()
                .withSsn("333-22-1111")
                .withCaseNumber("DD242424")
                .build();
        addCrime.handleRequest(request7, null);

        AddCrimeToCriminalRecordRequest request8 = AddCrimeToCriminalRecordRequest.builder()
                .withSsn("555-00-5555")
                .withCaseNumber("KK990099")
                .build();
        addCrime.handleRequest(request8, null);

        AddCrimeToCriminalRecordRequest request9 = AddCrimeToCriminalRecordRequest.builder()
                .withSsn("777-66-5555")
                .withCaseNumber("EW001122")
                .build();
        addCrime.handleRequest(request9, null);

        AddCrimeToCriminalRecordRequest request10 = AddCrimeToCriminalRecordRequest.builder()
                .withSsn("777-66-5555")
                .withCaseNumber("TR440912")
                .build();
        addCrime.handleRequest(request10, null);

        AddCrimeToCriminalRecordRequest request11 = AddCrimeToCriminalRecordRequest.builder()
                .withSsn("999-77-5555")
                .withCaseNumber("TU789789")
                .build();
        addCrime.handleRequest(request11, null);

        AddCrimeToCriminalRecordRequest request12 = AddCrimeToCriminalRecordRequest.builder()
                .withSsn("000-99-4444")
                .withCaseNumber("PP010101")
                .build();
        addCrime.handleRequest(request12, null);

        AddCrimeToCriminalRecordRequest request13 = AddCrimeToCriminalRecordRequest.builder()
                .withSsn("000-99-4444")
                .withCaseNumber("XY987654")
                .build();
        addCrime.handleRequest(request13, null);

        AddCrimeToCriminalRecordRequest request14 = AddCrimeToCriminalRecordRequest.builder()
                .withSsn("000-99-4444")
                .withCaseNumber("BB009900")
                .build();
        addCrime.handleRequest(request14, null);
    }
}
