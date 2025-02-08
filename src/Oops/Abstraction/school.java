package Oops.Abstraction;

 abstract public class school
{
   abstract public void location();
   abstract public void name();

public void department(){
    System.out.println("CSE");       // concrete method (normal method) // non abstract class(concrete class)
}                                  //impure abstraction

}
class teacher extends school
{
    public void name()
    {
        System.out.println("pankaj Academy");
    }
    public void location()
    {
        System.out.println("whitefield");
    }

    public void teacherName()
    {
        System.out.println("Sai sir");
    }
}
class student extends  school
{
    public void name()
    {
        System.out.println("Trident");
    }
    public void location()
    {
        System.out.println("Marathali");
    }
}