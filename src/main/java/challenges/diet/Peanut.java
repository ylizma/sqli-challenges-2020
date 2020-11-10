package challenges.diet;

public class Peanut extends MealDecorator {
    public Peanut(Meal meal) {
        super(meal);
    }

    public String getType() {
        return meal.getType() + ", Fats";
    }

    public int getCalories() {
        return meal.getCalories() + 50;
    }
}
