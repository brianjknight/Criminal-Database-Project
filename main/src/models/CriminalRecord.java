package models;

import java.util.List;
import java.util.Objects;

public class CriminalRecord {
    String ssn;
    String name;
    String dob;
    String state;
    Integer crimeCount;
    List<Crime> crimes;

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

    public Integer getCrimeCount() {
        return crimeCount;
    }

    public void setCrimeCount(Integer crimeCount) {
        this.crimeCount = crimeCount;
    }

    public List<Crime> getCrimes() {
        return crimes;
    }

    public void setCrimes(List<Crime> crimes) {
        this.crimes = crimes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CriminalRecord that = (CriminalRecord) o;
        return Objects.equals(ssn, that.ssn) && Objects.equals(name, that.name) && Objects.equals(dob, that.dob) && Objects.equals(state, that.state) && Objects.equals(crimeCount, that.crimeCount) && Objects.equals(crimes, that.crimes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ssn, name, dob, state, crimeCount, crimes);
    }

    @Override
    public String toString() {
        return "CriminalRecord{" +
                "ssn='" + ssn + '\'' +
                ", name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", state='" + state + '\'' +
                ", crimeCount=" + crimeCount +
                ", crimes=" + crimes +
                '}';
    }
}
