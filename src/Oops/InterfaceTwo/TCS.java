package Oops.InterfaceTwo;

interface TCS {
    int a=9;
    void devops();
}
interface    infosys
{
    void frontend();
}
interface accenture
{
    void dev();

}
interface cognizant
{
void backend();
}
class wipro implements infosys ,accenture,cognizant
{
   public void frontend(){
       System.out.println("developer easy");
    }
    public void dev(){
        System.out.println("developer fullstack");
    }
    public void devops(){
        System.out.println("devoops eng");
    }
    public void backend(){
        System.out.println("backend eng");
    }
}



