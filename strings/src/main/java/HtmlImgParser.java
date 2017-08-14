import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlImgParser {

    public static ArrayList<String> parseFile(String path){

        ArrayList<String> imageLinks = new ArrayList<>();
        StringBuilder fileContent = new StringBuilder();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(path), "windows-1251"))) {
            while (br.ready()){
                fileContent.append((char) br.read());
            }

            Pattern searchPattern = Pattern.compile("((?<=\\s|^)[A-ZА-Я][^.]*?((\\s|\\()[Рр]ис(\\.|ун(ок|ки|ку|ка|ке|кам|ках|ком|ками)))+(\\s\\d|\\d)(.*)?\\.)");
            Matcher searchMatcher = searchPattern.matcher(fileContent);

            while (searchMatcher.find()) {
                imageLinks.add(searchMatcher.group());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return imageLinks;
    }

    public static void main(String[] args) {
        System.out.println(parseFile("strings/src/main/resources/Java.SE.03.Information handling_task_attachment.html").size());
        System.out.println(parseFile("strings/src/main/resources/Java.SE.03.Information handling_task_attachment.html").get(0));
    }

}
