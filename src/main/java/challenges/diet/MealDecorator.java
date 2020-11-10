package challenges.diet;

public class MealDecorator implements Meal {

    protected Meal meal;

    public MealDecorator(Meal meal) {
        this.meal = meal;
    }

    @Override
    public String getType() {
        return meal.getType();
    }

    @Override
    public int getCalories() {
        return meal.getCalories();
    }
}
