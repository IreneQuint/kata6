package kata.pkg4v5;

import java.io.IOException;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.sql.SQLException;

public class Kata4v5 {

    public static void main(String[] args) throws FileNotFoundException,IOException, ClassNotFoundException, SQLException {
        ArrayList <Person> people = MailReader.read();
        HistogramBuilder builder = new HistogramBuilder<> (people);
        
        Histogram<String> domains = builder.build(new Attribute <Person, String>(){
            @Override
            public String get (Person person){
                return person.getMail().split("@")[1];
            }
        });
        
        HistogramDisplay histoDisplay = new HistogramDisplay(domains);
        histoDisplay.execute();
        
        Histogram<Character> letters = builder.build(new Attribute <Person, Character>(){
            @Override
            public Character get (Person person){
                return person.getMail().charAt(0);
            }
        });
        
        HistogramDisplay histoDisplay2 = new HistogramDisplay(letters);
        histoDisplay2.execute();
        
        Histogram<Float> histoPesos = builder.build(new Attribute <Person, Float>(){
            @Override
            public Float get (Person person){
                return person.getPeso();
            }
        });
        
        HistogramDisplay histoDisplay3 = new HistogramDisplay(histoPesos);
        histoDisplay3.execute();
        
        Histogram<String> generos = builder.build(new Attribute <Person, String>(){
            @Override
            public String get (Person person){
                return person.getGenero();
            }
        });
        
        HistogramDisplay histoDisplay4 = new HistogramDisplay(generos);
        histoDisplay4.execute();
    }
}