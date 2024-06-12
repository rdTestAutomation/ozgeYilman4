package org.example;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Main {

    // Tekrar eden harf içerip içermediğini kontrol eden fonksiyon
    public static boolean tekrarlayanHarfVarMi(String kelime) {
        Set<Character> harfSeti = new HashSet<>();
        for (char harf : kelime.toCharArray()) {
            if (harfSeti.contains(harf)) {
                return true; // Tekrar eden harf bulundu
            }
            harfSeti.add(harf);
        }
        return false; // Tekrar eden harf yok
    }

    // Kelimelerden rastgele bir metin oluşturan fonksiyon
    public static String rastgeleMetinOlustur(String kelime1, String kelime2) {
        String birlesikKelime = kelime1 + kelime2;
        List<Character> harfler = new ArrayList<>();
        for (char harf : birlesikKelime.toCharArray()) {
            harfler.add(harf);
        }
        StringBuilder yeniMetin = new StringBuilder();
        Random random = new Random();
        while (!harfler.isEmpty()) {
            int index = random.nextInt(harfler.size());
            yeniMetin.append(harfler.remove(index));
        }
        return yeniMetin.toString();
    }

    public static void main(String[] args) {
        // Örnek kelime dizisi
        String[] kelimeDizisi = {"kalem", "elalem", "kelam", "kelime"};

        String kelime1 = null;
        String kelime2 = null;

        // Tekrarlayan harf içeren iki kelimeyi bul
        for (String kelime : kelimeDizisi) {
            if (tekrarlayanHarfVarMi(kelime)) {
                if (kelime1 == null) {
                    kelime1 = kelime;
                } else {
                    kelime2 = kelime;
                    break; // İki kelime bulundu, döngüyü kır
                }
            }
        }

        // Sonuçları yazdır
        if (kelime1 != null && kelime2 != null) {
            System.out.println("Tekrar eden harf içeren 2 kelime: " + kelime1 + ", " + kelime2);
            String yeniMetin = rastgeleMetinOlustur(kelime1, kelime2);
            System.out.println("Oluşturulan metin: " + yeniMetin);
        } else {
            System.out.println("Tekrar eden harf içeren yeterli kelime bulunamadı.");
        }
    }
}
