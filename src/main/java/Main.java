import java.io.File;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static long GB = 1073741824;
    public static int MB = 1048576;
    public static int KB = 1024;
    public static void main(String[] args) {

        while (true) {
            System.out.println("Введите путь к папке или файлу: ");
            String path = new Scanner(System.in).nextLine();
            if (path.equals("")) {
                System.out.println("Закругляемся...");
                break;
            }
            long size = getFolderSize(new File(path));
            System.out.println("Размер файла: " + getHumanReadableSize(size));
            System.out.println("Размер в байтах: " + size);
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
    static String getHumanReadableSize(long size) {
        if (size > GB) {
            return size / GB + " Gb";
        }
        if (size > MB) {
            return size / MB + " Mb";
        }
        if (size > KB) {
            return size / KB + " Kb";
        }
        return size + " b";
    }
}