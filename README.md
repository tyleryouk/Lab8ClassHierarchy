# Lab8ClassHierarchy

Lab 8
Building a Class Hierarchy
In this lab, you will create a hierarchy of classes and abstract classes and start to learn some benefits of using the hierarchy.

If you did not join the recitation, you need to complete the first 5 tasks ( task 5 is inclusive).

Task 1. Assigning Lab Partners
The first thing that will occur in this lab is the assigning of lab partners. The teaching assistants in the recitation will pair you with another student.

Rules For The Lab
Your grade will be determined by how well you work as a member of a team. You will play two different roles in the lab. You will either be the driver or navigator.

driver: The person typing at the keyboard.
navigator: The person watching for mistakes, making suggestions, and thinking ahead.
Important: The driver is the only one who may do the typing. The navigator must not jump in and start editing.
Choose one of you to begin as the driver. The other will be the navigator, and the lab will tell you when to switch roles.

You do not have to complete all the tasks by the end of lab, but you do have to make a good effort.
The only ways to lose points when working as a team is 1) you do not show up on time, 2) you goof off, 3) you are the navigator and you take over editing the document from the driver, or 4) you sit quietly as the navigator and never offer suggestions.

Submitting the Lab
At the end of lab, submit your program. Both you and your lab partner should submit your code. Remember that your code is in a file with a .java extension, and depending on your browser, the extension may or may not be visible. Do not submit the file with the .class extension (that is Java bytecode) or the .java~ extension (that is a temporary editor file).

If you are new to programming, your goal is to make it to Task 6 during the lab session. If you are having trouble with Tasks 3 through 5, be sure to ask the lab assistant for help.
Task 2. Introductions and Starting DrJava
If you have a lab partner, tell your lab partner your name as well whether your favorite thing to do during the fall.

Choose one of you to start as the driver, and launch DrJava.

Task 3. A First Class Hierarchy.
In many computer games, we have a world filled with items that the game characters can pick up and use. Some items can be food, some items can be weapons, and so on. There can be hundreds of different items, and we want to avoid having to write giant if statements listing all the possible items.

First, get the Person.java file with this lab. You can see that currently a person has strength, intelligence, and energy.

Now, let's create items that the person can pickup and carry. For now, we want the following six items:

Apple
Sword
Hammer
Steak
Bread
Statue
We want each item to have a weight and a name associated with it. We want a person to be able to pick up an item as long as it is not too heavy.
To help us, let's create an abstract class that collects all of these properties into a single place.

I will start out by showing you one way to do that. Here is such an abstract class. Add this class to your code. Notice that it states that all items have weights and names. It also defines a toString method for the item. Initially the toString just uses the name of the item. The reason these are separate methods is so that later on we can have toString methods that can adjust to game situations.

public abstract class GameItem {
  private double weight;
  private String name;

  public GameItem(String name, double weight) {
    this.name = name;
    this.weight = weight;
  }

  public double getWeight() {
    return weight;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return getName();
  }
}
Now that we have this class, defining each of the items is easy. Here is the class for Apples. An apple does not weigh very much so I give it a very light weight.

public class Apple extends GameItem {
  public Apple() {
    super("Apple", 0.25);
  }
}
Create a class for each of the six objects. Then add two new methods to Person:

public boolean pickup(GameItem o): If the item weighs less than the strength of the person, return true and set a field indicating that the person is carrying this object.
GameItem drop(): Change the field so that the person is no longer carrying an object and return the object that was dropped. Return null if the person was not carrying anything.
To make things easy, right now we will assume a person can carry only one item at a time.
Compile and test your code. Make sure some items (like the statue) are too heavy to pickup.

Task 4. Adding to the Hierarchy: Food
Switch roles, the driver should navigate and the navigator should drive.

We want to designate some items as food. A food item should have calories that increase the energy of a person who eats it.

