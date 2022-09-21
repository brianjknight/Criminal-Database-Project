package main.java.models.requests;

import java.util.Objects;

public class GetCrimesForCriminalRecordRequest {
    private String ssn;

    public GetCrimesForCriminalRecordRequest() {}

    public GetCrimesForCriminalRecordRequest(String ssn) {
        this.ssn = ssn;
    }

    public GetCrimesForCriminalRecordRequest(Builder builder) {
        this.ssn = builder.ssn;
    }

    public String getSsn() {
        return this.ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetCrimesForCriminalRecordRequest that = (GetCrimesForCriminalRecordRequest) o;
        return Objects.equals(ssn, that.ssn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ssn);
    }

    @Override
    public String toString() {
        return "GetCrimesForCriminalRecordRequest{" +
                "ssn='" + ssn + '\'' +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        String ssn;

        private Builder() {}

        public Builder withSsn(String ssnToUse) {
            this.ssn  = ssnToUse;
            return this;
        }
        public GetCrimesForCriminalRecordRequest build() {
            return new GetCrimesForCriminalRecordRequest(this);
        }
    }
}
