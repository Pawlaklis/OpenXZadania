package Task2.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    @JsonProperty("address")
    public Address address;

    @JsonProperty("id")
    public int id;

    @JsonProperty("email")
    public String email;

    @JsonProperty("username")
    public String username;

    @JsonProperty("password")
    public String password;

    @JsonProperty("name")
    public Name name;

    @JsonProperty("phone")
    public String phone;

    @Override
    public String toString() {
        return "User{" +
                "address=" + address +
                ", id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name=" + name +
                ", phone='" + phone + '\'' +
                '}';
    }
}
