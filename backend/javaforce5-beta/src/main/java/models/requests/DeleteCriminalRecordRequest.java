package main.java.models.requests;

import java.util.Objects;

public class DeleteCriminalRecordRequest {
    private String ssn;

    public DeleteCriminalRecordRequest() {}

    public DeleteCriminalRecordRequest(String ssn) {
        this.ssn = ssn;
    }

    public DeleteCriminalRecordRequest(Builder builder) {
        this.ssn = builder.ssn;
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
