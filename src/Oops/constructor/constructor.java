package Oops.constructor;


public class constructor {
    int age,mark;
    String name;

    public constructor(){

        this(21,34);
        System.out.println("default constructor");// default constructor
        age=20;
        mark=340;
        name="sahil";

    }

    constructor(String name){
        this(34,67);

        this.name=name;                            //parameterized constructor
    }
    constructor( int  age,int mark ){
        this.age=age;
        this.mark=mark;



    }

    @Override
    public String toString() {
        return "constructor{" +
                "age=" + age +
                ", mark=" + mark +
                ", name='" + name + '\'' +
                '}';
    }

//    or

    public  void disp(){
        System.out.println(name);
        System.out.println(age);
        System.out.println(mark);

    }

    int volume(){
        return age * mark;
    }
}
