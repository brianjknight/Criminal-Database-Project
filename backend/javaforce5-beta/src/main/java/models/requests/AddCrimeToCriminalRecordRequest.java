package main.java.models.requests;

import java.util.Objects;

public class AddCrimeToCriminalRecordRequest {
    private String ssn;
    private String caseNumber;

    public AddCrimeToCriminalRecordRequest() {}

    public AddCrimeToCriminalRecordRequest(String ssn, String caseNumber) {
        this.ssn = ssn;
        this.caseNumber = caseNumber;
    }

    public AddCrimeToCriminalRecordRequest(Builder builder) {
        this.ssn = builder.ssn;
        this.caseNumber = builder.caseNumber;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddCrimeToCriminalRecordRequest that = (AddCrimeToCriminalRecordRequest) o;
        return Objects.equals(ssn, that.ssn) && Objects.equals(caseNumber, that.caseNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ssn, caseNumber);
    }

    @Override
    public String toString() {
        return "AddCrimeToCriminalRecordRequest{" +
                "ssn='" + ssn + '\'' +
                ", caseNumber='" + caseNumber + '\'' +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String ssn;
        private String caseNumber;

        private Builder() {}

        public Builder withSsn(String ssnToUse) {
            this.ssn = ssnToUse;
            return this;
        }

        public Builder withCaseNumber(String caseNumberToUse) {
            this.caseNumber = caseNumberToUse;
            return this;
        }

        public AddCrimeToCriminalRecordRequest build() {
            return new AddCrimeToCriminalRecordRequest(this);
        }

    }
}
