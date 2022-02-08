
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int bakiye = 200000;

        String işlemler = "1.İşlem : Bakiye öğrenme\n"+
                          "2.İşlem : Para çekme \n"+
                          "3. İşlem : Para Yatırma \n"+
                          "Çıkış için q'ya basın";
        System.out.println("*************************");
        System.out.println(işlemler);
        System.out.println("*************************");


        while(true){
            System.out.println("Lütfen işlem seçiniz:");
            String işlem = scanner.nextLine();

            if (işlem.equals("q")){
            System.out.println("Programdan Çıkılıyor...");
            break;
        }
        else if (işlem.equals("1")){
            System.out.println("Bakiyeniz:"+bakiye);

        }else if(işlem.equals("2")){
                System.out.println("Çekmek istediğiniz tutar:");
                int tutar =scanner.nextInt();
                scanner.nextLine();

                if (bakiye < tutar) {
                    System.out.println("Yeterli Paran yok.");
                }
                else {
                    bakiye -= tutar;
                    System.out.println("Yeni Bakiyeniz :"+ bakiye);
                }

                }
        else if (işlem.equals("3")){
                System.out.println("Yatırmak istediğiniz tutar:");
                int tutar1 = scanner.nextInt();
                scanner.nextLine();
                bakiye += tutar1;
                System.out.println("Yeni bakiyeniz:"+bakiye);
            }
        else {
                System.out.println("*");
            }
            }
        }
}



