package challenges.diet;

public class Fruit extends MealDecorator {

    public Fruit(Meal meal) {
        super(meal);
    }

    public String getType() {
        return meal.getType() + ", Carbohydrates";
    }

    public int getCalories() {
        return meal.getCalories() + 150;
    }
}
