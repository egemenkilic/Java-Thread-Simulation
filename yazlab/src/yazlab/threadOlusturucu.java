package yazlab;

import java.util.ArrayList;
import static yazlab.VarolanAltThread1.sub_kapasite;
import static yazlab.arayuz.bar10;
import static yazlab.arayuz.bar11;
import static yazlab.arayuz.bar12;
import static yazlab.arayuz.bar13;
import static yazlab.arayuz.bar14;
import static yazlab.arayuz.bar15;
import static yazlab.arayuz.bar16;
import static yazlab.arayuz.bar17;
import static yazlab.arayuz.bar18;
import static yazlab.arayuz.bar19;

import static yazlab.arayuz.bar2;
import static yazlab.arayuz.bar20;
import static yazlab.arayuz.bar21;
import static yazlab.arayuz.bar3;
import static yazlab.arayuz.bar4;
import static yazlab.arayuz.bar5;
import static yazlab.arayuz.bar6;
import static yazlab.arayuz.bar7;
import static yazlab.arayuz.bar8;
import static yazlab.arayuz.bar9;

public class threadOlusturucu implements Runnable {

    public static ArrayList<AltThreadOlusan> alt = new ArrayList<AltThreadOlusan>();
    public static int index;
    public static int sayac = 0;
    public static int kapasite = 5000;
    public static int u = 0;

    public static void threadOlusturucu() {
        if (u == 0) {
            AltThreadOlusan t5 = new AltThreadOlusan();//hata almamak için
            alt.add(t5);
            u++;
        }
        for (int i = 0; i < alt.size(); i++) {//arraylistte tutulan threadler için 
            if (alt.get(i).isteksub >= kapasite * 70 / 100) {
                AltThreadOlusan t3 = new AltThreadOlusan();//oluşan çocuk threadler
                alt.get(i).isteksub = alt.get(i).isteksub / 2;
                t3.isteksub = alt.get(i).isteksub;
                alt.add(t3);
                alt.get(alt.size() - 1).start();//oluşan son threadi çalıştır
                sayac++;
            }

        }
        if (VarolanAltThread1.isteksub >= VarolanAltThread1.sub_kapasite * 70 / 100 || VarolanAltThread2.isteksub >= VarolanAltThread2.sub_kapasite * 70 / 100) {

            AltThreadOlusan t3 = new AltThreadOlusan();//oluşan çocuk threadler
            alt.add(t3);

            if (VarolanAltThread1.isteksub >= VarolanAltThread1.sub_kapasite * 70 / 100) {
                VarolanAltThread1.isteksub = VarolanAltThread1.isteksub - 1750;//1750 kapasitenin yüzde 70 inin yarısı
            }

            if (VarolanAltThread2.isteksub >= VarolanAltThread2.sub_kapasite * 70 / 100) {
                VarolanAltThread2.isteksub = VarolanAltThread2.isteksub - 1750;
            }

            alt.get(alt.size() - 1).start();

            sayac++;
            //System.out.println(sayac);

        }

    }

    public static void silici() {

        for (int i = 0; i < alt.size(); i++) {//arraylistte tutulan threadler için 
            if (alt.get(i).isteksub == 0 || alt.get(i).isteksub <= 0) {
                alt.remove(i);
                sayac--;
            }
        }
    }

