package ua.lviv.iot.lab4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ua.lviv.iot.lab4.view.MyView;

@SpringBootApplication
public class Lab4JdbcWorkWithDataApplication implements CommandLineRunner {

    @Autowired
    public Lab4JdbcWorkWithDataApplication(MyView view) {
        this.view = view;
    }

    public static void main(String[] args) {
        SpringApplication.run(Lab4JdbcWorkWithDataApplication.class, args);
    }

    private final MyView view;

    @Override
    public void run(String... args) throws Exception {
        view.show();
    }
}
