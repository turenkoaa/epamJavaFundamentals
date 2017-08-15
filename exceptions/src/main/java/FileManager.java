import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileManager {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            StringBuilder path = new StringBuilder(".");
            for (String input = ""; !input.equals("exit"); ) {
                input = getNextLine(scanner, path.toString());
                switch (input) {
                    case "create":
                        createFile(scanner, path.toString());
                        break;
                    case "delete":
                        deleteFile(scanner, path.toString());
                        break;
                    case "append":
                        appendToFile(scanner, path.toString());
                        break;
                    default:
                        if (path.length() > 0)
                            path.append("/");
                        path.append(input);
                }
            }
        }
    }

    private static String getNextLine(Scanner scanner, String path) {
        File currentDir = new File(path);
        String filesAndDirs[] = currentDir.list();
        System.out.println("Полный путь к текущему элементу: " + currentDir.getAbsolutePath());
        if (filesAndDirs != null)
            for (String file : filesAndDirs)
                System.out.println(file);
        return scanner.nextLine();
    }

    private static void createFile(Scanner scanner, String path) {
        String fileName = scanner.nextLine();
        File file = new File(path + "/" + fileName + ".txt");
        try {
            System.out.println(file.createNewFile() ? "Файл создан." : "Файл сществует.");
        } catch (IOException e) {
            System.err.println("Ошибка создания файла " + e.getMessage());
        }

    }

    private static void deleteFile(Scanner scanner, String path) {
        String fileName = scanner.nextLine();
        if (new File(path + "/" + fileName + ".txt").delete())
            System.out.println("Файл удален.");
        else
            System.out.println("Удаление файла не возможно.");
    }

    private static void appendToFile(Scanner scanner, String path) {
        String fileName = scanner.nextLine();
        File file = new File(path + "/" + fileName + ".txt");
        if (!file.exists()) {
            System.out.println("Файл не существует.");
            return;
        }
        String text = scanner.nextLine();
        try (FileWriter fw = new FileWriter(file)) {
            fw.append(text);
            System.out.println("Файл обновлен.");
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл" + e.getMessage());
        }
    }
}