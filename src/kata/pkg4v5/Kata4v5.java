package kata.pkg4v5;

import java.io.IOException;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class Kata4v5 {

    public static void main(String[] args) throws FileNotFoundException,IOException {
        String pathname = "C:\\Users\\usuario\\Desktop\\mail.txt";
        ArrayList <Person> people = MailReader.read(pathname);
        HistogramBuilder builder = new HistogramBuilder<> (people);
        
        Histogram<String> domains = builder.build(new Attribute <Person, String>(){
            @Override
            public String get (Person person){
                return person.getMail().split("@")[1];
            }
        });
        HistogramDisplay histoDisplay = new HistogramDisplay(domains);
        histoDisplay.execute();
    }
}