package Oops.polymerphism;

public class jvm {
    public static void main(String[] args) {
//        student s= new student();
//        s.add();
//        s.mul();
        School s= new School();
        teacher t= new teacher();
        student s2= new student();

        poly p = new poly();
        p.call(s2);
//        p.call(s);


    }
}
