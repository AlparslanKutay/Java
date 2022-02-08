// A class representing cities for the trip application.
public class City {
    // private data fields
    private String Country; // Country
    private String name; //City
    private int longitude;//X-axis
    private int latitude;//Y-axis
    private int population;

    // constructor for creating a City object using given arguments
    City(String Country,String name, int longitude, int latitude,int population) {
        this.Country = Country;
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.population = population;
    }

    // A method to calculate and return the distance between this city and the destination city
    public double calculateDistance (City c1) {
        double xcord = longitude;
        double ycord = latitude;
        double x1cord = c1.longitude;
        double y1cord = c1.latitude;
        // distances between two longitudes are 85 km
        // distances between two latitudes are 111 km

        double distance = Math.sqrt(Math.pow((x1cord - xcord) * 85, 2) + Math.pow((y1cord - ycord) * 111, 2));
        return distance;
    }

    // A method to return the name of this city
    public String getName() {
        return name;
    }


}