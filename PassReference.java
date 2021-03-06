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
        //??????????????????????????????????????????????????????
        //1.??????????????????????????????update????????????????????????????????????????????????????????????????????????????????????set()???????????????????????????????????????????????????????????????
        //2. Boolean??????AtomicBoolean??????????????????????????????set()?????????????????????set()??????(immutable)?????????Boolean????????????????????????????????????
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
