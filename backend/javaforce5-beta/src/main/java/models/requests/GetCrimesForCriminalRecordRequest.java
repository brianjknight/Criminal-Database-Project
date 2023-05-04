package main.java.models.requests;

import java.util.Objects;

/**
 * Request object with required attributes ssn to retrieve a list of Crimes from a CriminalRecord.
 */
public class GetCrimesForCriminalRecordRequest {
    private String ssn;

    /**
     * No args constructor.
     */
    public GetCrimesForCriminalRecordRequest() {}

    /**
     * Parameterized constructor.
     * @param ssn social security number.
     */
    public GetCrimesForCriminalRecordRequest(String ssn) {
        this.ssn = ssn;
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

    /**
     * Builder pattern for instantiating a new object.
     * @param builder
     */
    public GetCrimesForCriminalRecordRequest(Builder builder) {
        this.ssn = builder.ssn;
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
