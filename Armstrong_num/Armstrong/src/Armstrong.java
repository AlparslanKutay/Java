import java.util.Scanner;

public class Armstrong {
    public static void main (String [] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lütfen bir sayı giriniz :" );
        int sayı = scanner.nextInt();
        System.out.println("Basamak sayısı:");
        int basamak_sayısı = scanner.nextInt();

        int gecici_sayı = sayı;
        int toplam = 0;

        do {
            int basamak_degeri = gecici_sayı%10;
            gecici_sayı = gecici_sayı/10;
            toplam += Math.pow(basamak_degeri,basamak_sayısı);

        }
            while (gecici_sayı>0);

            if (sayı == toplam){
                System.out.println("Bu sayı Armstrong sayısıdır");
            }
                else {
                System.out.println("Bu sayı bir Armstrong sayısı değildir.");
            }
    }
}
