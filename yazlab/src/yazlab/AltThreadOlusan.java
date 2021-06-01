package yazlab;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import static yazlab.AnaThread.istek;

public class AltThreadOlusan extends Thread implements Runnable {

    public int isteksub = 1750;//alt threadlere gelen istek sayısı
    public int rand_istek;//random olarak mainden çekilen istekler
    public int rand_cevap;//cevaplanan istek sayıları
    public int sub_kapasite = 5000;
    public int istek_alma_zamanı = 5;
    public int cevap_verme_zamanı = 3;

    @Override
    public void run() {
        Random r = new Random(); //random sayı üretmek için
        try {
            int time = 5;
            while (true) {
                Thread.sleep(time);

                if (time % istek_alma_zamanı == 0 && istek > 0) {//istek yoksa gelmez
                    rand_istek = r.nextInt(301);//thread e eklenecek olan istek sayısı
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

                time = time + 1;

            }
        } catch (InterruptedException ex) {
            Logger.getLogger(AltThreadOlusan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
