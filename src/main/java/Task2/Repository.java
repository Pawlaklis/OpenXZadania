package Task2;

import Task2.Models.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Repository {
    private List<Cart> carts = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private List<Product> products = new ArrayList<>();
    private Map<String, BigDecimal> categoriesPrices = new HashMap<>();

    public void importData(){
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            carts = mapper.readValue(Paths.get("data/carts.json").toFile(), new TypeReference<List<Cart>>(){});
            products = mapper.readValue(Paths.get("data/products.json").toFile(), new TypeReference<List<Product>>(){});
            users = mapper.readValue(Paths.get("data/users.json").toFile(), new TypeReference<List<User>>(){});

            generateCategories();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printTop(int length){
        for (int i = 0;i < length;i++){
            System.out.println(carts.get(i));
            System.out.println(users.get(i));
            System.out.println(products.get(i));
        }
    }

    public void generateCategories(){
        categoriesPrices = products.stream()
                .collect(Collectors.toMap(Product::getCategory, Product::getPrice, BigDecimal::add));
    }

    public BigDecimal getTotalValueOfCategory(String category){
        return categoriesPrices.get(category);
    }

    public NamedPrice getHighestValueCustomer(){
        Cart highestCart = null;
        BigDecimal highestPrice = new BigDecimal(0);

        for (var cart:carts) {
            BigDecimal price = getCartPrice(cart);
            if (price.compareTo(highestPrice) > 0){
                highestPrice = price;
                highestCart = cart;
            }
        }

        Cart finalHighestCart = highestCart;
        var name = users.stream().filter(user -> user.id == finalHighestCart.userId).findFirst().get().name;

        return new NamedPrice(highestPrice, name);

    }

    public BigDecimal getCartPrice(Cart cart){
        BigDecimal price = new BigDecimal(0);
        for (var productRecord:cart.products) {
            BigDecimal productPrice = products.stream()
                    .filter(product -> product.getId() == productRecord.productId)
                    .findFirst().get().getPrice();
            price = price.add(productPrice.multiply(BigDecimal.valueOf(productRecord.quantity)));
        }
        return price;
    }

    public Tuple<User, User> farthestAway(){
        Tuple<User, User> res = new Tuple<>(users.get(0), users.get(1));
        for (int i = 0;i< users.size();i++){
            for (int j = i + 1; j < users.size(); j++) {
                if (distance(res.x.address, res.y.address) < distance(users.get(i).address, users.get(j).address)){
                    res = new Tuple<>(users.get(i), users.get(j));
                }
            }
        }

        return res;
    }

    static double distance(Address address1, Address address2){
        return Math.sqrt(Math.pow(address1.geolocation.latitude - address2.geolocation.latitude, 2)
                + Math.pow(address1.geolocation.longitude - address2.geolocation.longitude, 2));
    }

}
