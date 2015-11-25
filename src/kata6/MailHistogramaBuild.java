package kata6;

import java.util.ArrayList;

public class MailHistogramaBuild {

    public static Histogram <String> build (ArrayList <String> mailList){
        Histogram<String> histogram = new Histogram<>();
        for (String mail : mailList) {
            histogram.increment(new Mail(mail).getDominio());
        }
        return histogram;
    }
}
