import java.util.ArrayList;

public class House extends Building {
  /* Class Attributes */
  private ArrayList<String> residents; 
  private boolean hasDiningRoom;
  private boolean hasElevator;

  /* Constructor */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors);
    this.residents = new ArrayList<>();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
    System.out.println("You have built a house: 🏠");
  }

  /* Overloaded Constructor for empty house*/
  public House(){
    this("<no name>", "<no address>", 1, false, false);
  }

  /* Overloaded Constructor for house without known address */
  public House(String name, int nFloors, boolean hasDiningRoom, boolean hasElevator){
    this(name, "<no address>", nFloors, hasDiningRoom, hasElevator);
  }

  /* Accessors */
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }

  public int nResidents(){
    return residents.size();
  }

  public boolean hasElevator(){
    return this.hasElevator;
  }

  /**
   * Adds a student to residents when they moves in
   * @param name The name of the student
   */
  public void moveIn(String name){
    residents.add(name);
  }

  /**
   * Removes a student from residents when they moves out
   * @param name The name of the student
   * @return The name of the student
   */
  public String moveOut(String name){
    residents.remove(name);
    return name;
  }

  /**
   * Checks if a student is a resident of the house
   * @param person name of the student
   * @return true if they live in the house, false otherwise
   */
  public boolean isResident(String person){
    return residents.contains(person);
  }

  /**
   * Tells user what methods are available
   */
  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n) + moveIn(name) + moveOut(name) + isResident(name)");
  }

  /**
   * Overrides the method to account for houses without elevators.
   */
  public void goToFloor(int floorNum){
    if (this.hasElevator == true){
      super.goToFloor(floorNum);
    } 
    else{
      System.out.println(this.name + " does not have an elevator. Please use goUp() or goDown() to take the stairs!");
    }
  }


  public static void main(String[] args) {
    House Talbot = new House("Talbot", "25 Prospect St", 5, false, false);
    System.out.println(Talbot.getFloors());
    Talbot.enter();
    Talbot.goToFloor(2);
    House Duckett = new House("Duckett", "Address", 3, true, true);
    Talbot.exit();
    Duckett.enter();
    Duckett.goToFloor(3);
  }

}