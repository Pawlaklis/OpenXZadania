package Task2.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Name {
    @JsonProperty("firstname")
    public String firstname;

    @JsonProperty("lastname")
    public String lastname;

    public Name(){}

    public Name(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "\"" + firstname +
                ", " + lastname + '\"';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(firstname, name.firstname) && Objects.equals(lastname, name.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname);
    }
}
