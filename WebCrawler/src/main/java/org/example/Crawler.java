package org.example;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;

public class Crawler {
    private static Connection connection = null;
    private HashSet<String> urlSet;
    private int MAX_DEPTH = 2;

    public Crawler() {
        // Initialize HashSet
        urlSet = new HashSet<String>();
        connection = org.example.DatabaseConnection.getConnection();
    }

    public static void main(String[] args) {
        Crawler crawler = new Crawler();
        crawler.getPageTextAndLinks("https://www.javatpoint.com", 0);
    }

    // Recursive crawler function
    public void getPageTextAndLinks(String url, int depth) {
        if (urlSet.contains(url))
            return;

        if (depth >= MAX_DEPTH)
            return;

        urlSet.add(url);

        depth++;
        try {
            // Connect to the web page
            Document document = Jsoup.connect(url).timeout(5000).get();
            String title = document.title();
            System.out.println(title);
            String text = document.text().length() < 500 ? document.text() : document.text().substring(0, 499);
            String link = url;
            System.out.println(url);

            // Save data to database
            PreparedStatement preparedStatement = connection.prepareStatement("Insert into pages values(?,?,?);");
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, link);
            preparedStatement.setString(3, text);
            preparedStatement.executeUpdate();

            // Recursively calling this method to available link on page
            Elements availbleLinkOnPage = document.select("a[href]");
            for (Element element : availbleLinkOnPage) {
                getPageTextAndLinks(element.attr("abs:href"), depth);
            }
        } catch (IOException | SQLException ioException) {
            ioException.printStackTrace();
        }
    }
}