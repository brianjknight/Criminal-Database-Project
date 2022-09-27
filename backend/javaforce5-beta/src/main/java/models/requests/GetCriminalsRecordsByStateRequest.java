package main.java.models.requests;

import java.util.Objects;

public class GetCriminalsRecordsByStateRequest {
    private String state;
    private Integer minNumCrimes;
    private Integer maxNumCrimes;

    public GetCriminalsRecordsByStateRequest() {
    }

    public GetCriminalsRecordsByStateRequest(String state) {
        this.state = state;
    }

    public GetCriminalsRecordsByStateRequest(Builder builder) {
        this.state = builder.state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getMinNumCrimes() {
        return minNumCrimes;
    }

    public void setMinNumCrimes(Integer minNumCrimes) {
        this.minNumCrimes = minNumCrimes;
    }

    public Integer getMaxNumCrimes() {
        return maxNumCrimes;
    }

    public void setMaxNumCrimes(Integer maxNumCrimes) {
        this.maxNumCrimes = maxNumCrimes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetCriminalsRecordsByStateRequest that = (GetCriminalsRecordsByStateRequest) o;
        return Objects.equals(state, that.state) && Objects.equals(minNumCrimes, that.minNumCrimes) && Objects.equals(maxNumCrimes, that.maxNumCrimes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(state, minNumCrimes, maxNumCrimes);
    }

    @Override
    public String toString() {
        return "GetCriminalsRecordsByStateRequest{" +
                "state='" + state + '\'' +
                ", minNumCrimes=" + minNumCrimes +
                ", maxNumCrimes=" + maxNumCrimes +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        String state;
        Integer minNumCrimes;
        Integer maxNumCrimes;

        private Builder() {}

        public Builder withState(String stateToUse) {
            this.state = stateToUse;
            return this;
        }
        public Builder withMinNumCrimes(Integer minNumCrimesToUse) {
            this.minNumCrimes = minNumCrimesToUse;
            return this;
        }
        public Builder withMaxNumCrimes(Integer maxNumCrimesToUse){
            this.maxNumCrimes = maxNumCrimesToUse;
            return this;
        }

        public GetCriminalsRecordsByStateRequest build() {
            return new GetCriminalsRecordsByStateRequest(this);
        }
    }
}
