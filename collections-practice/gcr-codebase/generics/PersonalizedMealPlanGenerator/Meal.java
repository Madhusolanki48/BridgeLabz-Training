package PersonalizedMealPlanGenerator;

//generic class for meal plan handling
public class Meal<T extends MealPlan> {
    private T plan;

    Meal(T plan) {
        this.plan = plan;
    }

    T getPlan() {
        return plan;
    }
}
