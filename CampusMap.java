import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));

        myMap.addBuilding(new Building("Seelye Hall", "2 Seelye Dr", 4));
        myMap.addBuilding(new House("Hubbard", "3 Green St.", 4, false, false, false));
        myMap.addBuilding(new House("Lamont", "5 Prospect Ave.", 3, true, true));
        myMap.addBuilding(new House("Tyler", "12 Green St.", 4, true, false));
        myMap.addBuilding(new Library("Neilson", "7 Neilson Dr.", 5));
        myMap.addBuilding(new Library("Hillyer", "20 Elm St.", 2, false));
        myMap.addBuilding(new Library("Josten", "122 Green St", 3, false));
        myMap.addBuilding(new Cafe("Woodstar", "60 Masonic St", 300, 200, 100, 50));
        myMap.addBuilding(new Cafe("Iconica", "1 Amber Ln", 300, 200, 100, 50, 2));
        myMap.addBuilding(new Cafe("Tunic", "186 Main St", 100, 50, 50, 20));
        System.out.println(myMap);
    }
    
}
