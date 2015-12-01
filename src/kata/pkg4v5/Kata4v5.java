package kata.pkg4v5;

import java.io.IOException;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class Kata4v5 {

    public static void main(String[] args) throws FileNotFoundException,IOException {
        String pathname = "C:\\Users\\usuario\\Desktop\\mail.txt";
        ArrayList <String> mailList = MailReader.read(pathname);
        Histogram<String> histogram = MailHistogramBuilder.build(mailList);
        HistogramDisplay histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();
    }
}