Create an abstract class Food that extends GameItem. Just as how GameItem has a weight, a Food should have a name, a weight (inherited from GameItem so do not create it), and calories.

Change Apple, Steak, and Bread to now extends Food intead of GameItem and give each some calories. For example, here is Apple:

public class Apple extends Food {
   public Apple() {
     super("Apple", 0.25, 10);
   }
}
Just as before, an apple is very light, and I decided that it should provide 10 game "calories".
Now create an eat method in Person. You should only be able to eat food and when you eat food, you should increase the energy of the person eating it.

Compile and test your code. You should still be able to carry all items but only eat food.

Task 5. Special Food
Switch roles, the driver should navigate and the navigator should drive.

It is quite common in games for food to give special benefits to the eater besides energy. For example, we could have apples increase intelligence, steak increase strength, and so on. We do not want a giant if statement inside the Person class to cover all the possibilities for the special food benefits.

Add the following method to the Food class:

public void eat(Person p) {
}
Next, change the eat method in Person to both increase the energy of the person, and to call the eat method of the Food.

Finally, override the eat method in Steak so that increases the strength of the person who ate the steak.

Compile and test your code. Eating steak should now increase a person's strength.

Task 6. Further Expanding the Heirarchy
Switch roles, the driver should navigate and the navigator should drive.

Let's create additional abstract subclasses of Food. The subclasses should be Meat, Vegetable (that includes fruit), and Grain. Then make the apple, steak, and bread classes extend these classes.

Now, create a Vegetarian that is a subclass of Person where a Vegetarian overrides the eat method so that it only eats food that is not meat.

Task 7. Adding a New Food Item
If you have a good hierarchy, adding new food items should be easy. Create a new food that is Carrot. A carrot is a vegetable, and a carrot will increase the intelligence of the person eating it. You should be able to add Carrot with these features by only creating the class Carrot. You should not have to adjust any other class of your program.

Task 8. Adding a New Kind of Class to the Hierarchy
Switch roles, the driver should navigate and the navigator should drive.

Create three new items:

Box
Bag
MagicBag
These new items have the following features. As a hint, you will want an abstract class to put the behavior that is common to all (or most) of the box, bag, and magic bag in the abstract class. You will want to place the abstract class inside your heirarchy so that some of the behvior below is already done. That way you do not have to duplicate very much code.
A person can carry them
A person cannot eat them
Another item can be placed inside the bag, box, or magic bag (including another bag, box, or magic bag). Hint: you want a getter/setter method.
The bag, box, and magic bag has a capacity and you can only place an item inside it if the item weighs less than the bag, box, or magic bag capacity.
The weight of a bag or box is the weight of the empty bag or box plus the weight of what is inside it. (Hint: Override a method.)
The weight of a magic bag is the weight of the empty magic bag plus half the weight of the item inside it. (Hint: Override a method.)
The toString method should change to include the item inside it. So, if a box is empty, the toString method should return "Box", but if it has a steak inside it, it should return "Box of Steak".
Compile and test your code.

Task 9. Using Interfaces
Switch roles, the driver should navigate and the navigator should drive.

I want to add weapons to the game. But I want to allow lots of things to be weapons (but not everything). For example, besides the Sword and Hammer, we could allow things like a bag of rocks, or even a loaf of bread (because why not). We can't group all these different classes under a common abstract class as before without breaking our current hierarchy. Instead, we can designate items that are weapons using an interface.

Create a Weapon interface, set sword, hammer, bread, and bag to all be weapons.
Add the ability for a person to wield a weapon, but it should only be one of these four weapons.
Give each weapon a power rating. Because we are using an interface, you can only specify the getter method for the power rating in the interface. You will either need to do this without a field or find an appropriate place to put a field.
Have the power rating for a bag depend on the weight of the item inside the bag.
Compile and test your code.

Task 5. Finishing Up
Both you and your lab partner should submit your lab. You should submit all the .java files you created. Please do that now.
