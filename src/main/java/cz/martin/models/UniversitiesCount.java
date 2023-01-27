package cz.martin.models;

public class UniversitiesCount {
    private String country;
    private int count;

    public UniversitiesCount(String country, int count) {
        this.country = country;
        this.count = count;
    }

    public String getCountry() {
        return country;
    }

    public int getCount() {
        return count;
    }
}
