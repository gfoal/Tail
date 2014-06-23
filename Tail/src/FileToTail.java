import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class FileToTail {
    String filePath;
    BufferedReader br;

    public FileToTail(String filePath) {
        this.filePath = filePath;
    }

    public void tail(int capacity) throws IOException {
        br = new BufferedReader(new FileReader(filePath));
        Queue<String> queue = new LinkedList<String>();
        try {
            for (int i = 0; i < capacity; i++) {
                queue.add(br.readLine());
            }

            while (true) {
                String line = br.readLine();
                if (line != null) {
                    queue.remove();
                    queue.add(line);
                } else {
                    break;
                }
            }
            System.out.println(queue.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            br.close();
        }
    }
}
