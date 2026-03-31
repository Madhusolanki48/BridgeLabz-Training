package annotation;
//class with deprecated method
class LegacyAPI {

    @Deprecated
    public void oldFeature() {
        System.out.println("This is the old feature (deprecated).");
    }

    public void newFeature() {
        System.out.println("This is the new feature. Use this instead!");
    }
}

public class DeprecatedAnnotationDemo {
    public static void main(String[] args) {

        LegacyAPI api = new LegacyAPI();

        //calling deprecated method
        api.oldFeature();  //compiler will show a warning

        //calling the new method
        api.newFeature();
    }
}
