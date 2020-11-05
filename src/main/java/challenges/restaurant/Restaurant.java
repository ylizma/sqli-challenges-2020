package challenges.restaurant;

import java.util.HashMap;
import java.util.List;

public class Restaurant {

    private HashMap<Ingredient, Integer> ingredients;
    private List<Ticket> tickets;

    public Restaurant(String... s) {
        this.ingredients = new HashMap<>();
        for (String ing : s
        ) {
            try {
                Integer.parseInt(ing.substring(0, 1));
                Ingredient newIngredient = new Ingredient(ing.substring(1));
                this.ingredients.put(newIngredient, Integer.parseInt(ing.substring(0, 1)));
            } catch (NumberFormatException e) {
                Ingredient newIngredient = new Ingredient(ing);
                this.ingredients.put(newIngredient, -1);
            }
        }
    }

    public Ticket order(String s) {
        return new Ticket();
    }
}
