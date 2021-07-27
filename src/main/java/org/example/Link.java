package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Link {
    String theLink;

    public String getLink(String profName){
        try {
            Document doc = Jsoup.connect("https://www.google.com.au/search?q=UCFratemyprofessor " + profName).get();
            Elements links = doc.getElementsByClass("g");
            Element firstLink = links.first();
            theLink = firstLink.getElementsByTag("a").first().attr("href");
            return firstLink.getElementsByTag("a").first().attr("href");
        }catch(java.io.IOException ex){
            System.out.println("\nAn error has occurred. Make sure you type an accurate professor name.\n");
        }
        return "";
    }

    public String getRating(URL url){
        try {
            URLConnection connection = url.openConnection();
            InputStream is = connection.getInputStream();
            Scanner scan = new Scanner(new InputStreamReader(is));
            String string = "";
            while (!(string.contains("RatingValue__Numerator-qw8sqy-2 liyUjw"))) {
                string = scan.nextLine();
            }
            char[] array = string.toCharArray();
            int i = 0;
            while (!(array[i] == 'w' && array[i - 1] == 'j')) {
                i++;
            }
            String flag = (array[i + 4] == '.') ? "" + array[i + 4] + "" + array[i + 5] : "";
            return "This professor's rating is " + array[i + 3] + flag + "/5";
        }catch(java.io.IOException ex){
            System.out.println("\nAn error has occurred. Make sure you type an accurate professor name.\n");
        }
        return "";
    }
}
