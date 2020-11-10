package challenges.diet;

public class Cheese extends MealDecorator {

    public Cheese(Meal meal) {
        super(meal);
    }

    public String getType() {
        return meal.getType() + ", Fats";
    }

    public int getCalories() {
        return meal.getCalories() + 50;
    }
}
