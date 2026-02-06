package functional_interface;

class Prototype implements Cloneable {
    int value = 10;

    //enable cloning
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class CloningPrototypeObjects {
    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype p1 = new Prototype();

        //clone object
        Prototype p2 = (Prototype) p1.clone();

        System.out.println(p1.value);
        System.out.println(p2.value);
    }
}

