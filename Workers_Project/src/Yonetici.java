public class Yonetici extends Workers{

    private int sorumlu_kisi_sayisi;

    public Yonetici(String ad, String soyad, int id, int sorumlu_kisi_sayisi) {
        super(ad, soyad, id);
        this.sorumlu_kisi_sayisi = sorumlu_kisi_sayisi;
    }

    @Override
    public void bilgileriGoster() {
        super.bilgileriGoster();
        System.out.println("Yöneticinin sorumlu olduğu kişi sayısı:"+sorumlu_kisi_sayisi);

    }
    public void zamYap (int zam_Miktarı){
        System.out.println(getAd()+" çalışanına"+zam_Miktarı+"kadar zam yapıyor.");


    }
}


