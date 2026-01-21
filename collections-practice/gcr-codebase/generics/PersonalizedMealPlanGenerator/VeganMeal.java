package PersonalizedMealPlanGenerator;

//vegan meal plan
public class VeganMeal implements MealPlan {

    public void displayPlan() {
        System.out.println("Meal Type  : Vegan");
        System.out.println("Plan       : Sprouts + Nuts + Juice");
        System.out.println("Calories   : 1500 kcal\n");
        System.out.println("----------------------------------------------\n");
    }
}
