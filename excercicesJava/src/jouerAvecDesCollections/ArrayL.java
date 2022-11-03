package jouerAvecDesCollections;


import java.util.ArrayList;

public class ArrayL {
    public static void list() {
        ArrayList<String> l = new ArrayList<String>();
        System.out.println(l.size());
        l.add("anis");
        l.add("sina");
        l.add("safa");
        l.add("ouelef");
        System.out.println(l.toString());
        try {
            System.out.println(l.contains(l));
        } catch (Exception e) {
            System.out.println(e.getMessage() + " please think oen more time");
        }
        System.out.println(l.toString());
        System.out.println(l.size());
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        list();

    }

}

