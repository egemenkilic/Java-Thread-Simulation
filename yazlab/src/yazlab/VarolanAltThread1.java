package yazlab;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import static yazlab.AnaThread.istek;
import static yazlab.arayuz.bar1;

public class VarolanAltThread1 extends Thread implements Runnable {

    public static int isteksub = 0;//alt threadlere gelen istek sayısı
    public static int rand_istek;//random olarak mainden çekilen istekler
    public static int rand_cevap;//cevaplanan istek sayıları
    public static int sub_kapasite = 5000;
    public int istek_alma_zamanı = 5;
    public int cevap_verme_zamanı = 3;

    @Override
    public void run() {
        Random r = new Random(); //random sayı üretmek için
        try {
            int time = 0;
            while (true) {
                Thread.sleep(time);

                if (time % istek_alma_zamanı == 0 && istek > 0) {
                    rand_istek = r.nextInt(1001);//thread e eklenecek olan istek sayısı
                    isteksub = isteksub + rand_istek;//gelen isteklerin toplamı
                    synchronized (this) {
                        istek = istek - rand_istek;
                    }
                }
                if (isteksub != 0) {
                    if (time % cevap_verme_zamanı == 0) {
                        rand_cevap = r.nextInt(151);
                        isteksub = isteksub - rand_cevap;

                        if (isteksub < 0) {
                            isteksub = 0;
                        }
                    }
                }

                bar1.setMinimum(0);
                bar1.setMaximum(sub_kapasite);//barı kapasiteye göre ayarladım
                bar1.setValue(isteksub);//barda gözükecek olan sayı
                bar1.setStringPainted(true);

                time = time + 1;

            }
        } catch (InterruptedException ex) {
            Logger.getLogger(VarolanAltThread1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
