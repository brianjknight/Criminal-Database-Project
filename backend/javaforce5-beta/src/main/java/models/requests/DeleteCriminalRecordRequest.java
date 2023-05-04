package main.java.models.requests;

import java.util.Objects;

/**
 * Request object with required attributes ssn.
 */
public class DeleteCriminalRecordRequest {
    private String ssn;

    /**
     * No args constructor.
     */
    public DeleteCriminalRecordRequest() {}

    /**
     * Parameterized constructor.
     * @param ssn social security number.
     */
    public DeleteCriminalRecordRequest(String ssn) {
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
        DeleteCriminalRecordRequest that = (DeleteCriminalRecordRequest) o;
        return Objects.equals(ssn, that.ssn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ssn);
    }

    @Override
    public String toString() {
        return "DeleteCriminalRecordRequest{" +
                "ssn='" + ssn + '\'' +
                '}';
    }

    /**
     * Builder pattern for instantiating a new object.
     * @param builder
     */
    public DeleteCriminalRecordRequest(Builder builder) {
        this.ssn = builder.ssn;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String ssn;

        private Builder() {}

        public Builder withSsn(String ssn) {
            this.ssn = ssn;
            return this;
        }
        public DeleteCriminalRecordRequest build() {
            return new DeleteCriminalRecordRequest(this);
        }

    }

}
