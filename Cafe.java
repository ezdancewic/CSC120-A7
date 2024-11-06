/**
 * A Cafe class. Child of a Building. 
 */
public class Cafe extends Building{

    private int nCoffeeOunces; 
    private int nSugarPackets; 
    private int nCreams; 
    private int nCups;

    /**
     * A constructor that creates a Cafe with a specified number of floors
     * @param name the name of the cafe
     * @param address the address of the cafe
     * @param nFloors how many floors a cafe has
     * @param startCoffeeOunces the initial ounces of coffee the cafe has in stock
     * @param startSugarPackets the initial packets of sugar the cafe has in stock
     * @param startCreams the initial creams the cafe has in stock
     * @param startCups the intial cups the cafe has in stock
     */
    public Cafe(String name, String address, int startCoffeeOunces, int startSugarPackets, int startCreams, int startCups, int nFloors) {
        super(name, address, nFloors);
        this.nCoffeeOunces = startCoffeeOunces; 
        this.nSugarPackets = startSugarPackets; 
        this.nCreams = startCreams;
        this.nCups = startCups;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * A constructor that creates a Cafe with only one floor
     * @param name the name of the cafe
     * @param address the address of the cafe
     * @param nFloors how many floors a cafe has
     * @param startCoffeeOunces the initial ounces of coffee the cafe has in stock
     * @param startSugarPackets the initial packets of sugar the cafe has in stock
     * @param startCreams the initial creams the cafe has in stock
     * @param startCups the intial cups the cafe has in stock
     */
    public Cafe(String name, String address, int startCoffeeOunces, int startSugarPackets, int startCreams, int startCups) {
        super(name, address);
        nFloors = 1;
        this.nCoffeeOunces = startCoffeeOunces; 
        this.nSugarPackets = startSugarPackets; 
        this.nCreams = startCreams;
        this.nCups = startCups;
        System.out.println("You have built a single-story cafe: ☕");
    }
    
    /**
     * A method that sells a cup of coffee 
     * @param size the size in oz. of coffee
     * @param nSugarPackets the number of sugar packets used by the coffee
     * @param nCreams the number of creams used by the coffee
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if(size < this.nCoffeeOunces && nSugarPackets < this.nSugarPackets && nCreams < this.nCreams){
            this.nCoffeeOunces = this.nCoffeeOunces - size; 
            this.nSugarPackets = this.nSugarPackets - nSugarPackets; 
            this.nCreams = this.nCreams - nCreams; 
            this.nCups = this.nCups - 1;
            System.out.println("You now have " + this.nCoffeeOunces + " Ounces of Coffee " + this.nSugarPackets + " Sugars " + this.nCreams + " Creams and " + this.nCups + " Cups.");
        }
        else{
            System.out.println("Restocking");
            this.restock(300, 200, 100, 25);
        }
    }

    /**
     * A method that sells a cup of coffee with a reusable cup
     * @param size the size in oz. of coffee
     * @param nSugarPackets the number of sugar packets used by the coffee
     * @param nCreams the number of creams used by the coffee
     * @param reusableCup whether the customer is using a reusable cup.
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams, boolean reusableCup){
        if(size < this.nCoffeeOunces && nSugarPackets < this.nSugarPackets && nCreams < this.nCreams){
            this.nCoffeeOunces = this.nCoffeeOunces - size; 
            this.nSugarPackets = this.nSugarPackets - nSugarPackets; 
            this.nCreams = this.nCreams - nCreams; 
            if(reusableCup == false){
                this.nCups = this.nCups - 1;
            }
            System.out.println("You now have " + this.nCoffeeOunces + " Ounces of Coffee " + this.nSugarPackets + " Sugars " + this.nCreams + " Creams and " + this.nCups + " Cups.");
        }
        else{
            System.out.println("Restocking");
            this.restock(300, 200, 100, 25);
        }
    }

    /**
     * A method that replenishes the cafe's inventory up to full
     * @param nCoffeeOunces the amount of coffee
     * @param nSugarPackets the amount of sugar
     * @param nCreams the amount of creams
     * @param nCups the amount of cups
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces = nCoffeeOunces; 
        this.nSugarPackets = nSugarPackets; 
        this.nCreams = nCreams;
        this.nCups = nCups;
    }

    /**
     * A method printing a list of options available at a Cafe. 
     */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + sellcoffee()\n + restock()\n");
    }

    /**
     * A method letting users navigate floors. However since all cafes only have 1 floor accessible to the public, it doesn't do anything.
     */
    public void goToFloor(int floorNum){
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }
        if (floorNum < 1 || floorNum > this.nFloors) {
            throw new RuntimeException("Invalid floor number. Cafes only have one floor accesible to the public");
        }
        if (floorNum > 1){
            throw new RuntimeException("Cafes only have one floor accessible to the public.");
        }
        System.out.println("You are still on floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
    }    

    public static void main(String[] args) {
        Cafe Woodstar = new Cafe("Woodstar", "2 Masonic St", 3, 300, 0, 100, 25);
        System.out.println(Woodstar);
        Woodstar.sellCoffee(8, 2, 2);
        System.out.println("Coffee " + Woodstar.nCoffeeOunces + " Sugar " + Woodstar.nSugarPackets + " Cream " + Woodstar.nCreams + " Cups " + Woodstar.nCups);
        Woodstar.sellCoffee(8, 3, 2);
        Woodstar.showOptions();
        Woodstar.enter();
        Woodstar.goToFloor(1);
        //Woodstar.goUp();
        //Woodstar.goDown();
        Cafe Tunic = new Cafe("Tunic", "3 Main St.", 300, 200, 50, 25);
        System.out.println(Tunic.nFloors);
        System.out.println(Tunic.nCups);
        Tunic.sellCoffee(8, 3, 2, true);
        Tunic.sellCoffee(8, 3, 2);
        
    }
    
}
