import java.util.ArrayList;

public class Houses extends Place {
    private double xcoordinate;
    private double ycoordinate;

    private Houses(double xcoordinate, double ycoordinate) {
        super();
        this.xcoordinate = xcoordinate;
        this.ycoordinate = ycoordinate;

        }
        @Override


        public String toString() {
            return "x-axis=" + xcoordinate + ", y-axis=" + ycoordinate + "" + super.toString();
        }


    @Override


    public void shortestDistance(Place p, ArrayList places , double x1, double y1, double x2, double y2) {

        double result = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        return result;
}

}



