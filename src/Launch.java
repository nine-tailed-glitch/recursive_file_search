import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Launch {

    private static final String ROOT_DIRECTORY = "D:\\";
    private static final String FILE_EXTENSION = ".jpg";

    public static void main(String[] args) {

        ArrayList<File> foundFiles = new ArrayList<>();
        searchFiles(new File(ROOT_DIRECTORY), foundFiles);
        for (File file : foundFiles) {
            System.out.println(file.getAbsolutePath());
        }
        System.out.println("The search is over");
    }

    private static void searchFiles(File directory, List<File> fileAddresses) {
        if (directory.isDirectory()) {
            System.out.println(String.format("directory search: %s", directory.getAbsolutePath()));
            File[] directoryFiles = directory.listFiles();
            if (directoryFiles != null) {
                for (File file : directoryFiles) {
                    if (file.isDirectory()) {
                        searchFiles(file, fileAddresses);
                    } else {
                        if (file.getName().toLowerCase().endsWith(FILE_EXTENSION)) {
                            fileAddresses.add(file);
                        }
                    }
                }
            }
        }
    }
}
