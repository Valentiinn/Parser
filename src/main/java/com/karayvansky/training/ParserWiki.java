package com.karayvansky.training;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class ParserWiki {
    public static void main(String[] args) throws IOException {
        Document doc;
        String title = null;
        try {
            doc = Jsoup.connect("https://ru.wikipedia.org/w/api.php?action=query&titles=%D0%93%D0%BE%D1%80%D0%BE%D0%B4%D0%B0_%D0%A3%D0%BA%D1%80%D0%B0%D0%B8%D0%BD%D1%8B&prop=revisions&rvprop=content&format=xmlfm").get();
            title = doc.title();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // System.out.println("Jsoup Can read HTML page from URL, title : " + title);

        Document doc2 = null;
        Element text = null;
        try {
            doc2 = Jsoup.connect("https://ru.wikipedia.org/w/api.php?action=query&titles=%D0%93%D0%BE%D1%80%D0%BE%D0%B4%D0%B0_%D0%A3%D0%BA%D1%80%D0%B0%D0%B8%D0%BD%D1%8B&prop=revisions&rvprop=content&format=xmlfm").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        text = doc2.body();
        String text2 = text.toString();
//        Map<String, Integer> result = new HashMap<String, Integer>();
//        while (text2 != null) {
//            String[] parts = text2.split(" ");
//            for (String word : parts) {
//                if (word.length() > 3) {
//                    // word = word.replace('.', ' ');
//                    //word = word.replaceAll("[!,-?]", "");
//                    word = word.replaceAll("[^^а-яА-я]", "");
//                    //word = word.replaceAll("[^0-9]", "");
//                    //result.put(word, 1);
//                    result.put(word, 1);
//                    System.out.println(result);
//                }
//            }
//        }
//
//    }
    }
}


