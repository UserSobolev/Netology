import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonToken;
import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Создаем массив строк с информацией о преднозначении колонок в CSV файле
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        //Определяем имя для считываемого файла
        String fileName = "data.csv";
        //Получаем список сотрудников из файла csv
        List<Employee> list = parseCSV(columnMapping, fileName);
        //Преобразуем список сотрудников в строку формата JSON
        String json = listToJson(list);
        //Записываем строку JSON в файл JSON
        writeString(json);
    }
    //Метод принимает на вход массив с преднозначениемколонок в файле CSV + сам файл CSV,
    //парсит файл и создает список объектов Employee
    public static List<Employee> parseCSV(String[] columnMapping, String fileName) {
        List<Employee> list = null;
        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            ColumnPositionMappingStrategy<Employee> strategy =
                    new ColumnPositionMappingStrategy<>();
            strategy.setType(Employee.class);
            strategy.setColumnMapping(columnMapping);
            CsvToBean<Employee> csv = new CsvToBeanBuilder<Employee>(reader)
                    .withMappingStrategy(strategy)
                    .build();
            list = csv.parse();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return list;
    }
    //Метод принимает на вход список сотрудников и преобразует данный список в строку JSON
    public static String listToJson(List<Employee> list) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Type listType = new TypeToken<List<Employee>>() {}.getType();
        String json = gson.toJson(list, listType);
        return json;
    }
    //Метод принимает на вход строку формата JSON и пишет ее в файл "data.json"
    public static void writeString(String json) {
        try (FileWriter file = new
                FileWriter("data.json")) {
            file.write(json);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
