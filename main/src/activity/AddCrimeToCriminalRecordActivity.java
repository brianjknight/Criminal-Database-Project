package activity;

import com.amazon.ata.aws.dynamodb.DynamoDbClientProvider;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dao.CrimeDao;
import dao.CriminalRecordDao;
import exceptions.CrimeAlreadyInCriminalRecordException;
import models.Crime;
import models.CriminalRecord;

import java.util.ArrayList;
import java.util.List;

public class AddCrimeToCriminalRecordActivity {

    CriminalRecordDao criminalRecordDao;
    CrimeDao crimeDao;

    public AddCrimeToCriminalRecordActivity(CriminalRecordDao criminalRecordDao, CrimeDao crimeDao) {
        this.criminalRecordDao = criminalRecordDao;
        this.crimeDao = crimeDao;
    }

    public CriminalRecord handleRequest(String ssn, String caseNumber) {
        Crime requestedCrime = crimeDao.getCrime(caseNumber);
        CriminalRecord requestedCriminalRecord = criminalRecordDao.getCriminalRecord(ssn);

        List<Crime> crimeList = requestedCriminalRecord.getCrimes();

        if(crimeList == null) {
            crimeList = new ArrayList<>();
        }
        if(crimeList.contains(requestedCrime)) {
            throw new CrimeAlreadyInCriminalRecordException(caseNumber);
        }

        crimeList.add(requestedCrime);
        requestedCriminalRecord.setCrimes(crimeList);

        Integer currentCrimeCount = requestedCriminalRecord.getCrimeCount();
        currentCrimeCount++;
        requestedCriminalRecord.setCrimeCount(currentCrimeCount);

        criminalRecordDao.saveCriminalRecord(requestedCriminalRecord);

        return requestedCriminalRecord;
    }

}
