package Task2.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductRecord {
    @JsonProperty("productId")
    public int productId;

    @JsonProperty("quantity")
    public int quantity;


    @Override
    public String toString() {
        return "ProductRecord{" +
                "productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}
