package Oops.Abstraction;

public class jvm {
    public static void main(String[] args){
//         student s1= new student();
//         s1.location();
//         s1.name();
//         student s2=new student();
//         s1.location();
//         s1.name();



        school s1=new teacher();
        s1.name();
        s1.location();
        s1.department();

//        s1.teacherName();    //Specialized// constructor can not be  abstract

        System.out.println("******************");

        school s2=new student();
        s2.name();
        s2.location();
        s1.department();



    }
}
