import java.io.*;
import java.util.LinkedList;

public class FileToTail {
    BufferedReader br;

    public FileToTail(String filePath) throws FileNotFoundException {
        this.br = new BufferedReader(new FileReader(filePath));
    }

    public String getLine() throws IOException {
        try {
            return br.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    public void tail(int capacity) throws IOException {
        LinkedList<String> list = new LinkedList<String>();

        for (int i = 0; i < capacity; i++) {
            list.add(getLine());
        }

        while (true) {
            String line = getLine();
            if (line != null) {
                list.remove();
                list.add(getLine());
            } else {
                break;
            }
        }
        System.out.println(list.toString());
    }
}
