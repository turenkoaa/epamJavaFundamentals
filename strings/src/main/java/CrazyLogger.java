import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CrazyLogger {

    private StringBuilder info;
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY : hh-mm");

    CrazyLogger(){
        StringBuilder info = new StringBuilder();
    }

    synchronized void add(String s) {
        LocalDateTime dateTime = LocalDateTime.now();
        info.append(dateTime.format(formatter))
                .append(" - ")
                .append(s.replaceAll(";", ","))
                .append(";");
    }

    void findInfo(String text) {
        for (String item : info.toString().split(";"))
            if (item.toLowerCase().contains(text.toLowerCase()))
                System.out.println(item);
    }
}
