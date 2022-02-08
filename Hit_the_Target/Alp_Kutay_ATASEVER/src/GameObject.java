public class GameObject {
    // variables of games which we need to set up the game.
    public int type;
    public double xCoordinate;
    public double yCoordinate;
    public double Width;
    public double Height;
        // First Constructur for schematic stuff , and some other contents what Java need to set up the games.
    public GameObject(int type, double xCoordinate, double yCoordinate, double width, double height) {
        this.type = type;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        Width = width;
        Height = height;
    }

    public boolean isInside(double xball, double yball) {
        // 1) xCoordinate and yCoordinate values read from the file are the coordinates for the bottom-left corner of the game object
        // 2) ball is considered as a point (no radius)
        if (xball >= xCoordinate && xball <= xCoordinate + Width && yball >= yCoordinate && yball <= yCoordinate + Height)
            return true;
        else
            return false;
    }

    public void draw() {
        // xCoordinate and yCoordinate values read from the file are the coordinates for the bottom-left corner of the game object
        if (type == 1) {
            StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
            StdDraw.filledRectangle(xCoordinate + Width/2, yCoordinate + Height/2, Width / 2, Height / 2);
        }

        if (type == 2) {
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.filledRectangle(xCoordinate + Width/2, yCoordinate + Height/2, Width / 2, Height / 2);
        }

    }
}




