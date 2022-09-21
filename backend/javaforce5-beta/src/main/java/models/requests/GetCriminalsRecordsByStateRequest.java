package main.java.models.requests;

import java.util.Objects;

public class GetCriminalsRecordsByStateRequest {
    private String state;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetCriminalsRecordsByStateRequest that = (GetCriminalsRecordsByStateRequest) o;
        return Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(state);
    }

    @Override
    public String toString() {
        return "GetCriminalsRecordsByStateRequest{" +
                "state='" + state + '\'' +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        String state;

        private Builder() {}

        public Builder withState(String stateToUse) {
            this.state = stateToUse;
            return this;
        }
        public GetCriminalsRecordsByStateRequest build() {
            return new GetCriminalsRecordsByStateRequest(this);
        }
    }
}
