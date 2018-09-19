import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println(urlToString("http://erdani.com/tdpl/hamlet.txt"));
        String lines = urlToString("http://erdani.com/tdpl/hamlet.txt");
        int count = wordCount(lines);
        System.out.println("The name Hamlet is said " + count + " times!");    }
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */

    public static String urlToString(final String url) {

        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static int wordCount(final String lines) {
        int counter = 0;
        String search = " hamlet";
        for (int i = 0; i < lines.length(); i++) {
            if (lines.toLowerCase().contains(search)) {
                counter++;
            } else {
                return 0;
            }
        }
        return counter;
    }

}
