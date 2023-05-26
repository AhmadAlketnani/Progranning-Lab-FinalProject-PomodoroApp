import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
    public static void main(String[] args) {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        String formattedDate = dateFormat.format(currentDate);


        String content = "["+formattedDate+",A select user from user table]";

        try {
            File file = new File("./database.txt");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(content);
        } catch (IOException i) {
            i.printStackTrace();
        }

    }
}
