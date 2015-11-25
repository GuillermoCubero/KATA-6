package kata6;

import static java.awt.PageAttributes.MediaType.A;
import java.io.IOException;
import java.util.ArrayList;
import static javax.print.attribute.standard.MediaSize.Engineering.A;
import static javax.print.attribute.standard.MediaSizeName.A;
import static javax.swing.text.html.HTML.Tag.A;

public class KATA6 {

    public static void main(String[] args) throws IOException {
        
        String nameFile = "emails.txt";
        
        ArrayList<Person> mailArray = MailListReader.reader(nameFile);
        
        HistogramBuilder<Person> builder = new HistogramBuilder(mailArray);
        
        Histogram<String> domains = builder.build(new Attribute<Person, String>() {

            @Override
            public String get(Person item) {
                return item.getMail();
            }
        });
        
        Histogram<Character> letters = builder.build(new Attribute<Person, Character>() {

            @Override
            public Character get(Person item) {
                return item.getMail().charAt(0);
            }
        });
        
        new HistogramDisplay(domains, "DOMINIOS").execute();
        new HistogramDisplay(letters, "CARACTER").execute();
        System.out.println("Fin");
    }
    
}
