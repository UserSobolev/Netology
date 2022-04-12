import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String fileNameJson = "new_data.json";
        String strJson = readString(fileNameJson);
        List<Employee> list = jsonToList(strJson);
        list.forEach(System.out::println);
    }

    public static String readString(String jsonFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(jsonFile))) {
            //чтение построчно
            String s;
            StringBuilder m = new StringBuilder();
            while ((s = br.readLine()) != null) {
                m.append(s);
            }
            return m.toString();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public static List<Employee> jsonToList(String strJson) {
        List<Employee> listEmployee = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(strJson);
            JSONArray jsonArray = (JSONArray) obj;
            System.out.println(jsonArray);

            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();

            for (Object jsonObject : jsonArray) {
                Employee employee = gson.fromJson(jsonObject.toString(), Employee.class);
                listEmployee.add(employee);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return listEmployee;
    }
}
