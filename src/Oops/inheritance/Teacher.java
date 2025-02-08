package Oops.inheritance;

 class school{
     int age;
     String name;

    void salary(){
        System.out.println("everyone got");
        age=23;
        name="sahil";
     }

     school(){
         System.out.println("hello"); //not pass any arg
     }
}


 public  class Teacher extends  school{

}
class student extends  Teacher{

}


