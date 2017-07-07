package com.ekocbiyik.selenium;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by enbiya on 20.09.2016.
 */
public class BgaBook {


    public static void main(String[] args) throws IOException {

        String path = "c:\\kitap\\";
        String imagesPath = path + "images\\";

        int pageCount = 307;

        File kitap = new File(path);
        if (!kitap.exists()){
            kitap.mkdir();
        }

        File images = new File(imagesPath);
        if (!images.exists()){
            images.mkdir();
        }

        System.out.println("Dizinler oluşturuldu: "+ imagesPath);

        System.out.println("indirilecek sayfa sayısı: "+ pageCount);
        for (int i = 1; i <= pageCount; i++) {

            String link= "http://image.slidesharecdn.com/ileriseviyeagguvenligilabkitabi-160824181922/" +
                    "95/leri-seviye-a-gvenlii-lab-kitab-"+ i +"-1024.jpg?cb=1472062804";

            URL url = new URL(link);
            URLConnection urlConnection = url.openConnection();
            urlConnection.connect();

            InputStream stream = url.openStream();
            BufferedInputStream in = new BufferedInputStream(stream);
            FileOutputStream out = new FileOutputStream(imagesPath + "sayfa-"+i+".jpg");

            byte [] buffer = new byte[1024];
            int len;

            while ((len = in.read(buffer)) != -1){
                out.write(buffer, 0, len);
            }

            in.close();
            out.close();

            System.out.println(i+".Sayfa indirildi..");

        }

        String htmlPage =
                "<head>\n" +
                    "<script type=\"text/javascript\">\n" +
                        "var newsImageData = [";

        for (int i = 1; i <=pageCount ; i++) {
            htmlPage += "{src: \"images/sayfa-"+ i +".jpg\", data: \"Sayfa "+ i +"\"},\n";
        }

        htmlPage += "];\n" +
                "var currNewsImgIdx = 0;\n" +

                "function UpdateNews () {\n" +
                    "var img = document.getElementById (\"image\");\n" +
                    "img.src = newsImageData[currNewsImgIdx].src;\n" +
                    "var imgContent = document.getElementById (\"imageContent\");\n" +
                    "imgContent.innerHTML = newsImageData[currNewsImgIdx].data;\n" +
                "}\n" +

                "function NextNews () {\n" +
                    "currNewsImgIdx = (currNewsImgIdx + 1) % newsImageData.length;\n" +
                    "UpdateNews ();\n" +
                "}\n" +

                "function PrevNews () {\n" +
                    "currNewsImgIdx = (currNewsImgIdx + newsImageData.length - 1) % newsImageData.length;\n" +
                    "UpdateNews ();\n" +
                "}\n" +

                "function GoToNews (sayfa) {\n" +
                    "currNewsImgIdx = sayfa-1;\n" +
                    "UpdateNews ();\n" +
                "}\n" +

                "function OnDocLoad () {\n" +
                    "UpdateNews ();\n" +
                "}\n" +

                "</script>\n" +
                "</head>\n" +

                "<body onload=\"OnDocLoad ()\">\n" +
                "<table border= \"1px\" align=\"center\" height=\"100%\"> \n" +
                "<tr>  \n" +
                "<td width=\"150px;\">\n" +
                "<div style=\"height:100%; overflow:auto;\">";

        for (int i = 1; i <=pageCount; i++) {
            htmlPage += "<a href=\"#\" onclick=\"GoToNews("+i+")\">Sayfa "+i+"</a></br>";
        }

        htmlPage += "</div>\n" +
                "</td>\n" +
                "<td> \n" +
                "<table>\n" +
                "<tr>\n" +
                "<td><img id=\"image\" class=\"newsimage\" alt=\"search\" height=\"100%\" width=\"100%\"/> </td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td align=\"center\">\n" +
                "<div id=\"imageContent\" class=\"imageContent\"></div> \n" +
                "<a href=\"#\" onclick=\"PrevNews ()\">geri</a>\n" +
                "<a href=\"#\" onclick=\"NextNews ()\">ileri</a> \n" +
                "</td>\n" +
                "</tr> \n" +
                "</table>\n" +
                "</td> \n" +
                "</tr> \n" +
                "</table>\n" +
                "</body>";

        File html = new File(path+"index.html");
        if (!html.exists()){
            html.createNewFile();
        }

        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(html,true)));
        bf.write(htmlPage);

        bf.close();

        System.out.println("Sunum sayfası oluşturuldu: "+html.getPath());

    }

    
}
