package yazlab;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import static yazlab.arayuz.bar;
import static yazlab.arayuz.text;
import static yazlab.threadOlusturucu.doldurucu;
import static yazlab.threadOlusturucu.sayac;
import static yazlab.threadOlusturucu.silici;
import static yazlab.threadOlusturucu.threadOlusturucu;

public class AnaThread implements Runnable {

    public static int istek = 0;
    public static int rand_istek;
    public static int rand_cevap;
    public static int ana_kapasite = 10000;
    public int istek_alma_zamanı = 5;
    public int cevap_verme_zamanı = 2;

    @Override
    public void run() {

        Random r = new Random(); //random sayı üretmek için
        int time = 3;//threadin bekleme zamanını tutuyor
        try {
            while (true) {
                Thread.sleep(time);//thread i beklemeye alıyor

                if (time % istek_alma_zamanı == 0) {
                    rand_istek = r.nextInt(3801);//thread e eklenecek olan istek sayısı
                    istek = istek + rand_istek;//gelen isteklerin toplamı
                    if (istek > ana_kapasite) {//isteklerin kapasiteyi geçmesini önlemek için
                        istek = ana_kapasite;
                    }
                }
                if (istek != 0) {//istek 0 ise cevaplama yapmaz
                    if (time % cevap_verme_zamanı == 0) {
                        rand_cevap = r.nextInt(151);
                        synchronized (this) {
                            istek = istek - rand_cevap;
                        }

                        if (istek < 0) {// isteklerin - ye düşmemesi için 
                            istek = 0;
                        }
                    }
                }

                System.out.println(istek);

                bar.setMinimum(0);
                bar.setMaximum(ana_kapasite);//barın sınırı 
                bar.setValue(istek);//barda gözüken sayı
                bar.setStringPainted(true);

                time += 1;
                synchronized (this) {
                    threadOlusturucu();
                    doldurucu();
                    silici();
                }

                String t = Integer.toString(sayac);
                text.setText(t);

            }

        } catch (InterruptedException ex) {
            Logger.getLogger(AnaThread.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
