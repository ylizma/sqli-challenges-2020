package challenges.diet;

public class Vegetable extends MealDecorator {
    public Vegetable(Meal meal) {
        super(meal);
    }

    public String getType() {
        return meal.getType() + ", Carbohydrates";
    }

    public int getCalories() {
        return meal.getCalories() + 100;
    }
}
