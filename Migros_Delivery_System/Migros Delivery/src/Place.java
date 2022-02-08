
public class Place {

    private double xcoordinate;
    private double ycoordinate;
    private int placeType;

    public Place(int placeType, double xcoordinate, double ycoordinate){
        this.placeType = placeType;
        this.xcoordinate = xcoordinate;
        this.ycoordinate = ycoordinate;
    }

    public double getXcoordinate() {
        return xcoordinate;
    }

    public double getYcoordinate() {
        return ycoordinate;
    }
    
    @Override
    public String toString() {
        return "xcoordinate" + xcoordinate + ",ycoordinate" + ycoordinate + ",placeType" + placeType;
    }
}



