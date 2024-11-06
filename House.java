import java.util.ArrayList;
/**
 * A House class. Child of building. 
 */
public class House extends Building{

  private ArrayList<String> residents; 
  private boolean hasDiningRoom;
  private boolean hasElevator;
  private boolean hasTV;
  
  enum Roomtype {
    SINGLE,
    DOUBLE,
    TRIPLE,
    SUITE;
  }

  /**
   * A constructor that creates a House. 
   * @param name The name of the house
   * @param address The address of the house.
   * @param nFloors The number of floors of the house. 
   * @param hasDiningRoom A boolean T if the house has a dining room F if it doesn't. 
   * @param hasElevator A boolean T if the house hae an elevator F if it doesn't.
   */
  public House(String name, String address, int nFloors, Boolean diningRoom, Boolean elevator) {
    super(name, address, nFloors);
    residents = new ArrayList<String>();
    this.hasDiningRoom = diningRoom;
    this.hasElevator = elevator;
    this.hasTV = true;
    System.out.println("You have built a house: 🏠");
  }

  /**
   * A constructor that creates a House with a parameter for hasTV. 
   * @param name The name of the house
   * @param address The address of the house.
   * @param nFloors The number of floors of the house. 
   * @param hasDiningRoom A boolean T if the house has a dining room F if it doesn't. 
   * @param hasElevator A boolean T if the house has an elevator F if it doesn't.
   * @param hasTV A boolean T if the house has a TV F if it doesn't.
   */
  public House(String name, String address, int nFloors, Boolean diningRoom, Boolean elevator, Boolean hasTV) {
    super(name, address, nFloors);
    residents = new ArrayList<String>();
    this.hasDiningRoom = diningRoom;
    this.hasElevator = elevator;
    System.out.println("You have built a house: 🏠");
  }

  /**
   * An accessor returning whether a specific house has a dining room
   * @return T/F whether the house has a dining room or not
   */
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }

  /**
   * An accessor returning the total residents in a house. 
   * @return the total residents of a specific house. 
   */
  public int nResident(){
    return residents.size();
  }

    /**
   * A method moving a student into a house.
   * @param name The name of the student to be moved in. 
   */
  public void moveIn(String name){
    if(residents.contains(name)){
      throw new RuntimeException("This student is already a resident.");
    }
    else{
      residents.add(name);
    }
  }

  /**
   * A method moving a student into a house into a specific roomtype.
   * @param name The name of the student to be moved in. 
   * @param roomType an enum describing the type of room the student is being moved into. 
   */
  public void moveIn(String name, Roomtype roomType){
    if(residents.contains(name)){
      throw new RuntimeException("This student is already a resident.");
    }
    else{
      residents.add(name);
      System.out.println(name + " has moved into a " + roomType + " in " + this.name);
    }
  }

  /**
   * A method moving a student out of a house. 
   * @param name the name of the student being moved out. 
   * @return the name of the student that was moved out. 
   */
  public String moveOut(String name){
    if(residents.contains(name)){
      residents.remove(name);
      return name;
    }
    else{
      throw new RuntimeException("This student isn't a resident.");
    }
  }

  /**
   * A method printing a list of options available at Houses. 
   */
  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + hasDiningRoom()\n + nResident()\n + moveIn()\n + moveOut()\n");
  }

  /**
   * A boolean method that tells us whether or not a given person is a resident of the house
   * @param person the name of the person
   * @return T if the person is a resident, F if they're not. 
   */
  public boolean isResident(String person){
    if(residents.contains(name)){
      return true;
    }
    else{
      return false;
    }
  }

  /**
   * A method moving a user to a specified floor. Movement options are determined on whether the house has an elevator. 
   * @param floorNum the floor the user will be moved to
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
          throw new RuntimeException("This house does not have an elevator. You must move one floor at a time");
        }
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
      }
    }    
  }


  public static void main(String[] args) {
    House Hubbard = new House("Hubbard", "3 Green Street", 4, false, false, false);
    System.out.println(Hubbard.hasTV);
    System.out.println(Hubbard.hasDiningRoom());
    Hubbard.moveIn("Ellie"); 
    Hubbard.moveIn("Paige");
    System.out.println(Hubbard.residents);
    Hubbard.moveOut("Ellie");
    System.out.println(Hubbard.residents);
    Hubbard.showOptions();
    Hubbard.enter();
    System.out.println(Hubbard.activeFloor);
    Hubbard.goToFloor(2);
    Hubbard.goToFloor(1);
    Hubbard.goToFloor(2);
    Hubbard.goToFloor(3);
    Hubbard.goToFloor(4);
    House Lamont = new House("Lamont", "2 Prospect ave.", 4, true, true);
    Lamont.enter(); 
    System.out.println(Lamont.hasElevator);
    Lamont.goToFloor(4);
    Lamont.goToFloor(1);
    Lamont.goUp();
    Hubbard.goDown();
    Lamont.moveIn("Ellie", Roomtype.DOUBLE);

  

  }

}