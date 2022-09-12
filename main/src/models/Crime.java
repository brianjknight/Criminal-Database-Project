package models;

import java.util.Objects;

public class Crime {
    String caseNumber;
    String ssn;
    String name;
    String charge;
    String offenseLevel;
    String status;
    String date;
    Integer sentenceInDays;

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

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public String getOffenseLevel() {
        return offenseLevel;
    }

    public void setOffenseLevel(String offenseLevel) {
        this.offenseLevel = offenseLevel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getSentenceInDays() {
        return sentenceInDays;
    }

    public void setSentenceInDays(Integer sentenceInDays) {
        this.sentenceInDays = sentenceInDays;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Crime crime = (Crime) o;
        return Objects.equals(ssn, crime.ssn) && Objects.equals(name, crime.name) && Objects.equals(charge, crime.charge) && Objects.equals(offenseLevel, crime.offenseLevel) && Objects.equals(status, crime.status) && Objects.equals(date, crime.date) && Objects.equals(sentenceInDays, crime.sentenceInDays);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ssn, name, charge, offenseLevel, status, date, sentenceInDays);
    }

    @Override
    public String toString() {
        return "Crime{" +
                "ssn='" + ssn + '\'' +
                ", name='" + name + '\'' +
                ", charge='" + charge + '\'' +
                ", offenseLevel='" + offenseLevel + '\'' +
                ", status='" + status + '\'' +
                ", date='" + date + '\'' +
                ", sentenceInDays=" + sentenceInDays +
                '}';
    }
}
