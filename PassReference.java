// my class
import java.lang.Boolean;
import java.util.concurrent.atomic.AtomicBoolean;

class OuterClass {

    private Boolean isConnetionBroken;

    public OuterClass()
    {
        isConnetionBroken = Boolean.valueOf(false);
    }

    public void setIsConnetionBroken(Boolean value)
    {
        isConnetionBroken = value;
    }

    public Boolean getIsConnetionBroken()
    {
        return isConnetionBroken;
    }


}

class Editer {
    // public member variable
    public int number;
    private OuterClass out;
 
    private Boolean b;
    private AtomicBoolean ab;
    // default constructor
    public Editer()
    {
      number = 1;
    }

    public Editer(OuterClass outerClass)
    {
      number = 1;
      this.out = outerClass;
    }

    public Editer(Boolean value)
    {
      number = 1;
      b = value;
    }

    public Editer(AtomicBoolean value)
    {
      number = 1;
      ab = value;
    }

    public void setOuterClassTrue(Boolean value)
    {
        out.setIsConnetionBroken(value);
    }

    public Boolean getOuterClassIsTrue()
    {
        return out.getIsConnetionBroken();
    }

    public void setBooleanValue(Boolean value)
    {
        b = value;
    }

    public Boolean getBooleanValue()
    {
        return b;
    }

    public void setAtomicBooleanValue(boolean value)
    {
        ab.set(value);
    }

    public boolean getAtomicBooleanValue()
    {
        return ab.get();
    }

}
  
  // driver function
  class Main{
    public static void main (String [] arguments)
    {
        // creating object
        //   Boolean isTrue = Boolean.valueOf(false);
        OuterClass outerObject = new OuterClass();
        Editer object = new Editer(outerObject);
 
        Boolean b_object = new Boolean(false);
        Editer object2 = new Editer(b_object);

        AtomicBoolean ab_object = new AtomicBoolean(false);
        Editer object3 = new Editer(ab_object);
        // printing before update
        System.out.println("object number = " + object.number);
        System.out.println("object2 number = " + object2.number);
        System.out.println("object3 number = " + object3.number);
        System.out.println("\n");
        // update function called.
        update(object);
        update2(object2);
        update3(object3);
        //printing after update.
        System.out.println("After update:");
        System.out.println("\n");

        System.out.println("number = " + object.number);
        System.out.println("object getOuterClassIsTrue = " + object.getOuterClassIsTrue());
        System.out.println("outerObject isConnetionBroken = " + outerObject.getIsConnetionBroken());
        System.out.println("\n");

        System.out.println("number = " + object2.number);
        System.out.println("object2 getBooleanValue = " + object2.getBooleanValue());
        System.out.println("outer_boolean value = " + b_object);
        System.out.println("\n");

        System.out.println("number = " + object3.number);
        System.out.println("object3 getBooleanValue = " + object3.getAtomicBooleanValue());
        System.out.println("outer_atomic_boolean value = " + ab_object);
        // 2022-01-05
        //总结：传递对象类似传递引用（地址）。
        //1.若要改变对象的值，则update函数不能赋值，赋值相当于把地址指向了新的内存对象，需要用set()之类的函数去改变对象的成员值才能更新成功；
        //2. Boolean类和AtomicBoolean类的区别在于，后者有set()函数，前者没有set()函数(immutable)，因此Boolean类不可以更新对象的内容；
    } 
    // update function.
    public static void update( Editer obj ){ 
        // increments number variable.       
        obj.number++;
        obj.setOuterClassTrue(true);
    }
    // update function.
    public static void update2( Editer obj ){ 
        // increments number variable.       
        obj.number++;
        obj.setBooleanValue(true);
    }

    public static void update3( Editer obj ){ 
        // increments number variable.       
        obj.number++;
        obj.setAtomicBooleanValue(true);
    }

  }
