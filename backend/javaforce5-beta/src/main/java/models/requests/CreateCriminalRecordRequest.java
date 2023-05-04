package main.java.models.requests;

import java.util.Objects;

/**
 * Request object with required attributes ssn, name, dob, and state to create a new CriminalRecord.
 */
public class CreateCriminalRecordRequest {
    private String ssn;
    private String name;
    private String dob;
    private String state;

    /**
     * No args constructor.
     */
    public CreateCriminalRecordRequest() {
    }

    /**
     * Parameterized constructor.
     * @param ssn social security number.
     * @param name full name.
     * @param dob date of birth.
     * @param state state of residence.
     */
    public CreateCriminalRecordRequest(String ssn, String name, String dob, String state) {
        this.ssn = ssn;
        this.name = name;
        this.dob = dob;
        this.state = state;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateCriminalRecordRequest that = (CreateCriminalRecordRequest) o;
        return Objects.equals(ssn, that.ssn) && Objects.equals(name, that.name) && Objects.equals(dob, that.dob) && Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ssn, name, dob, state);
    }

    @Override
    public String toString() {
        return "CreateCriminalRecordRequest{" +
                "ssn='" + ssn + '\'' +
                ", name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    /**
     * Builder pattern for instantiating a new object.
     * @param builder
     */
    public CreateCriminalRecordRequest(Builder builder) {
        this.ssn = builder.ssn;
        this.name = builder.name;
        this.dob = builder.dob;
        this.state = builder.state;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String ssn;
        private String name;
        private String dob;
        private String state;

        private Builder(){}

        public Builder withSsn(String ssnToUse) {
            this.ssn = ssnToUse;
            return this;
        }
        public Builder withName(String nameToUse) {
            this.name = nameToUse;
            return this;
        }
        public Builder withDob(String dobToUse) {
            this.dob = dobToUse;
            return this;
        }
        public Builder withState(String stateToUse) {
            this.state = stateToUse;
            return this;
        }

        public CreateCriminalRecordRequest build() {
            return new CreateCriminalRecordRequest(this);
        }
    }

}
