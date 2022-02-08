import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main<places> {
    public static void main(String[] args) {

        String filename = "data1.txt";
        File file = new File(filename);
        Scanner input = null;
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println(filename + ": Input file can not be found!\nExiting program...");
            System.exit(1);
        }

        ArrayList<Place> places = new ArrayList<>();
        while (input.hasNext()) {
            String line = input.nextLine();
            String[] parts = line.split(";");
            if (parts[3].equals("Migros")) {
                double Xcoordinate = Integer.parseInt(parts[0]);
                double Ycoordinate = Integer.parseInt(parts[1]);
                int placeType = Integer.parseInt(parts[2]);
                Migros temp = new Migros(xcoordinate, ycoordinate);
                temp.placeType = placeType;
                places.add(temp);
            } else {
                double Xcoordinate = Integer.parseInt(parts[0]);
                double Ycoordinate = Integer.parseInt(parts[1]);
                int placeType = Integer.parseInt(parts[2]);
                Houses temp = new Houses(xcoordinates, ycoordinates);
                temp.placeType = placeType;
                places.add(temp);


            }
        }

        System.out.println("Best Path:");
        for (Place p : places) {
            System.out.println(p);
        }


            for (Place p : places) {
                for (Migros m : places) {
                    for (Houses h : places) {


                        public static void shortestDistance (Migros, Houses, Place){

                            System.out.println("\n Distances");
                            for (Place p : places) {
                                System.out.println(p);

                            }
                        }
                    }
                }
            }
        private static void findingShortestDistances (ArrayList < Place > places) {
            for (int i = 0; i < places.size(); i++)
                places.get(i).shortestDistance();
        }


    }