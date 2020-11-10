package challenges.diet;

public class Egg extends MealDecorator {

    public Egg(Meal meal) {
        super(meal);
    }

    public String getType() {
        return meal.getType() + ", Proteins";
    }

    public int getCalories() {
        return meal.getCalories() + 50;
    }
}
