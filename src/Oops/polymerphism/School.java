package Oops.polymerphism;

public class School
{
    int age;
    String name;

    void add(){
        System.out.println(age);
        System.out.println(name);
    }
    void mul(){
        System.out.println("hello mul");
    }
}
class teacher extends School{

}
class student extends School{

}
class poly{
     void call(student s){

        s.mul();
        s.add();
    }

}
