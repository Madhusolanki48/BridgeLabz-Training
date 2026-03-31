package PersonalizedMealPlanGenerator;

public class MealPlanGenerator {
    //generic method: validates & generates plan
    public static <T extends MealPlan> void generateMealPlan(Meal<T> meal) {
        meal.getPlan().displayPlan(); //only valid MealPlan types allowed
    }

    public static void main(String[] args) {
        System.out.println("-----  Personalized Meal Plan Generator  -----");
        System.out.println("----------------------------------------------\n");

        Meal<VegetarianMeal> vegMeal = new Meal<>(new VegetarianMeal());
        Meal<VeganMeal> veganMeal = new Meal<>(new VeganMeal());
        Meal<KetoMeal> ketoMeal = new Meal<>(new KetoMeal());
        Meal<HighProteinMeal> hpMeal = new Meal<>(new HighProteinMeal());
        //method calling
        generateMealPlan(vegMeal);
        generateMealPlan(veganMeal);
        generateMealPlan(ketoMeal);
        generateMealPlan(hpMeal);
    }
}
