public class Yazılımcı extends Workers {

    private String diller;

    public Yazılımcı(String ad, String soyad, int id,String diller) {
        super(ad, soyad, id);
        this.diller = diller;
    }
    public void formatAt(String isletim_Sistemi) {

        System.out.println(getAd() + " " + isletim_Sistemi + "ni yüklüyoreee");
    }

    @Override
    public void bilgileriGoster() {
        super.bilgileriGoster();
        System.out.println("Yazılımcının bildiği dilleri göster:"+diller);
    }
}

