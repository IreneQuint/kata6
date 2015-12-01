package kata.pkg4v5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MailReader {
    
    public static ArrayList <Person> read() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException{
        ArrayList <Person> people = new ArrayList<>();
        Class.forName("org.sqlite.JDBC");
        Connection cn = DriverManager.getConnection("jdbc:sqlite:KATA.sDB");
        java.sql.Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM PEOPLE");
        
        while (rs.next ()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String mail = rs.getString("mail");
            Float peso = rs.getFloat("peso");
            String genero = rs.getString("genero");
            
            people.add(new Person(id,name,mail,peso,genero));
        }
        
        rs.close();
        st.close();
        cn.close();
        
        return people;
    }
}
