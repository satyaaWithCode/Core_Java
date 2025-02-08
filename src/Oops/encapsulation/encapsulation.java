package Oops.encapsulation;

public class encapsulation {
    private int age,mark;
    private  String name,location;    //data member/instance variable/non static variable

    public int getAge() {
        return age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "encapsulation{" +"age=" + age + ", mark=" + mark + ", name='" + name + '\'' + ", location='" + location + '\'' + '}';
    }

    //or

    void disp(){
        System.out.println(age);
        System.out.println(mark);
        System.out.println(name);
        System.out.println(location);
    }
}
