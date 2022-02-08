import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MovingObject {
    public static void main(String[] args) throws FileNotFoundException {
        // canvas parameters
        int width = 1500;
        int height = 750;
        // initialize the canvas
        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);
        StdDraw.enableDoubleBuffering();
     //try to reading txt file to java
        String filename = "game_environment1.txt";
        File f = new File(filename);
        Scanner reader = new Scanner(f);
        ArrayList<GameObject> objects = new ArrayList<>();
        GameObjectCreator(reader, objects);

     //initalize the value of projectile motion formula and using the boolean method for checking to inside and outside (Also hitted etc.)
        int rectHalfSize = 100;
        int x0 = rectHalfSize;
        int y0 = rectHalfSize;
        double angle = 45;
        double v = 40, vx, vy;
        boolean inside = false;
        double g = 9.80665;
        double t = 0;
        boolean isGameOver = false;
        boolean isHitted = false;
        boolean isQuited = false;
        while (!isGameOver) {  // when equal the false program starting to refresh
            StdDraw.clear();  // For restarting again...

            for (GameObject x : objects) {  // Using the variables with using Object-Oriented Class method.
                x.draw();
            }

            StdDraw.setPenColor(StdDraw.MAGENTA); // organize to color of square which is throwing area
            StdDraw.filledSquare(0, 0, rectHalfSize); // arrange to size
            vx = v * Math.cos(Math.toRadians(angle)); // the x axis in the formula with writing cos functions
            vy = v * Math.sin(Math.toRadians(angle)); // the y azis in the formula with writing sin functions
            StdDraw.setPenColor(StdDraw.MAGENTA); // organize to color of line (using for target)
            StdDraw.line(x0, y0, x0 + vx, y0 + vy);  // arrange to size how to connect with coordinates
            StdDraw.setPenColor(StdDraw.BLACK); // after the throw line show where it goes the ball
            StdDraw.filledCircle(x0, y0, 2); // arrange to size of line


            StdDraw.text(30, 725, "a: " + angle); // show the angle while users are controlling with keys the angles
            StdDraw.text(40, 700, "v: " + String.format("%.2f", v)); // show the velocity while users are controlling with keys the velocity


            if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) {
                //velocity will decrease
                v--;
            }
            if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) {
                //velocity will increase
                v++;
            }
            if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN) && angle > 0) {
                //angle will decrease
                angle--;
            }
            if (StdDraw.isKeyPressed(KeyEvent.VK_UP) && angle < 90) {
                //angle will increase
                angle++;
            }
            double xt = x0 + vx * t; // formulas of projectile motion , x of t = X_0 which means where stuff is stayed, + (velocity of xaxis * time)
            double yt = (y0 + (vy * t)) - (g * Math.pow(t, 2) / 2); // formulas of projectile motions, y of t = Y_0 which means where stuff is stayed on Yaxis, (velocity of y * time)- gravity *t^2 (flight time)
            if (StdDraw.isKeyPressed(KeyEvent.VK_SPACE)) { // all of formulas and codes for throwing the ball
                while (xt <= width && yt >= 0 && yt <= height && !inside) { // condition of inside
                    xt = x0 + vx * t;
                    yt = (y0 + (vy * t)) - (g * Math.pow(t, 2) / 2);
                    StdDraw.filledCircle(xt, yt, 2);

                    t += 0.03;
                    for (GameObject object : objects) {
                        if (object.isInside(xt, yt)) {
                            inside = true;

                            if (object.type == 1) { // txt parameters from obstacle is 1 so Java read 1 = obstacle
                                StdDraw.text(750, 725, "Hit Obstacle");
                                isHitted = true;
                                break;
                            } else if (object.type == 2) { // txt parameters from target is 2 so Java read 2 = target
                                StdDraw.text(750, 725, "Hit Target");
                                isHitted = true;
                                break;
                            }

                        }


                    }


                    StdDraw.show();
                }
                if (!isHitted) { // if the balls does not hit the target or obstacle
                    StdDraw.text(750, 725, "Missed");

                }

                StdDraw.show(); // showing tbe output for games

                while (true) { // this loop is working for Play button of P and Quit button of Q
                    StdDraw.text(1300, 700, "P - Play Again");
                    StdDraw.text(1300, 675, "Q - Quit");
                    StdDraw.show();
                    if (StdDraw.isKeyPressed(KeyEvent.VK_Q)) {
                        isQuited = true;
                        break;
                    }

                    else if (StdDraw.isKeyPressed(KeyEvent.VK_P)) {
                        isGameOver = true;
                        break;
                    }

                }

                if (isQuited) {
                    System.exit(0);
                }

                if (isGameOver) { // restart the schema and other visuals while the user missing the target or obstacle
                    StdDraw.clear();
                    StdDraw.setCanvasSize(width, height);
                    StdDraw.setXscale(0, width);
                    StdDraw.setYscale(0, height);
                    StdDraw.enableDoubleBuffering();

                    objects = new ArrayList<>();
                    reader = new Scanner(f);
                    GameObjectCreator(reader, objects);

                    rectHalfSize = 100;
                    x0 = rectHalfSize;
                    y0 = rectHalfSize;
                    angle = 45;
                    v = 40;

                    inside = false;
                    g = 9.80665;
                    t = 0;
                    isGameOver = false;
                    isHitted = false;
                    isQuited = false;
                }


            }

            StdDraw.show(); // again the showing the visual content


        }


    }

    private static void GameObjectCreator(Scanner reader, ArrayList<GameObject> objects) { //the array list can help the java for reading the variables and making the line.
        while (reader.hasNextLine()) {
            String[] c = reader.nextLine().split(";"); // variables are seperating with ";"
            int type = Integer.parseInt(c[0].trim()); // first variable for what is the type of schema
            double xCoordinate = Double.parseDouble(c[1].trim()); // second variable for x coodinate of obstacle or target
            double yCoordinate = Double.parseDouble(c[2].trim()); // third variable for y coodinate of obstacle or target
            double Width = Double.parseDouble(c[3].trim()); // fourth variable for Width
            double Height = Double.parseDouble(c[4].trim()); // Fifth variable for Height
            GameObject d = new GameObject(type, xCoordinate, yCoordinate, Width, Height); // Using Object oriented method. to use the variables from other class
            objects.add(d); // adding the variables in objects
        }
    }
}


