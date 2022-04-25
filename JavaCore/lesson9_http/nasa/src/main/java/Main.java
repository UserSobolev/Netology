import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Создаем вызов к удаленному серверу по HTTP
        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)        // максимальное время ожидание подключения к серверу
                        .setSocketTimeout(30000)        // максимальное время ожидания получения данных
                        .setRedirectsEnabled(false)     // возможность следовать редиректу в ответе
                        .build())
                .build();
        //Создаем объект запросса для дальнейшего создания объекта PictureNasa
        HttpGet request = new HttpGet("https://api.nasa.gov/planetary/" +
                "apod?api_key=9qHbfh4bGFlsRpYedbNgaOslG716fQ2h9KecTqYB");
        //Отправляем запрос
        CloseableHttpResponse response = httpClient.execute(request);

        //Создаем json mapper
        ObjectMapper mapper = new ObjectMapper();

        //Преобразовываем json в java объект
        PictureNasa picturesNasa = mapper.readValue(
                response.getEntity().getContent(), new TypeReference<PictureNasa>() {
                });

        //Получаем URL картинки объекта PictureNasa
        String urlOfPicture = picturesNasa.getUrl();
        System.out.println(urlOfPicture);

        //Получаем имя файла
        String[] temp = urlOfPicture.split("/");
        String nameOfFile = temp[temp.length - 1];
        System.out.println(nameOfFile);

        //Создаем новый объект запросса
        HttpGet requestPicture = new HttpGet(urlOfPicture);

        //Отправляем новый запрос запрос
        CloseableHttpResponse responsePicture = httpClient.execute(requestPicture);

        try {
            //Читаем картику в бефер
            BufferedImage imageBuffer = ImageIO.read(responsePicture.getEntity().getContent());
            //Пишем картинку в файл из буффера
            ImageIO.write(imageBuffer, "jpg", new File(nameOfFile));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
