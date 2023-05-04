package main.java.models.requests;

import java.util.Objects;

/**
 * Request object with required attributes ssn to retrieve a CriminalRecord.
 */
public class GetCriminalRecordRequest {
    private String ssn;

    /**
     * No args constructor.
     */
    public GetCriminalRecordRequest() {}

    /**
     * Parameterized constructor.
     * @param ssn social security number.
     */
    public GetCriminalRecordRequest(String ssn) {
        this.ssn = ssn;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetCriminalRecordRequest that = (GetCriminalRecordRequest) o;
        return Objects.equals(ssn, that.ssn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ssn);
    }

    @Override
    public String toString() {
        return "GetCriminalRecordRequest{" +
                "ssn='" + ssn + '\'' +
                '}';
    }

    /**
     * Builder pattern for instantiating a new object.
     * @param builder
     */
    public GetCriminalRecordRequest(Builder builder) {
        this.ssn = builder.ssn;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String ssn;

        private Builder() {}

        public Builder withSsn(String ssnToUse) {
            this.ssn = ssnToUse;
            return this;
        }

        public GetCriminalRecordRequest build() {
            return new GetCriminalRecordRequest(this);
        }
    }

}
