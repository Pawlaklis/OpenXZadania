package Task2.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Geolocation {

    @JsonProperty("lat")
    public double latitude;

    @JsonProperty("long")
    public double longitude;

    @Override
    public String toString() {
        return "Geolocation{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
