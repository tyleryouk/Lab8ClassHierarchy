/** A person in a game */
import java.util.Scanner;
public class Person {

  private int strength;
  private int energy = 10;
  private int intelligence;

  public Person(int strength, int intelligence) {
    this.strength = strength;
    this.intelligence = intelligence;}

  public int getStrength() {return strength;}

  public void setStrength(int strength) {
    this.strength = strength; }

  public int getEnergy() {return energy;}

  public void adjustEnergy(int amount) {
    this.energy = this.energy + amount;}

  public int getIntelligence() {return intelligence;}

  public void setIntelligence(int intelligence) {
    this.intelligence = intelligence;}

  //to do: Create the following two methods:
  private GameItem itemCurrentlyHolding; //field indicating that the person is carrying this object
  
  public boolean pickup(GameItem o){
    if(o.getWeight() < this.getStrength()){ //if item weighs less than the strength of the person
      this.itemCurrentlyHolding = o; //carrying o object
      return true; } //return true
    else{return false;} }
  
  public GameItem drop(){
    GameItem droppedItem = itemCurrentlyHolding;
    itemCurrentlyHolding = null; //no longer holding item
    return droppedItem; }
  
  public void eat(GameItem o) {
  if (o instanceof Apple) {energy += ((Apple) o).calories;}
  else if (o instanceof Steak) {energy += ((Steak) o).calories;} 
  else if (o instanceof Bread) {energy += ((Bread) o).calories;} 
  else {return;}
 }
  
  //interactive game within main method for testing
  public static void main(String[] args) {
    //testing eat
    Person c = new Person(100,200);
    Apple appleyeah = new Apple();
    System.out.print("OG intelligence:"+c.getIntelligence());
    System.out.print(", OG strength:"+c.getStrength());
    System.out.println(", OG energy:"+c.getEnergy());
    c.pickup(appleyeah);
    c.eat(appleyeah);
    System.out.print("New intelligence:"+c.getIntelligence()); //should stay the same
    System.out.print(", New strength:"+c.getStrength()); //should stay the same
    System.out.println(", New energy:"+c.getEnergy()); //should increase by 10
                      
    
    //UnComment this section to test pickup and drop functionality
    /*
    Scanner sc = new Scanner(System.in);
    Person p = new Person(0,0); //adjust strength 
    boolean breakLoop = true;
    while (breakLoop) { 
      System.out.println("Enter 1 to Pick,1 2 to drop:, 3 to end Game");
      int choice = sc.nextInt();
      switch (choice) {
        //picking item
        case 1:
          System.out.println("Enter a number to choose a item given below:\n1.Apple\n2.Sword\n3.Hammer\n4.Steak\n5.Bread\n6.Statue");
          int itemNum = sc.nextInt();
          GameItem gi = null;
          switch (itemNum) {
            case 1:
              gi = new Apple();
              break;
            case 2:
              gi = new Sword();
              break;
            case 3:
              gi = new Hammer();
              break;
            case 4:
              gi = new Steak();
              break;
            case 5:
              gi = new Bread();
              break;
            case 6:
              gi = new Statue();
              break;
          }
//testing pickup
          if (p.pickup(gi))
            System.out.println("Person picked:" + gi.getName());
          else
            System.out.println("Person can't pick:" + gi.getName());
          break;

// testing drop
        case 2:
          GameItem giDrop = p.drop();
          if (giDrop == null)
            System.out.println("Person has nothing to drop");
          else
            System.out.println("Person dropped:" + giDrop.getName());
          break;
// Exiting game
        case 3:
          breakLoop = false;
          break;
      }
    }
  */
  }
}

