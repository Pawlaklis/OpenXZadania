package Task2.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rating {
    @JsonProperty("rate")
    public double rate;

    @JsonProperty("count")
    public int count;

    @Override
    public String toString() {
        return "Rating{" +
                "rate=" + rate +
                ", count=" + count +
                '}';
    }
}
