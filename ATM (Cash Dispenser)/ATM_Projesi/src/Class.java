public class Class {

    private String KullanıcıAdı;
    private String Parola;
    private double bakiye;

    public Class(String kullanıcıAdı, String parola, double bakiye) {
        KullanıcıAdı = kullanıcıAdı;
        Parola = parola;
        this.bakiye = bakiye;
    }

    public String getKullanıcıAdı() {
        return KullanıcıAdı;
    }

    public void setKullanıcıAdı(String kullanıcıAdı) {
        KullanıcıAdı = kullanıcıAdı;
    }

    public String getParola() {
        return Parola;
    }

    public void setParola(String parola) {
        Parola = parola;
    }

    public double getBakiye() {
        return bakiye;
    }

    public void setBakiye(double bakiye) {
        this.bakiye = bakiye;
    }
    public void paraYatırma (double tutar){
        bakiye+= tutar;
        System.out.println("Yeni bakiyeniz:"+bakiye);

    }
    public void paraCekme (double miktar){
        if (bakiye - miktar < 0) {
            System.out.println("Yeterli bakiyeniz bulunmamaktadır!" + bakiye + "İstediğiniz tutar:" + miktar);
        }
            if (miktar >= 1500){
                System.out.println("Bir gün içerisin de en fazla 1500 tl çekebilirsiniz. İstenilen miktar:"+miktar);

            }
            else {
                bakiye -= miktar;
        System.out.println("Yeni bakiyeniz :"+ bakiye);
        }

    }

}
