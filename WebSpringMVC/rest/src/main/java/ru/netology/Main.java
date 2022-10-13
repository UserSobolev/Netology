package ru.netology;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

import java.io.IOException;
import java.nio.file.Files;

public class Main {
    public static void main(String[] args) throws IOException, LifecycleException {
        //конфигурируем встроенный TomCat
        //объект TomCat
        final var tomcat = new Tomcat();
        //создаем временную папку для TomCat
        final var baseDir = Files.createTempDirectory("tomcat");
        //автоматическое удаление файлов при выходе из приложения
        baseDir.toFile().deleteOnExit();
        //устанавливаем директорию(папку) для TomCat
        tomcat.setBaseDir(baseDir.toAbsolutePath().toString());

        //настраиваем конектор чтобы TomCat понимал к какому порту подлючаться
        final var connector = new Connector();
        //устанавливаем порт для коннектора
        connector.setPort(8080);
        // отдаем коннектор TomCat-у
        tomcat.setConnector(connector);

        //имя хоста
        tomcat.getHost().setAppBase(".");
        //адрес WEB приложения на который он будет отвечать
        tomcat.addWebapp("", ".");

        //запускаем сервер TomCat
        tomcat.start();
        //блокируем программу до тех пор пока сервер работает, чтобы она не вышла
        tomcat.getServer().await();
    }
}
