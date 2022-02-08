import java.util.Scanner;

public class Main {

            public static void main (String [] args){

                Scanner scanner = new Scanner(System.in);

                System.out.println("Babafingo olmaya hoşgeldiniz prod by UGonullu Nam-ı Diğer PussyHunterbutSometimesMagneton");

                String idmanlar = "Geçerli Hareketler\n"+
                                "Burpee\n"+
                                "PushUp\n"+
                                "SitUp\n"+
                                "Squat\n";
                System.out.println(idmanlar);
                System.out.println("************************");
                System.out.println("Bir İdman Oluşturun");
                System.out.println("*************************");

                System.out.println("Burpee Sayısı:" );
                int burpee = scanner.nextInt();

                System.out.println("PushUp Sayısı:");
                int pushUp = scanner.nextInt();

                System.out.println("SitUp Sayısı :");
                int sitUp = scanner.nextInt();

                System.out.println("Squat Sayısı:");
                int squat = scanner.nextInt();
                scanner.nextLine();

                Class idman = new Class(burpee,pushUp,sitUp,squat);

                System.out.println("Gacı Avlama Programı Başlasın...");


                while (idman.idmanBittiMi() == false) {
                    System.out.println("Hareket Türü (Burpee, PushUp, SitUp, Squat) :");
                    String tur = scanner.nextLine();
                    System.out.println("Kaç kere basacaksın gacıya?");
                    int tekrar = scanner.nextInt();
                    scanner.nextLine();
                    idman.hareketiYap(tur,tekrar);


                }


            }
}
