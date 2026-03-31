package PersonalizedMealPlanGenerator;

//vegetarian meal plan
public class VegetarianMeal implements MealPlan {

    public void displayPlan() {
        System.out.println("Meal Type  : Vegetarian");
        System.out.println("Plan       : Paneer + Salad + Fruits");
        System.out.println("Calories   : 1600 kcal\n");
        System.out.println("----------------------------------------------\n");
    }
}
