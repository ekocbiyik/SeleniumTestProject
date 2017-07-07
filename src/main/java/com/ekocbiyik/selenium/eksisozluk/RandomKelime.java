package com.ekocbiyik.selenium.eksisozluk;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by enbiya on 06.07.2017.
 */
public class RandomKelime {

    private static List<String> words = new ArrayList<String>();
    private static List<String> usedWords = new ArrayList<String>();
    private static int index = 0;


    public static String getWord() {


        words.add("kolektif bir yaşam tarzı benimseyenler için olmayabilir. ");
        words.add("kadınlar ailesine aşırı bağımlı olmaktandır");
        words.add("ben olduğunu düşünüyorum.");
        words.add("(bkz: ölümden sonra hayat var mı)");
        words.add("hayatı bilmem ama rahat olduğu kesin.");
        words.add("büyük cesaret valla. taktir ediyorum.");
        words.add(" her şey birlikte yapılır,özgürlük kavramının esamesi okunmaz");
        words.add("bu adam gidecekse gitsin");
        words.add("sanırım yıllık 5m eur gibi bir maaş alıyor.");
        words.add("teröristlik yapıyorsunuz, yapmayın.");
        words.add("olsa da girsem dediğimdir. gençliğin kıymetini bilin.");
        words.add("diktiğin kahramanlık kostümlerine girememendir");
        words.add("sözlük kızlarının laneti üzerinize olsun.");
        words.add("piyasanın saçma bir şekilde karışmasına sebep olacak durum. ");
        words.add("bunları yapan vahşi yaşam formları umarım en kısa sürede ölür ya da öldürülür.");
        words.add("ekşi sözlük avrupa'nın tam tersi..");
        words.add("küçük bir hesapla farkettiğim durum.");
        words.add("ne kadar dil döktümse de ikna edemedim. bir de utanmadan, çocuk kandırır gibi, afilli afişler yapmıyorlar mı deliriyorum.");
        words.add("bundan fazlasını her gün gördüğümüz için bu başlık en fazla 10 entry alır");
        words.add("saçmalığın daniskasıdır.");
        words.add("akp hükümetini günahım kadar sevmem");
        words.add("yeni tesis");
        words.add("öyle hayat mı olur lan?");
        words.add("en fazla 1 sene yaşayabilirsin");
        words.add("son dönemlerde gündemi belirleme , haber ajanslarına kaynak olma ve algı oluşturmada etkin olan internet ortamıdır.");
        words.add("aklım hafsalam almıyor");
        words.add("tırmanan gerilim , oluşan antipati ve siyasi problemi avantaja çevirmek için yakında gerçek sorumlular tarafından dillendirilmeye başlanacak cümledir.");
        words.add("fetö yapmıştır.");
        words.add("haber sitelerinde denk geldiğim bir iddia. ");
        words.add("en önemlisi öncelikli olarak durumu kabullenmek.");
        words.add("bu ne yaman çelişki ?");
        words.add("bilinçsizce de olsa ironinin kralını yapmış lan ahaha");
        words.add("kadıköydeyim, yardım edebilirim.");
        words.add("takıntısı olmayan adama etki etmez belki.");
        words.add("akti zamanında 200-250 bilgisayarlı internet cafelerde... hey gidi günler.");
        words.add("olsa fena olmazdı diyecek insanlar da vardır sanırım?");
        words.add("şuan anlam verememekteyim.");
        words.add("olmadığını düşündüğüm an. ");
        words.add("kapıya mal dedektörü konmadığı birkaç entry'den anlaşılabilecek zirve.");
        words.add("hic eksik ettirmez canim benim.");
        words.add("hanim abla sayesinde pek bi enteresan sekilde tanistigim parlak suser");
        words.add("mülksüzler falan fırlatırdım. halkımız bilim kurgudan ve sistem eleştiriden habersiz.");
        words.add("başka yerde olsa kimse devlet kutsal mı bilmem ne mi diyor muymuş... ");
        words.add("iktidarın hak ihlallerine, temel insan haklarını unutarak, türkiye’nin altına imza attığı sorun mu?");
        words.add("hatırlatmıştır bkz: (habire götten zarto)");
        words.add("ortadoğudaki pastadan büyük pay almamıza neden olacak gibi.");
        words.add("tek bir konuda bile onlarca kategoriye ulaşmış durumdayız. ");
        words.add("adamsınız lan!");
        words.add("soğumaya birakmalisiniz.");
        words.add("arz-talep meselesidir bu.");
        words.add("sagda solda bazi yorumlar okuyorum, simdi de bu aciklamayi gorunce hala ne kadar mal bir millet oldugumuzu gordum.");
        words.add("arabası olsa içinde check-in yapacak yazarların beğenmediği erkek.");
        words.add("ap türkiye raportörü hollandalı parlamenter kati piri tarafından kaleme alınan karar tasarısı .");
        words.add("yok artık daha neler.");
        words.add("ehonomi çooh eyi.");
        words.add("zeka seviyor kadinlar. evet dogru. ama zeka, kapici cafer'de degil, okulun cool cocugu okan'da olursa seviyorlar.");
        words.add("yeni Türkiye anasını satayım..");
        words.add("ne bakıyorsunuz? ");
        words.add("sinema algısı var");
        words.add("tanıdık başlık..");
        words.add("boykot ediyorum.");
        words.add("güzel olurdu dediğim başlık.");
        words.add("adamsınız lan.");
        words.add("anlaşıldı..");
        words.add("sadece belli prensipleri olan birinin yapacağı önemsiz iş, takmayın.");

        if (usedWords.size() == words.size()) {
            usedWords.clear();
            index = 0;
            System.out.println("usedWords temizlendi");
        }

        String word = words.get(index);
        System.out.println("index: " + index + "getWord: " + word);
        usedWords.add(word);
        index++;

        return word;

    }

}
