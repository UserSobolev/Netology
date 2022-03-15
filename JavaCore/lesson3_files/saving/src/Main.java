import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {

    private static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {
        File savegame = new File("savegames");
        savegame.mkdir();

        GameProgress progress1 = new GameProgress(1, 1, 1, 0.99);
        GameProgress progress2 = new GameProgress(2, 2, 3, 0.56);
        GameProgress progress3 = new GameProgress(3, 3, 3, 0.66);

        saveGame("savegames//save1.dat", progress1);
        saveGame("savegames//save2.dat", progress2);
        saveGame("savegames//save3.dat", progress3);

        list.add("savegames//save1.dat");
        list.add("savegames//save2.dat");
        list.add("savegames//save3.dat");

        zipFiles("savegames//zip.zip", list);

        deleteFiles("savegames", "zip.zip");

    }

    public static void saveGame(String link, GameProgress progress) {
        try (FileOutputStream outputStream = new FileOutputStream(link);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
             objectOutputStream.writeObject(progress);
        } catch (IOException e) {
             e.printStackTrace();
        }
    }

    public static void zipFiles(String link, ArrayList<String> list) {
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(link))) {
            for (String str : list) {
                try (FileInputStream inputStream = new FileInputStream(str)) {
                    ZipEntry entry = new ZipEntry("packed" + str);
                    zipOutputStream.putNextEntry(entry);
                    byte[] buffer = new byte[inputStream.available()];
                    inputStream.read(buffer);
                    zipOutputStream.write(buffer);
                    zipOutputStream.closeEntry();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteFiles(String dir, String zip) {
        File directory = new File(dir);
        for (File item : directory.listFiles()) {
            if (!zip.equals(item.getName())) {
                if (item.delete()) {
                    System.out.println("Успешно удален файл: " + item);
                }
            }
        }
    }
}
