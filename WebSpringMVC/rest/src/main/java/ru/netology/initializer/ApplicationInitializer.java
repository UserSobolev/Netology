package ru.netology.initializer;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class ApplicationInitializer  implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //DI контейнер
        final var context = new AnnotationConfigWebApplicationContext();
        //сканируем все классы чтобы получить BeanDefinition
        context.scan("ru.netology");
        //ленивый контейнер поэтому обновляем его для того чтобы сразу создались бины
        context.refresh();

        //создаем сервлет
        final var servlet = new DispatcherServlet(context);
        //регестрируем сервлет
        final var registration = servletContext.addServlet("app", servlet);

        //настройка сервлета, по аналогии с настройкой в файле XML
        registration.setLoadOnStartup(1);
        //добавляем мапинг на корень приложения
        registration.addMapping("/");
    }
}

