import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Создаем массив строк с информацией о преднозначении колонок в CSV файле
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        //Определяем имя для считываемого файла
        String fileNameCSV = "data.csv";
        //Получаем список объектов Employee из файла csv
        List<Employee> listFromCsv = parseCSV(columnMapping, fileNameCSV);
        //Преобразуем список сотрудников в строку формата JSON
        String json1 = listToJson(listFromCsv);
        //Записываем строку JSON в файл JSON
        writeString(json1, "data.json");

        //Определяем имя для считываемого файла
        String fileNameXML = "data.xml";
        //Получаем список объектов Employee из файла xml
        List<Employee> listFromXML = parseXML(fileNameXML);
        //Преобразуем список сотрудников в строку формата JSON
        String json2 = listToJson(listFromXML);
        //Записываем строку JSON в файл JSON
        writeString(json2, "data2.json");
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
        return gson.toJson(list, listType);
    }
    //Метод принимает на вход строку формата JSON и пишет ее в файл "data.json"
    public static void writeString(String json, String nameFile) {
        try (FileWriter file = new
                FileWriter(nameFile)) {
            file.write(json);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Метод принимает на вход файл XML и возвращает список объектов Employee
    public static List<Employee> parseXML(String fileName) {
        List<Employee> list = new ArrayList<>();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(fileName));
            NodeList nodeList = doc.getElementsByTagName("employee");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (Node.ELEMENT_NODE == node.getNodeType()) {
                    Element element = (Element) node;
                    list.add(new Employee(Long.parseLong(element.getElementsByTagName("id").item(0).getTextContent()),
                            element.getElementsByTagName("firstName").item(0).getTextContent(),
                            element.getElementsByTagName("lastName").item(0).getTextContent(),
                            element.getElementsByTagName("country").item(0).getTextContent(),
                            Integer.parseInt(element.getElementsByTagName("age").item(0).getTextContent())));
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return list;
    }
}


