
public class Cafe extends Building{
    /* Class Attributes */
    private int nCoffeeOunces; 
    private int nSugarPackets; 
    private int nCreams; 
    private int nCups; 

    /* Constructor */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }

    /* Overloaded Constructor */
    public Cafe(){
        this("<no name>", "<no address>", 1, 0, 0, 0, 0);
    }

    /**
     * Takes a coffee order, checks that the ingredients are in stock and restocks if not, decreases inventory based on order
     * @param size int Ounces in coffee
     * @param nSugarPackets int Sugar packets in coffee
     * @param nCreams int Creams in coffee
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        while(this.nCoffeeOunces <= size || this.nSugarPackets <= nSugarPackets || this.nCreams <= nCreams || this.nCups == 0){
            this.restock(10, 10, 10, 10);
        }
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
        System.out.println("Coffee Sold!");
    }

    /** Overloaded sellCoffee to sell a black coffee
     * @param size int Ounces in coffee
     */
    public void sellCoffee(int size){
        while(this.nCoffeeOunces <= size || this.nCups == 0){
            this.restock(10,0,0,10);
        }
        this.nCoffeeOunces -= size;
        this.nCups -= 1;
        System.out.println("Black Coffee Sold!");
    }

    /**
     * Increases the inventory
     * @param nCoffeeOunces int ounces of coffee to restock
     * @param nSugarPackets int sugar packets to restock
     * @param nCreams int creams to restock
     * @param nCups in cups to restock
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
        System.out.println("Restocked Shop!");
    }

    /**
    * Tells user what methods are available
    */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n) + sellCoffee(size, sugar, cream)");
    }

    /**
    * Overrides the method to not allow movement off of the ground floor.
    */
    public void goToFloor(int floorNum){
        System.out.println("No other public floors available.");
    }
    
    public static void main(String[] args) {
        Cafe Compass = new Cafe("Compass", "Nielson", 1, 40, 10, 10, 10);
        Compass.sellCoffee(12,2,2);
        Compass.sellCoffee(1,3,2);
        Compass.sellCoffee(12,1,0);
        Compass.sellCoffee(16,0,1);
        Compass.sellCoffee(8);
    }
    
}
