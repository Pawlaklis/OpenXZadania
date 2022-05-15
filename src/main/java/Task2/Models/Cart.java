package Task2.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Cart {
    @JsonProperty("id")
    public int id;

    @JsonProperty("userId")
    public int userId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    public Date date;

    @JsonProperty("products")
    public List<ProductRecord> products;

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", userId=" + userId +
                ", date=" + date +
                ", products=" + products +
                '}';
    }
}
