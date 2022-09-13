package models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import converter.CrimeListConverter;

import java.util.List;
import java.util.Objects;

@DynamoDBTable(tableName = "CriminalRecords")
public class CriminalRecord {
    private String ssn;
    private String name;
    private String dob;
    private String state;
    private Integer crimeCount;
    private List<Crime> crimes;

    public CriminalRecord() {}

    private CriminalRecord(CriminalRecordBuilder builder) {
        this.ssn = builder.ssn;
        this.name = builder.name;
        this.dob = builder.dob;
        this.state = builder.state;
        this.crimeCount = builder.crimeCount;
        this.crimes = builder.crimes;
    }

    @DynamoDBHashKey(attributeName = "ssn")
    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @DynamoDBAttribute(attributeName = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @DynamoDBAttribute(attributeName = "dob")
    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @DynamoDBAttribute(attributeName = "state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @DynamoDBAttribute(attributeName = "crimeCount")
    public Integer getCrimeCount() {
        return crimeCount;
    }

    public void setCrimeCount(Integer crimeCount) {
        this.crimeCount = crimeCount;
    }

    @DynamoDBTypeConverted(converter = CrimeListConverter.class)
    @DynamoDBAttribute(attributeName = "crimes")
    public List<Crime> getCrimes() {
        return crimes;
    }

    public void setCrimes(List<Crime> crimes) {
        this.crimes = crimes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CriminalRecord that = (CriminalRecord) o;
        return Objects.equals(ssn, that.ssn) && Objects.equals(name, that.name) && Objects.equals(dob, that.dob) && Objects.equals(state, that.state) && Objects.equals(crimeCount, that.crimeCount) && Objects.equals(crimes, that.crimes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ssn, name, dob, state, crimeCount, crimes);
    }

    @Override
    public String toString() {
        return "CriminalRecord{" +
                "ssn='" + ssn + '\'' +
                ", name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", state='" + state + '\'' +
                ", crimeCount=" + crimeCount +
                ", crimes=" + crimes +
                '}';
    }

    public static final CriminalRecordBuilder builder() {
        return new CriminalRecordBuilder();
    }

    public static class CriminalRecordBuilder {
        private String ssn;
        private String name;
        private String dob;
        private String state;
        private Integer crimeCount;
        private List<Crime> crimes;

        private CriminalRecordBuilder(){}

        public CriminalRecordBuilder withSsn(String ssn) {
            this.ssn = ssn;
            return this;
        }
        public CriminalRecordBuilder withName(String name) {
            this.name = name;
            return this;
        }
        public CriminalRecordBuilder withDob(String dob) {
            this.dob = dob;
            return this;
        }
        public CriminalRecordBuilder withState(String state) {
            this.state = state;
            return this;
        }
        public CriminalRecordBuilder withCrimeCount(Integer crimeCount) {
            this.crimeCount = crimeCount;
            return this;
        }
        public CriminalRecordBuilder withCrimes(List<Crime> crimes) {
            this.crimes = crimes;
            return this;
        }

        public CriminalRecord build() {
            return new CriminalRecord(this);
        }
    }
}
