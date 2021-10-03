import java.io.File;

public class Lab5_ex4_2 {
    private static final String PATH = "C:\\Users\\Анастасия\\IdeaProjects\\first_java\\src\\Lab5_ex4_1.java";
    public static void main(String[] args) {
        if (checkPath(PATH)) {
            System.out.println(PATH + " is a " + (isFile(PATH) ? "file" : "directory"));
        } else {
            System.out.println("Error: file doesn't exist!");
        }
    }
    private static boolean checkPath(String path) {
        File file = new File(path);
        return file.exists();
    }
    private static boolean isFile(String path) {
        File file = new File(path);
        return file.isFile();
    }
}
