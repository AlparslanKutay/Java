import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class ATM {
    public void calis(Class hesap) {

        Login login = new Login();

        Scanner scanner = new Scanner(System.in);

        System.out.println("MONOPOLY");

        System.out.println("************************************************");
        System.out.println("Kullanıcı Girişi:");
        System.out.println("**********************************");
                int giris_hakkı= 3;
        while (true){
            if (login.login(hesap)){
                System.out.println("Giriş Başarılı...Hoşgeldiniz");
                break;

            }
            else {
                System.out.println("Giriş Başarısız...NapIyon Len AmQ?!");
                giris_hakkı -= 1;
                System.out.println("Kalan Giriş Hakkı : "+giris_hakkı);
            }
            if (giris_hakkı == 0){
                System.out.println("Hırsız mısın Birader?!");
                return;
            }
        }

        System.out.println("*********************************");
        String işlemler = "1. Bakiye Görüntüle\n"
                        +"2. Para Yatırma \n"
                        +"3. Para Çekme \n"
                        +"Çıkış için q'ya basın \n";
        System.out.println(işlemler);
        System.out.println("********************************");

        while (true){
            System.out.println("İşlem Seçiniz:");
            String işlem = scanner.nextLine();

            if (işlem.equals("q")){
                break;
            }
            else if (işlem.equals("1")){
                System.out.println("Bakiyeniz:"+hesap.getBakiye());
            }
            else if (işlem.equals("2")) {
                System.out.println("Yatırmak istediğiniz tutar:");
                double tutar = scanner.nextDouble();
                scanner.nextLine();
                hesap.paraYatırma(tutar);
            }
            else if (işlem.equals("3")) {
                System.out.println("Çekmek istediğiniz tutar:");
                double miktar = scanner.nextDouble();
                scanner.nextLine();
                hesap.paraCekme(miktar);
            }
            else {
                System.out.println("Error");

            }

        }


    }
}
