package Oops.InterfaceOne;


 public  class college {

 public void lib(){
     System.out.println("college library");
 }
 public void paper(){
     System.out.println("cllege paper");
 }
}

class teacher {
   public void book()
   {
        System.out.println("school library");
    }

}

class student
{
    public void CEO(college Obj)
    {
        System.out.println("CEO of both organisation");
        Obj.lib();
        Obj.paper();



    }
}
