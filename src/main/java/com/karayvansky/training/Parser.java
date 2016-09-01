package com.karayvansky.training;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;

public class Parser {
    static int startNum;
    static int stopNum;
    static ArrayList<String> result = new ArrayList<String>(); //массив, для записи результата поиска

    public static void main(String[] args) {
        Document doc2 = null;
        // String text = null;
        try {
            doc2 = Jsoup.connect("https://ru.wikipedia.org/w/api.php?action=query&titles=%D0%93%D0%BE%D1%80%D0%BE%D0%B4%D0%B0_%D0%A3%D0%BA%D1%80%D0%B0%D0%B8%D0%BD%D1%8B&prop=revisions&rvprop=content&format=xmlfm").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String str = doc2.text();
        System.out.println(str.replaceAll("[\\s—*0-9]", ""));

//        for (String result : parser("*Полонное—Хмельницкая область", '*', '—')) {
//            System.out.println(result);
//        }
    }

    static ArrayList<String> parser(String from, char start, char stop) {
        while (!from.equals("")) {
            startNum = from.indexOf(start) + 1;
            stopNum = from.indexOf(stop);
            result.add(from.substring(startNum, stopNum));
            from = from.substring(stopNum + 1);
        }
        return result;
    }
}
