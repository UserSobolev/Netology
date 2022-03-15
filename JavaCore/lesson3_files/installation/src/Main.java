import javax.imageio.IIOException;
import java.io.*;
import java.time.LocalTime;

public class Main {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        File file = new File("Game");
        file.mkdir();

        File src = new File("Game" + File.separator + "crs");
        makeDirectory(src);
        File res = new File("Game" + File.separator + "res");
        makeDirectory(res);
        File savegames = new File("Game" + File.separator + "savegames");
        makeDirectory(savegames);
        File temp = new File("Game" + File.separator + "temp");
        makeDirectory(temp);
        File main = new File("Game" + File.separator + "crs" + File.separator + "main");
        makeDirectory(main);
        File test = new File("Game" + File.separator + "crs" + File.separator + "test");
        makeDirectory(test);
        File drawables = new File("Game" + File.separator + "res" + File.separator + "drawables");
        makeDirectory(drawables);
        File vectors = new File("Game" + File.separator + "res" + File.separator + "vectors");
        makeDirectory(vectors);
        File icons = new File("Game" + File.separator + "res" + File.separator + "icons");
        makeDirectory(icons);

        File fileMain =  new File("Game" + File.separator + "crs" + File.separator +
                File.separator + "main" + File.separator + "Main.java");
        makeFile(fileMain);
        File fileUtils =  new File("Game" + File.separator + "crs" + File.separator +
                File.separator + "main" + File.separator + "Utils.java");
        makeFile(fileUtils);
        File text =  new File("Game" + File.separator + "temp" + File.separator + "text.txt");
        makeFile(text);

        try (FileWriter writer = new FileWriter("Game\\temp\\text.txt", true)) {
            writer.write(String.valueOf(sb));
            writer.flush();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void makeDirectory(File titleDirectory) {
        if (titleDirectory.exists()) {
            sb.append(titleDirectory.getName() + " - такой каталог уже есть\n");
        } else if (titleDirectory.mkdir()) {
            sb.append(titleDirectory.getName() + " - каталог успешнос создан" + " " + LocalTime.now() + "\n");
        }
    }

    public static void makeFile(File titleFile) {
        try {
            if (titleFile.exists()) {
                sb.append(titleFile.getName() + " - такой файл уже есть\n");
            } else if (titleFile.createNewFile()) {
                sb.append(titleFile.getName() + " - файл успешнос создан" + " " + LocalTime.now() + "\n");
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}


