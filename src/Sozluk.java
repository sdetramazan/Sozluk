import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Sozluk {
    public static void main(String[] args) {

        // Canlı Sözlük yapılmak isteniyor.
        // Kullanıcıya aşağıdaki gibi bir menü çıkarınız.
        // 1- Ekleme (Bu secenekte kelimenin kendisi alınız ve manasını alınız)
        // 2- Düzeltme (Bu secenkte kullanıcının kelimenin manasını düzelttiriniz.)
        // 3- Listeleme
        // 4- Arama (Bu secekte verilen bir kelimeyle başlayan tüm kelimelerin manaları)
        // 5- Silme
        // 6- Çıkış
        System.out.println("Hoş Geldiniz.");
        System.out.println("Bu sözlükte yapabilecekliriniz:");
        System.out.println("1 - Ekleme\n2 - Düzeltme\n3 - Listeleme\n4 - Arama\n5 - Silme\n6 - Çıkış\n");


        Scanner input = new Scanner(System.in);

        Map<String, String> dictionary = new LinkedHashMap<>();
        String duration = "";

        do {

            System.out.print("Ne yapmak istiyorsunuz(1/6): ");
            int vote = input.nextInt();

            while (vote < 1 || vote > 6) {

                System.out.print("Lütfen(1/6) arası bir değer seçiniz : ");
                vote = input.nextInt();

            }

            input.nextLine();
            switch (vote) {


                case 1:
                    System.out.print("Kelime giriniz: ");
                    String word = input.nextLine();
                    System.out.print("Anlamını giriniz: ");
                    String meaning = input.nextLine();
                    dictionary.put(word, meaning);
                    System.out.println();
                    break;
                case 2:
                    System.out.print("Anlamını düzeltmek istediğiniz kelimeyi giriniz:");
                    word = input.nextLine();
                    System.out.print("yeni anlam giriniz:");
                    meaning = input.nextLine();

                    if (dictionary.containsKey(word)) {
                        dictionary.remove(word);
                        dictionary.put(word, meaning);
                        System.out.println();
                    }
                    break;
                case 3:
                    if (dictionary.isEmpty()) {
                        System.out.println("Listelenecek word bulunamadı.");
                    }
                    for (Map.Entry<String, String> words : dictionary.entrySet()) {
                        System.out.println(words.getKey() + " : " + words.getValue());
                    }
                    System.out.println();
                    break;
                case 4:
                    System.out.print("Aranacak Kelimeyi giriniz: ");
                    word = input.nextLine();


                    if (dictionary.containsKey(word)) {
                        System.out.println(word + " kelimesinin anlamı : " + dictionary.get(word));
                    } else {
                        System.out.println("aradığınız word bulunamadı");
                    }
                    System.out.println();
                    break;
                case 5:
                    System.out.print("Silinecek kelimeyi giriniz: ");
                    word = input.nextLine();
                    if (dictionary.containsKey(word)) {
                        dictionary.remove(word);
                        System.out.println(word + " sözlükten silindi.");
                    } else System.out.println("Silinecek word bulunamadı.");
                    System.out.println();
                    break;
                case 6:
                    System.out.print("çıkmak istediğinizden emin misiniz(E/H): ");
                    String duration1 = input.next();
                    if (duration1.equalsIgnoreCase("e")){
                        System.out.println("Hoşçakalın...");
                        return;}

                    break;
            }

            System.out.print("Devam etmek istiyor musunuz(E/H): ");
            duration = input.next();


        } while (duration.equalsIgnoreCase("e"));


    }
    }

