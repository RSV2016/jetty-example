import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Sergey on 13.02.2017.
 */
public class TodoDao {
    private File file = new File("D:\\db.txt");

    public void addNew(String todo) {
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter(file, true));
            printWriter.write(todo + "\n");
            printWriter.close();
        } catch (Exception e) {}
    }

    public List<String> getAll() {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            Scanner scanner = new Scanner(fileInputStream);
            List<String> todoList = new ArrayList<String>();

            while(scanner.hasNextLine()) {
                todoList.add(scanner.nextLine());
            }

            return todoList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteLine(int lineNumber) {
        System.out.println("User wants to delete line with number:" + lineNumber);
    }
}
