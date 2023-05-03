import java.io.File;
import java.util.Scanner;

public class Main {
    public static final long GB = 1073741824;
    public static final int MB = 1048576;
    public static final int KB = 1024;
    public static void main(String[] args) {

        while (true) {
            System.out.println("Введите путь к папке или файлу: ");
            String path = new Scanner(System.in).nextLine();
            if (path.equals("")) {
                System.out.println("Введена пустая строка, закругляемся...");
                break;
            }
            long size = getFolderSize(new File(path));
            System.out.println("Размер файла: " + getHumanReadableSize(size));
            System.out.println("Размер в байтах: " + size);
        }
    }
    static long getFolderSize(File folder) {
        if (folder.isFile()) {
            return folder.length();
        }
        File[] files = folder.listFiles();
        long length = 0;
        assert files != null;
        for (File file : files) {
            length += getFolderSize(file);
        }
        return length;
    }
    static String getHumanReadableSize(long size) {
        if (size > GB) {
            return String.format("%.2f Gb", (double) size / GB);
        }
        if (size > MB) {
            return String.format("%.2f Mb", (double) size / MB);
        }
        if (size > KB) {
            return String.format("%.2f Kb", (double) size / KB);
        }
        return size + " b";
    }
}