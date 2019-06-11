package com.zygstore.utils;

import java.io.IOException;
import java.util.ArrayList;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class ReadKomputronikSite {
    private static final String WEB_STIE = "https://www.komputronik.pl/";
    private static final String TREE_ROOT_HTML_ELEMENT = "ul.menu-tree";
    private ArrayList<String> linesFromFile = new ArrayList<>();
    private Document doc;
    private String title;
    private Element tree;


    public ReadKomputronikSite() throws IOException {
        this.doc = Jsoup.connect(WEB_STIE).get();
        this.title = doc.title();
        this.tree = doc.select(TREE_ROOT_HTML_ELEMENT).first();
        this.linesFromFile = getCSVLinesFromKomputronik(tree);
    }

    private ArrayList<String> getCSVLinesFromKomputronik(Element tree) {
        String id;
        String parentID;


        IdGenerator idGenerator = new IdGenerator();

        for (int i = 0; i < tree.childNodeSize(); i++) {
            String html = tree.childNode(i).toString();
            Document doc = Jsoup.parse(html);
            Element link = doc.select("a").first();

            if (link != null) {
                id = Long.toString(idGenerator.generateNewId());

                parentID = "0";

                String title = link.attr("title").toString();
                String ulr = link.attr("href").toString();
                linesFromFile.add(id + ";" + parentID + ";" + title);
//feeding next menu level
                String parentID2 = id;
                for (int j = 0; j < tree.childNode(i).childNode(3).childNodeSize(); j++) {
                    String html2 = tree.childNode(i).childNode(3).childNode(j).toString();
                    Document doc2 = Jsoup.parse(html2);
                    Element link2 = doc2.select("a").first();

                    if (link2 != null) {
                        id = Long.toString(idGenerator.generateNewId());
                        String titleSecondLink = link2.attr("title").toString();
                        String urlSecondLink = link2.attr("href").toString();
                        linesFromFile.add(id + ";" + parentID2 + ";" + titleSecondLink);

//feeding next menu level
                        String parentID3 = id;
                        for (int x = 0; x < tree.childNode(i).childNode(3).childNode(j).childNode(3).childNodes().size(); x++) {
                            String html3 = tree.childNode(i).childNode(3).childNode(j).childNode(3).childNode(x).toString();
                            Document doc3 = Jsoup.parse(html3);
                            Element link3 = doc3.select("a").first();

                            if (link3 != null) {
                                id = Long.toString(idGenerator.generateNewId());
                                String titleThirdLink = link3.attr("title").toString();
                                String urlThirdLink = link3.attr("href").toString();
                                linesFromFile.add(id + ";" + parentID3 + ";" + titleThirdLink);
                            }

                        }

                    }
                }

            } //link

        }


        return linesFromFile;
    }

    public Document getDoc() {
        return doc;
    }

    public String getTitle() {
        return title;
    }

    public Element getTree() {
        return tree;
    }

    public ArrayList<String> getLinesFromFile() {
        return linesFromFile;
    }


}
