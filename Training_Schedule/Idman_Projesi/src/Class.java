public class Class {


    private int burpee_sayisi;
    private int pushup_sayisi;
    private int situp_sayisi;
    private int squad_sayisi;

    public Class(int burpee_sayisi, int pushup_sayisi, int situp_sayisi, int squad_sayisi) {
        this.burpee_sayisi = burpee_sayisi;
        this.pushup_sayisi = pushup_sayisi;
        this.situp_sayisi = situp_sayisi;
        this.squad_sayisi = squad_sayisi;
    }

    public int getBurpee_sayisi() {
        return burpee_sayisi;
    }

    public void setBurpee_sayisi(int burpee_sayisi) {
        this.burpee_sayisi = burpee_sayisi;
    }

    public int getPushup_sayisi() {
        return pushup_sayisi;
    }

    public void setPushup_sayisi(int pushup_sayisi) {
        this.pushup_sayisi = pushup_sayisi;
    }

    public int getSitup_sayisi() {
        return situp_sayisi;
    }

    public void setSitup_sayisi(int situp_sayisi) {
        this.situp_sayisi = situp_sayisi;
    }

    public int getSquad_sayisi() {
        return squad_sayisi;
    }

    public void setSquad_sayisi(int squad_sayisi) {
        this.squad_sayisi = squad_sayisi;
    }

    public void hareketiYap(String hareketTuru, int hareketSayısı) {
        if (hareketTuru.equals("Burpee")) {
            burpeeYap(hareketSayısı);

        } else if (hareketTuru.equals("PushUp")) {
            pushupYap(hareketSayısı);
        } else if (hareketTuru.equals("SitUp")) {
            situpYap(hareketSayısı);

        } else if (hareketTuru.equals("Squad")) {
            squadYap(hareketSayısı);
        } else {
            System.out.println("Geçersiz Hareket...");
        }
    }
        public void burpeeYap ( int hareketSayısı){
            if (burpee_sayisi == 0) {
                System.out.println("Yapacak burpee kalmadı...");
            }
            if (burpee_sayisi - hareketSayısı < 0) {
                System.out.println("Bravo kardeşim protein tozu gibisin...");
                burpee_sayisi = 0;
                System.out.println("Kalan burpee:" + burpee_sayisi);
            } else {
                burpee_sayisi -= hareketSayısı;
                System.out.println("Kalan Burpee Sayısı:" + burpee_sayisi);

            }
        }
        public void pushupYap ( int hareketSayısı){
            if (pushup_sayisi == 0) {
                System.out.println("Yapacak Push Up kalmadı...");
            }
            if (pushup_sayisi - hareketSayısı < 0) {
                System.out.println("Bravo kardeşim protein tozu gibisin...");
                pushup_sayisi = 0;
                System.out.println("Kalan PushUp:" + pushup_sayisi);
            } else {
                pushup_sayisi -= hareketSayısı;
                System.out.println("Kalan Push Up Sayısı:" + pushup_sayisi);

            }
        }
        public void situpYap ( int hareketSayısı){
            if (situp_sayisi == 0) {
                System.out.println("Yapacak situp kalmadı...");
            }
            if (situp_sayisi - hareketSayısı < 0) {
                System.out.println("Bravo kardeşim protein tozu gibisin...");
                situp_sayisi = 0;
                System.out.println("Kalan situp:" + situp_sayisi);
            } else {
                situp_sayisi -= hareketSayısı;
                System.out.println("Kalan Burpee Sayısı:" + situp_sayisi);
            }
        }
        public void squadYap ( int hareketSayısı){
            if (squad_sayisi == 0) {
                System.out.println("Yapacak squad kalmadı...");
            }
            if (squad_sayisi - hareketSayısı < 0) {
                System.out.println("Bravo kardeşim protein tozu gibisin...");
                squad_sayisi = 0;
                System.out.println("Kalan Squad:" + squad_sayisi);
            } else {
                squad_sayisi -= hareketSayısı;
                System.out.println("Kalan Squad Sayısı:" + squad_sayisi);
            }
        }

        public boolean idmanBittiMi () {
            return (burpee_sayisi == 0) && (situp_sayisi == 0) && (pushup_sayisi == 0) && (squad_sayisi == 0);

        }
    }
