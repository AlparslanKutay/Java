import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// A trip application that reads cities to be visited (in order) from a text file with their (x,y) coordinates,
// calculates the distance to each subsequent city to be visited, and finds the total trip distance.
public class WorldTripOne {
    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "trip2.txt";
        File file = new File(fileName);
        ArrayList<City> trip = readTripFile(file);
        printTrip(trip);


    }

    // A method to read the input trip file and return the trip array list.
    public static ArrayList<City> readTripFile(File file) throws FileNotFoundException {
        ArrayList<City> tripCities = new ArrayList<>(); // an array list to store cities
        Scanner sc = null; // may throw a FileNotFoundException
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("City database is loaded with 11210 cities." +
                    "john is not found in the city database. Incorrect city name in the trip file." +
                    "Exiting program.");
            System.exit(1);
        }

        while (sc.hasNextLine()) {
            // read country,read name, longitude ,latitude and population of each city
            String Country = sc.next();
            String name = sc.next();

            int longitude = sc.nextInt();
            int latitude = sc.nextInt();


            int population = sc.nextInt();
            // create the corresponding city and add it to the array list
            City city = new City(Country, name, longitude, latitude, population);
            tripCities.add(city);
        }
        sc.close(); // close the file
        return tripCities; // return the resulting array list
        // A method to print the trip details as the distance to each subsequent destination city and the total trip distance.
    }

    public static void printTrip(ArrayList<City> cities) {
        double totalDistance = 0;
        System.out.println("Trip details: ");


        for (int i = 1; i < cities.size(); i++) {
            // calculate the distance to each destination city
            double distance = cities.get(i - 1).calculateDistance(cities.get(i)) / 10000;
            // display cities (from -> to) as well as the distance between them

            System.out.printf("%-10s -> %-10s [%.0f km]\n", cities.get(i - 1).getName(), cities.get(i).getName(), distance);
            // calculate the total trip distance
            totalDistance = totalDistance + distance;
        }
        // display the total trip distance
        System.out.printf("\nTotal trip distance: %.0f km\n", totalDistance);
    }
}