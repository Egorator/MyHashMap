package home.yehor.Main;

import home.yehor.Logic.HashMap;

public class Main {

    public static void main(String[] args) {
        HashMap hashMap = new HashMap(2);
        System.out.println("hashMap.size() = " + hashMap.size());
        System.out.println("hashMap.getCapacity() = " + hashMap.getCapacity());
        hashMap.put(7, 3634);
        hashMap.put(36, 346);
        hashMap.put(18, 32);
        hashMap.put(62, 235);
        hashMap.put(5, 734);
        System.out.println("hashMap.get(36) = " + hashMap.get(36));
        System.out.println("hashMap.get(62) = " + hashMap.get(62));
        System.out.println("hashMap.get(7) = " + hashMap.get(7));
        System.out.println("hashMap.get(123) = " + hashMap.get(123));
        System.out.println("hashMap.size() = " + hashMap.size());
        System.out.println("hashMap.getCapacity() = " + hashMap.getCapacity());
    }
}
