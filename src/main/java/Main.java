import java.io.File;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        while (true) {
            System.out.println("Введите путь к папке или файлу: ");
            String path = new Scanner(System.in).nextLine();
            if (path.equals("")) {
                System.out.println("Закругляемся...");
                break;
            }
        }
    }
    static long getFolderSize(File file) {
        if (file.isFile()) {
            return file.length();
        } else if (file.isDirectory()) {
            List<File> files = List.of(file);
            return files.stream()
                    .mapToLong(Main::getFolderSize)
                    .sum();
        }
        return -1;
    }
}