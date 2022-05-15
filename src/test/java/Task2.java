import Task2.Models.Name;
import Task2.Models.NamedPrice;
import Task2.Models.Tuple;
import Task2.Models.User;
import Task2.Repository;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class Task2 {
    Repository repository;

    @Before
    public void init(){
        repository = new Repository();
        repository.importData();
    }

    @Test
    public void testGetTotalValueOfCategory() {
        Assert.assertEquals(repository.getTotalValueOfCategory("men's clothing"), new BigDecimal("204.23"));
        Assert.assertEquals(repository.getTotalValueOfCategory("jewelery"), new BigDecimal("883.98"));
        Assert.assertEquals(repository.getTotalValueOfCategory("electronics"), new BigDecimal("1994.99"));
        Assert.assertEquals(repository.getTotalValueOfCategory("women's clothing"), new BigDecimal("157.72"));

    }

    @Test
    public void testGetHighestValueCustomer() {
        Assert.assertEquals(repository.getHighestValueCustomer(), new NamedPrice(new BigDecimal("2578.70"), new Name("john", "doe")));
    }

    @Test
    public void testFarthestAway() {
        Tuple<User, User> users = repository.farthestAway();

        Assert.assertTrue((users.x.id == 1 && users.y.id ==5) || (users.x.id == 5 && users.y.id ==1));

    }
}