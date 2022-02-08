import java.util.Scanner;

public class Main {
    public static int ebobBulma(int sayı1, int sayı2){
        int ebob = 1;
        for (int i =1; i<= sayı1 && i<= sayı2; i++){
            if ((sayı1 % 1 == 0) && (sayı2 % 1 == 00)) {

                ebob = i;

            }
        }
        return ebob;
    }
    public static void main (String [] args){
        Scanner scanner= new Scanner(System.in);
        System.out.println("type a value:");
        int value1 = scanner.nextInt();
        System.out.println("type a second value:");
        int value2 = scanner.nextInt();
        System.out.println("İki sayının ebobunu bulma:"+ebobBulma(value1,value2));

    }
}
