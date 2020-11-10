package challenges.diet;

public class SeaFood extends MealDecorator {
    public SeaFood(Meal meal) {
        super(meal);
    }

    public String getType() {
        return meal.getType() + ", Proteins";
    }

    public int getCalories() {
        return meal.getCalories() + 200;
    }
}
