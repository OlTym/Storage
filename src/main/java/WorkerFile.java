import Model.UsersStorage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WorkerFile {

    private String nameFile;

    public WorkerFile(String nameFile) {
        this.nameFile = nameFile;
    }


    public void saveToStorage(UsersStorage userStorage) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String output = gson.toJson(userStorage);

        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(nameFile)))) {
            writer.write(output);
        } catch (IOException e) {
            System.out.println("Input ouput error " + e);
        }

    }

    public String readFromFile() {
        final StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(nameFile))) {
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                sb.append(currentLine);
            }
        } catch (IOException e) {
            System.out.println("Input ouput error " + e);
        }
        return sb.toString();
    }


    public boolean creatDirectory(String path) {

        boolean result = true;
        File file = new File(path);
        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("Directory is created successfully");
            } else {
                result = false;
                System.out.println("Directory creation failed!!!");
            }
        }

        return result;
    }

    public void deleteFile() {

        try {
            Files.deleteIfExists(Paths.get(nameFile));
            System.out.println("Storage is deleted successfully");
        } catch (IOException e) {
            System.out.println("Deleting storage failed!!!" + e);
        }

    }


}
