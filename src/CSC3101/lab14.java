package CSC3101;

import java.util.ArrayList;
import java.util.List;
//Author's name:ZHANG ZHE
// Matric number:218629
// Lab No:14
class Storage<T> {
    private List<T> items;

    public Storage() {
        this.items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public T getItem(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        } else {
            throw new IndexOutOfBoundsException("index out of range.");
        }
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void printDetails() {
        for (T item : items) {
            System.out.println(item.toString());
        }
    }

    public int size(){
        return items.size();
    }
}


public class lab14 {
    public static void main(String[] args) {
        Storage<Integer> integerStorage = new Storage<>();
        integerStorage.addItem(10);
        integerStorage.addItem(20);
        integerStorage.addItem(30);

        Storage<String> stringStorage = new Storage<>();
        stringStorage.addItem("hello");
        stringStorage.addItem("world");

        System.out.println("integer storage items:");
        for (int i = 0; i < integerStorage.size(); i++) {
            System.out.println(integerStorage.getItem(i));
        }

        System.out.println("---------------------");
        System.out.println("string storage items:");
        for (int i = 0; i < stringStorage.size(); i++) {
            System.out.println(stringStorage.getItem(i));
        }
        System.out.println("---------------------");

        System.out.println("is integer storage empty? " + integerStorage.isEmpty());
        System.out.println("is string storage empty? " + stringStorage.isEmpty());
        System.out.println("---------------------");
        System.out.println("integer storage details:");
        integerStorage.printDetails();
        System.out.println("---------------------");
        System.out.println("string storage details:");
        stringStorage.printDetails();
        System.out.println("---------------------");
        System.out.println("testing equals method:");
        String str1 = "hello";
        String str2 = "hello";
        String str3 = "wworld";
        System.out.println("str1 equals str2? " + str1.equals(str2));
        System.out.println("str1 equals str3? " + str1.equals(str3));
    }
}