    public static void doldurucu() {
        bar2.setMinimum(0);
        bar2.setMaximum(sub_kapasite);//barın sınırı 
        bar2.setStringPainted(true);
        bar2.setVisible(false);

        bar3.setMinimum(0);
        bar3.setMaximum(sub_kapasite);//barın sınırı 
        bar3.setStringPainted(true);
        bar3.setVisible(false);

        bar4.setMinimum(0);
        bar4.setMaximum(sub_kapasite);//barın sınırı 
        bar4.setStringPainted(true);
        bar4.setVisible(false);

        bar5.setMinimum(0);
        bar5.setMaximum(sub_kapasite);//barın sınırı 
        bar5.setStringPainted(true);
        bar5.setVisible(false);

        bar6.setMinimum(0);
        bar6.setMaximum(sub_kapasite);//barın sınırı 
        bar6.setStringPainted(true);
        bar6.setVisible(false);

        bar7.setMinimum(0);
        bar7.setMaximum(sub_kapasite);//barın sınırı 
        bar7.setStringPainted(true);
        bar7.setVisible(false);

        bar8.setMinimum(0);
        bar8.setMaximum(sub_kapasite);//barın sınırı 
        bar8.setStringPainted(true);
        bar8.setVisible(false);

        bar9.setMinimum(0);
        bar9.setMaximum(sub_kapasite);//barın sınırı 
        bar9.setStringPainted(true);
        bar9.setVisible(false);

        bar10.setMinimum(0);
        bar10.setMaximum(sub_kapasite);//barın sınırı 
        bar10.setStringPainted(true);
        bar10.setVisible(false);

        bar11.setMinimum(0);
        bar11.setMaximum(sub_kapasite);//barın sınırı 
        bar11.setStringPainted(true);
        bar11.setVisible(false);

        bar12.setMinimum(0);
        bar12.setMaximum(sub_kapasite);//barın sınırı 
        bar12.setStringPainted(true);
        bar12.setVisible(false);

        bar13.setMinimum(0);
        bar13.setMaximum(sub_kapasite);//barın sınırı 
        bar13.setStringPainted(true);
        bar13.setVisible(false);

        bar14.setMinimum(0);
        bar14.setMaximum(sub_kapasite);//barın sınırı 
        bar14.setStringPainted(true);
        bar14.setVisible(false);

        bar15.setMinimum(0);
        bar15.setMaximum(sub_kapasite);//barın sınırı 
        bar15.setStringPainted(true);
        bar15.setVisible(false);

        bar16.setMinimum(0);
        bar16.setMaximum(sub_kapasite);//barın sınırı 
        bar16.setStringPainted(true);
        bar16.setVisible(false);

        bar17.setMinimum(0);
        bar17.setMaximum(sub_kapasite);//barın sınırı 
        bar17.setStringPainted(true);
        bar17.setVisible(false);

        bar18.setMinimum(0);
        bar18.setMaximum(sub_kapasite);//barın sınırı 
        bar18.setStringPainted(true);
        bar18.setVisible(false);

        bar19.setMinimum(0);
        bar19.setMaximum(sub_kapasite);//barın sınırı 
        bar19.setStringPainted(true);
        bar19.setVisible(false);

        bar20.setMinimum(0);
        bar20.setMaximum(sub_kapasite);//barın sınırı 
        bar20.setStringPainted(true);
        bar20.setVisible(false);

        bar21.setMinimum(0);
        bar21.setMaximum(sub_kapasite);//barın sınırı 
        bar21.setStringPainted(true);
        bar21.setVisible(false);

        for (int i = 1; i < alt.size(); i++) {
            if (i == 1) {
                bar2.setValue(alt.get(i).isteksub);//barda gözüken sayı arraylistime göre hepsi için farklı bir olay
                bar2.setVisible(true);
            }
            if (i == 2) {
                bar3.setValue(alt.get(i).isteksub);//barda gözüken sayı arraylistime göre hepsi için farklı bir olay
                bar3.setVisible(true);
            }
            if (i == 3) {
                bar4.setValue(alt.get(i).isteksub);//barda gözüken sayı arraylistime göre hepsi için farklı bir olay
                bar4.setVisible(true);
            }
            if (i == 4) {
                bar5.setValue(alt.get(i).isteksub);//barda gözüken sayı arraylistime göre hepsi için farklı bir olay
                bar5.setVisible(true);
            }
            if (i == 5) {
                bar6.setValue(alt.get(i).isteksub);//barda gözüken sayı arraylistime göre hepsi için farklı bir olay
                bar6.setVisible(true);
            }
            if (i == 6) {
                bar7.setValue(alt.get(i).isteksub);//barda gözüken sayı arraylistime göre hepsi için farklı bir olay
                bar7.setVisible(true);
            }
            if (i == 7) {
                bar8.setValue(alt.get(i).isteksub);//barda gözüken sayı arraylistime göre hepsi için farklı bir olay
                bar8.setVisible(true);
            }
            if (i == 8) {
                bar9.setValue(alt.get(i).isteksub);//barda gözüken sayı arraylistime göre hepsi için farklı bir olay
                bar9.setVisible(true);
            }
            if (i == 9) {
                bar10.setValue(alt.get(i).isteksub);//barda gözüken sayı arraylistime göre hepsi için farklı bir olay
                bar10.setVisible(true);
            }
            if (i == 10) {
                bar11.setValue(alt.get(i).isteksub);//barda gözüken sayı arraylistime göre hepsi için farklı bir olay
                bar11.setVisible(true);
            }
            if (i == 11) {
                bar12.setValue(alt.get(i).isteksub);//barda gözüken sayı arraylistime göre hepsi için farklı bir olay
                bar12.setVisible(true);
            }
            if (i == 12) {
                bar13.setValue(alt.get(i).isteksub);//barda gözüken sayı arraylistime göre hepsi için farklı bir olay
                bar13.setVisible(true);
            }
            if (i == 13) {
                bar14.setValue(alt.get(i).isteksub);//barda gözüken sayı arraylistime göre hepsi için farklı bir olay
                bar14.setVisible(true);
            }
            if (i == 14) {
                bar15.setValue(alt.get(i).isteksub);//barda gözüken sayı arraylistime göre hepsi için farklı bir olay
                bar15.setVisible(true);
            }
            if (i == 15) {
                bar16.setValue(alt.get(i).isteksub);//barda gözüken sayı arraylistime göre hepsi için farklı bir olay
                bar16.setVisible(true);
            }
            if (i == 16) {
                bar17.setValue(alt.get(i).isteksub);//barda gözüken sayı arraylistime göre hepsi için farklı bir olay
                bar17.setVisible(true);
            }
            if (i == 17) {
                bar18.setValue(alt.get(i).isteksub);//barda gözüken sayı arraylistime göre hepsi için farklı bir olay
                bar18.setVisible(true);
            }
            if (i == 18) {
                bar19.setValue(alt.get(i).isteksub);//barda gözüken sayı arraylistime göre hepsi için farklı bir olay
                bar19.setVisible(true);
            }
            if (i == 19) {
                bar20.setValue(alt.get(i).isteksub);//barda gözüken sayı arraylistime göre hepsi için farklı bir olay
                bar20.setVisible(true);
            }
            if (i == 20) {
                bar21.setValue(alt.get(i).isteksub);//barda gözüken sayı arraylistime göre hepsi için farklı bir olay
                bar21.setVisible(true);
            }

        }
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
