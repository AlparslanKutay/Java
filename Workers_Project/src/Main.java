import java.util.Scanner;

public class Main {

    public static void main (String [] args){

    Scanner scanner = new Scanner(System.in);

    System.out.println("Çalışanlar Programına hoşgeldiniz...");

    String işlemler = "İşlemler...\n"+
                        "1.Yazılımcı İşlemleri\n"+
                        "2.Yönetici İşlemleri\n"+
                        "Çıkış için q'ya basın";


        System.out.println("--------------------------------------");
        System.out.println(işlemler);
        System.out.println("-------------------------------------");

        while (true){
            System.out.println("İşlemi Seçiniz:");
            String işlem = scanner.nextLine();

            if (işlem.equals("q")){
                System.out.println("Programdan çıkılıyor");
                break;
            }
            else if (işlem.equals("1")) {
                Yazılımcı yazılımcı = new Yazılımcı("Alp Kutay", "Atasever", 40, "İngilizce - Almanca - Fransızca - Arapça ");
                String yazılımcı_işlem = "1. Format At\n" +
                        "2.Bilgileri Göster" +
                        "Çıkış için q'ya bas";
                System.out.println(yazılımcı_işlem);


                while (true) {
                    System.out.println("İşlemi Seçiniz:");
                    String y_işlem = scanner.nextLine();
                    if (y_işlem.equals("q")) {
                        System.out.println("Program baysss");
                        break;
                    } else if (y_işlem.equals("1")) {
                        System.out.print("İşletim Sistemi:");
                        String i_sistem = scanner.nextLine();
                        yazılımcı.formatAt(i_sistem);
                    } else if (y_işlem.equals("2")) {
                        yazılımcı.bilgileriGoster();
                    } else {
                        System.out.println("Ne arıyorsun AmQ?");

                    }


                }
            }

                else if (işlem.equals("2")){
                    Yonetici yönetici = new Yonetici("Soner","Atasever",25,48);
                    String yonetici_islemleri = "Yönetici işlemleri\n"+
                                                "1. Zam Yap\n"+
                                                "2.Bilgileri Göster\n"+
                                                "Çıkmak için q'ya basın";
                while (true) {
                    System.out.println("İşlemi Seçiniz: ");
                    String y_islem = scanner.nextLine();

                    if (y_islem.equals("q")){
                        System.out.println("Yönetici İşlemlerinden Çıkılıyor...");
                        break;

                    }
                    else if (y_islem.equals("1")) {
                        System.out.print("Yöneticinin ne kadar zam yapmasını istiyorsunuz : ");
                        int zamMiktari = scanner.nextInt();
                        scanner.nextLine();
                        yönetici.zamYap(zamMiktari);

                    }
                    else if (y_islem.equals("2")){
                        yönetici.bilgileriGoster();

                    }
                    else {
                        System.out.println("Geçersiz Yönetici İşlemi....");
                    }


                }

            }
            else {
                System.out.println("Geçersiz İşlem....");
            }


        }


    }
}








