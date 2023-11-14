import java.util.Hashtable;

public class Library extends Building {

  /* Class attribute for books in the library where String is the title and the boolean is true if the book is available */
  private Hashtable<String, Boolean> collection;

  /* Constructor */
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>();
    System.out.println("You have built a library: 📖"); 
  }

  /* Overloaded Constructor for unknown library */
  public Library(){
    this("<no name>", "<no address>", 1);
  }

  /**
   * Adds a book to the collection
   * @param title name of the book and author
   */
  public void addTitle(String title){
    this.collection.put(title,  true);
    System.out.println("Added " + title + " to the library.");
  }

  /**
   * Removes a book from the collection
   * @param title name of the book and author to remove
   * @return String title/author of the book
   */
  public String removeTitle(String title){
    this.collection.remove(title);
    System.out.println("Removed " + title + " from the library.");
    return title;
  }

  /**
   * Makes sure book is avaible and in collection before checking it out
   * @param title title and author of book to check out
   */
  public void checkOut(String title){
    if (this.containsTitle(title) == false){
      throw new RuntimeException("This book is not part of this collection");
    }
    if (this.collection.get(title) == true){
      this.collection.replace(title, false);
      System.out.println(title + " checked out");
    }
    else{
      throw new RuntimeException("This book is not available");
    }
  }

  /**
   * Makes sure book is checked out and in collection before returning book
   * @param title title and author of book to return
   */
  public void returnBook(String title){
    if (this.containsTitle(title) == false){
      throw new RuntimeException("This book is not part of this collection");
    }
    if (this.collection.get(title) == false){
      this.collection.replace(title, true);
      System.out.println(title + " returned");
    }
    else{
      throw new RuntimeException("This book is not checked out");
    }
  }

  /**
   * Checks if book is in collection
   * @param title title and author of book to check
   * @return true if in collection, false if not
   */
  public boolean containsTitle(String title){
    return this.collection.containsKey(title);
  }

  /**
   * Makes sure book is part of the collection before seeing if it is checked out
   * @param title title and author of book to check
   * @return true if available, false if checked out
   */
  public boolean isAvailable(String title){
    if(this.containsTitle(title) == false){
      throw new RuntimeException("This book is not part of this collection");
    }
    return this.collection.get(title);
  }
/**
 * Prints out the library's collection, including availability
 */
  public void printCollection(){
    System.out.println("--- Library Collection ---");
    this.collection.forEach((key, value) -> {if(value == true){System.out.println(key + " is available");} else{System.out.println(key + " is checked out");}});
  }

  /* Overloaded printCollection to print only available books or only checked out books */
  public void printCollection(Boolean availableBooks){
    if (availableBooks == true){
      System.out.println("--- Library Collection: Available ---");
      this.collection.forEach((key, value) -> {if(value == true){System.out.println(key);}});
    } else{
      System.out.println("--- Library Collection: Checked Out ---");
      this.collection.forEach((key, value) -> {if(value != true){System.out.println(key);}});
    }
  }

  /**
   * Tells user what methods are available
   */
  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n) + addTitle(title) + removeTitle(title) + checkOut(book) + returnBook(book) + containsTitle(book) + isAvailable(book) + printCollection()");
  }


  public static void main(String[] args) {
    Library Nielson = new Library("Nielson", "Above Burton Lawn", 5);
    Nielson.addTitle("The Lorax by Dr. Suess");
    Nielson.checkOut("The Lorax by Dr. Suess");
    Nielson.addTitle("LOTR");
    Nielson.printCollection();
    Nielson.printCollection(true);
    Nielson.printCollection(false);

  }

}