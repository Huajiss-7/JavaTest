package CSC3101;

import java.util.Date;

public class Activity1 {

}

class Student {
    String matric;
    Date dob;

    public String toString() {
        return "";
    }

    public int getAge() {
        return 0;
    }
}

class Address {
    String line1;
    String line2;
    String line3;
    String country;
    String postcode;

    public String toString() {
        return "";
    }
}

class Name {
    String first;
    String middle;
    String last;

    public String toString() {
        return "";
    }
}

class Undergraduate extends Student{
    String academicAdvisor;
    public String toString() {
        return "";
    }
}

class Posgraduate extends Student{
    String supervisor;
    public String toString() {
        return "";
    }
}
