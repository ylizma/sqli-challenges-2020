package challenges.diet;

public class Diet {

    private final int maxCalories;
    private Meal newMeal;

    public Diet(int calories) {
        this.maxCalories = calories;
        newMeal = new BasicMeal();
    }

    public int calculCalories(String allMeals) {
        this.initMeal(allMeals);
        return newMeal.getCalories();
    }

    void initMeal(String allMeals) {
        String[] meals = allMeals.split(",");
        for (String meal : meals) {
            switch (meal) {
                case "egg":
                    newMeal = new Egg(newMeal);
                    break;
                case "seafood":
                    newMeal = new SeaFood(newMeal);
                    break;
                case "fruit":
                    newMeal = new Fruit(newMeal);
                    break;
                case "vegetable":
                    newMeal = new Vegetable(newMeal);
                    break;
                case "cheese":
                    newMeal = new Cheese(newMeal);
                    break;
                case "peanut":
                    newMeal = new Peanut(newMeal);
                    break;
            }
        }
    }

    public String evaluateCalories(String meals) {
        int numberOfCalories = calculCalories(meals);
        if (numberOfCalories == this.maxCalories) {
            return "good, number of calories as expected";
        } else if (numberOfCalories < this.maxCalories) {
            return "still " + (this.maxCalories - numberOfCalories) + " calories to be added";
        } else if (numberOfCalories > this.maxCalories) {
            return "still " + (numberOfCalories - this.maxCalories) + " calories to be removed";
        } else {
            return " ";
        }
    }

    public String evaluateNutrients(String meals) {
        initMeal(meals);
        String nutritions = newMeal.getType();
        boolean carbohydrates = false;
        boolean proteins = false;
        boolean fats = false;
        if (nutritions.contains("Carbohydrates")) {
            carbohydrates = true;
        }
        if (nutritions.contains("Proteins")) {
            proteins = true;
        }
        if (nutritions.contains("Fats")) {
            fats = true;
        }
        if (carbohydrates && proteins && fats) {
            return "good, your meal contains all required nutrients!";
        } else if (!carbohydrates) {
            return "your meal doesn't contain carbohydrates!";
        } else if (!proteins) {
            return "your meal doesn't contain proteins!";
        } else if (!fats) {
            return "your meal doesn't contain fats!";
        }
        return nutritions;
    }
}
