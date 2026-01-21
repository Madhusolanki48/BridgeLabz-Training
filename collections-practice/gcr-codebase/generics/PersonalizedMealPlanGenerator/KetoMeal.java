package PersonalizedMealPlanGenerator;

//keto meal plan
public class KetoMeal implements MealPlan {

    public void displayPlan() {
        System.out.println("Meal Type  : Keto");
        System.out.println("Plan       : Eggs + Chicken + Veggies");
        System.out.println("Calories   : 1800 kcal\n");
        System.out.println("----------------------------------------------\n");
    }
}
