import java.util.Scanner;

public class Login {

public boolean login(Class hesap){

    Scanner scanner = new Scanner(System.in);
    String KullanıcıAdı;
    String Parola;

        System.out.println("Kullanıcı Adı:");
        KullanıcıAdı = scanner.nextLine();
        System.out.println("Parola:");
        Parola = scanner.nextLine();

        if(hesap.getKullanıcıAdı().equals(KullanıcıAdı) && hesap.getParola().equals(Parola)) {
            return true;
        }
        else {
            return false;
        }


    }
}
