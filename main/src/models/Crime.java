package models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.Objects;

@DynamoDBTable(tableName = "Crimes")
public class Crime {
    private String caseNumber;
    private String ssn;
    private String charge;
    private String offenseLevel;
    private String status;
    private String date;
    private Integer sentenceInDays;

    public Crime() {}

    private Crime(CrimeBuilder builder) {
        this.caseNumber = builder.caseNumber;
        this.ssn = builder.ssn;
        this.charge = builder.charge;
        this.offenseLevel = builder.offenseLevel;
        this.status = builder.status;
        this.date = builder.date;
        this.sentenceInDays = builder.sentenceInDays;
    }

    @DynamoDBHashKey(attributeName = "caseNumber")
    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    @DynamoDBAttribute(attributeName = "ssn")
    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @DynamoDBAttribute(attributeName = "charge")
    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    @DynamoDBAttribute(attributeName = "offenseLevel")
    public String getOffenseLevel() {
        return offenseLevel;
    }

    public void setOffenseLevel(String offenseLevel) {
        this.offenseLevel = offenseLevel;
    }

    @DynamoDBAttribute(attributeName = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @DynamoDBAttribute(attributeName = "date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @DynamoDBAttribute(attributeName = "sentenceInDays")
    public Integer getSentenceInDays() {
        return sentenceInDays;
    }

    public void setSentenceInDays(Integer sentenceInDays) {
        this.sentenceInDays = sentenceInDays;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Crime crime = (Crime) o;
        return Objects.equals(ssn, crime.ssn)  && Objects.equals(charge, crime.charge) && Objects.equals(offenseLevel, crime.offenseLevel) && Objects.equals(status, crime.status) && Objects.equals(date, crime.date) && Objects.equals(sentenceInDays, crime.sentenceInDays);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ssn, charge, offenseLevel, status, date, sentenceInDays);
    }

    @Override
    public String toString() {
        return "Crime{" +
                "ssn='" + ssn + '\'' +
                ", charge='" + charge + '\'' +
                ", offenseLevel='" + offenseLevel + '\'' +
                ", status='" + status + '\'' +
                ", date='" + date + '\'' +
                ", sentenceInDays=" + sentenceInDays +
                '}';
    }

    public static final CrimeBuilder builder() {
        return new CrimeBuilder();
    }

    public static class CrimeBuilder {
        private String caseNumber;
        private String ssn;
        private String charge;
        private String offenseLevel;
        private String status;
        private String date;
        private Integer sentenceInDays;

        private CrimeBuilder() {}

        public CrimeBuilder withCaseNumber(String caseNumber) {
            this.caseNumber = caseNumber;
            return this;
        }
        public CrimeBuilder withSsn(String ssn) {
            this.ssn = ssn;
            return this;
        }
        public CrimeBuilder withCharge(String charge) {
            this.charge = charge;
            return this;
        }
        public CrimeBuilder withOffenseLevel(String offenseLevel) {
            this.offenseLevel = offenseLevel;
            return this;
        }
        public CrimeBuilder withStatus(String status) {
            this.status = status;
            return this;
        }
        public CrimeBuilder withDate(String date) {
            this.date = date;
            return this;
        }
        public CrimeBuilder withSentenceInDays(Integer sentenceInDays) {
            this.sentenceInDays = sentenceInDays;
            return this;
        }

        public Crime build() {
            return new Crime(this);
        }
    }
}
