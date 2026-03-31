package PersonalizedMealPlanGenerator;

//high protein meal plan
public class HighProteinMeal implements MealPlan {

    public void displayPlan() {
        System.out.println("Meal Type  : High Protein");
        System.out.println("Plan       : Soy + Chicken + Milk");
        System.out.println("Calories   : 2000 kcal\n");
        System.out.println("----------------------------------------------\n");
    }
}
