package Task2.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {
    @JsonProperty("geolocation")
    public Geolocation geolocation;

    @JsonProperty("city")
    public String city;

    @JsonProperty("street")
    public String street;

    @JsonProperty("number")
    public int number;

    @JsonProperty("zipcode")
    public String zipcode;

    @Override
    public String toString() {
        return "Address{" +
                "geolocation=" + geolocation +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", number=" + number +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }
}
