/* This is a stub for the Library class */
import java.util.Hashtable;
import java.util.Enumeration;

/**
 * A Library class. Child of Building. 
 */
public class Library extends Building {
  
  private Hashtable<String, Boolean> collection;
  private boolean hasElevator;
  

  /**
   * A constructor creating a Library requiring a library parameter. 
   * @param name the name of the library
   * @param address the address of the library. 
   * @param floors the number of floors in the library. 
   */
  public Library(String name, String address, int floors, Boolean elevator) {
    super(name, address, floors);
    this.hasElevator = elevator;
    collection = new Hashtable<String, Boolean>();
    System.out.println("You have built a library: 📖");
  }

  /**
   * An overloaded constructor creating a Library with a default parameter of an elevator. 
   * @param name the name of the library
   * @param address the address of the library. 
   * @param floors the number of floors in the library. 
   */
  public Library(String name, String address, int floors) {
    super(name, address, floors);
    this.hasElevator = true;
    collection = new Hashtable<String, Boolean>();
    System.out.println("You have built a library: 📖");
  }

  /**
   * A method adding a title to a specific library's collection. 
   * @param title the title of the book to be added. 
   */
  public void addTitle(String title){
    if(collection.containsKey(title)){
      throw new RuntimeException("This book is already in the collection.");
    }
    else{
      collection.put(title, true);
    }
  }

  /**
   * A method removing a title from a specific library's collection.
   * @param title The title to be removed. 
   * @return The title of the book that was removed. 
   */
  public String removeTitle(String title){
    if(collection.containsKey(title)){
      collection.remove(title);
      return title;
    }
    else{
      throw new RuntimeException("This book is not in the collection.");
    }
  }

  /**
   * A method to check out an available book from a specific library's collection. Update's the book's status to "false". 
   * @param title the title of the book to be checked out. 
   */
  public void checkOut(String title){
    if(collection.get(title)){
      collection.replace(title, false);
    }
    else{
      throw new RuntimeException("This book could not be checked out.");
    }
    
  }

  /*
   * A method returning a specified book to a library's colelction. Updates the book's statues to "true".
   */
  public void returnBook(String title){
    if(collection.get(title)){
      throw new RuntimeException("This book is not currently checked out");
    }
    else{
      collection.replace(title, true);
    }
  }

  /**
   * A method checking whether a book is in a specific library's collection. 
   * @param title the title of the book to be checked. 
   * @return T if the book is in the library's collection, F if the book isn't. 
   */
  public boolean containsTitle(String title){
    if(collection.containsKey(title)){
      return true;
    }
    else{
      return false;
    }
  }

  /**
   * A method checking the availability of a specific book in a library's collection. 
   * @param title The title of the book. 
   * @return T if the book is available, F if the book isn't. 
   */
  public boolean isAvailable(String title){ // need to ask if its in the collection first? 
    if(containsTitle(title)){
      if(collection.get(title)){
        return true;
      }
      else{
        return false;
      }
    }
    else{
      throw new RuntimeException("This book is not in the collection.");
    }
    
  }

  /**
   * A method that prints a formatted list of a library's collection. 
   */
  public void printCollection(){
    Enumeration<String> keys = collection.keys(); 
    Enumeration<Boolean> values = collection.elements();
    System.out.println("LIBRARY CATALOG");
    while( keys.hasMoreElements()){
      System.out.println("Title: " + keys.nextElement() + "     Available: " + values.nextElement());
    }
  }

  /**
   * A method printing a specified number of books from a library's collection. 
   * @param num The number of books to be printed. 
   */
  public void printCollection(int num){
    Enumeration<String> keys = collection.keys(); 
    Enumeration<Boolean> values = collection.elements();
    System.out.println("LIBRARY CATALOG: Items 1-" + num);
    for(int i = 0; i < num; i++){
      System.out.println("Title: " + keys.nextElement() + "     Available: " + values.nextElement());
    }
  }

  /**
   * A method printing a list of options available to users at Libraries. 
   */
  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + addTitle()\n + removeTitle()\n + checkOut()\n + returnBook()\n + containsTitle()\n + isAvailable()\n + printCollection()\n");
  }

  /**
   * A method moving the user to a specified floor 
   * @param floorNum the floor the user is moving to.  
   */
  public void goToFloor(int floorNum){
    if (this.activeFloor == -1) {
        throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
    }
    if (this.hasElevator){
      if (floorNum < 1 || floorNum > this.nFloors) {
        throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
      }
      System.out.println("You are now on floor #" + floorNum + " of " + this.name);
      this.activeFloor = floorNum;
    }
    else{
      if (floorNum < 1 || floorNum > this.nFloors) {
        throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
      }
      else{
        if (floorNum != this.activeFloor + 1 && floorNum != this.activeFloor - 1){
          throw new RuntimeException("This library does not have an elevator. You must move one floor at a time");
        }
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
      }
    }    
  }

  public static void main(String[] args) {
    Library Hillyer = new Library("Hillyer", "2 Elm", 2, false);
    Hillyer.addTitle("Somewhere Beyond the Sea by T.J. Klume"); 
    System.out.println(Hillyer.collection.get("Somewhere Beyond the Sea by T.J. Klume"));
    Hillyer.addTitle("Percy Jackson by Rick Riordan"); 
    Hillyer.addTitle("The Raven by Edgar Allan Poe");
    Hillyer.addTitle("Howl's Moving Castle");
    Hillyer.addTitle("Before the Coffee Gets Cold");
    Hillyer.printCollection();
    Hillyer.checkOut("The Raven by Edgar Allan Poe");
    Hillyer.printCollection();
    Hillyer.showOptions();
    Hillyer.enter();
    Hillyer.goUp();
    Library Neilson = new Library("Neilson", "3 library way", 5);
    Neilson.enter();
    Neilson.goToFloor(5);
    Hillyer.printCollection();
    Hillyer.printCollection(3);

    
  }
  }