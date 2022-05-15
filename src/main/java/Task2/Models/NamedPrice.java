package Task2.Models;

import java.math.BigDecimal;

public record NamedPrice(BigDecimal value, Name name) {

    @Override
    public String toString() {
        return name + " : " + value;
    }

}
