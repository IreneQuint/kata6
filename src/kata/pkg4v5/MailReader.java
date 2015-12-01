package kata.pkg4v5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MailReader {
    
    public static ArrayList <Person> read(String name) throws FileNotFoundException, IOException{
        ArrayList <Person> people = new ArrayList<>();
        BufferedReader reader;
        reader = new BufferedReader(new FileReader (new File(name)));
        String mail;
        int id = 0;
        while((mail = reader.readLine()) != null){
            if(!mail.contains("@")) continue;
            people.add(new Person (id++,mail));
        }
        reader.close();
        return people;
    }
}
