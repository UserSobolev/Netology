import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.List;

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
        //Создаем объект запросса
        HttpGet request = new HttpGet("https://raw.githubusercontent.com/netology-code/" +
                "jd-homeworks/master/http/task1/cats");
        //Отправляем запрос
        CloseableHttpResponse response = httpClient.execute(request);

        //Создаем json mapper
        ObjectMapper mapper = new ObjectMapper();

        //Преобразовываем json в java объект
        List<Cat> cats = mapper.readValue(
                response.getEntity().getContent(), new TypeReference<List<Cat>>() {
                });

        //cats.forEach(System.out::println);
        cats.stream()
                .filter(value -> value.getUpvotes() != null)
                .forEach(System.out::println);
    }
}
