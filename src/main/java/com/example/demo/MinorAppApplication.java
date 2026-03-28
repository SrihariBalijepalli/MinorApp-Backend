package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class MinorAppApplication {

    public static void main(String[] args) {

        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
        dotenv.entries().forEach(e -> System.setProperty(e.getKey(), e.getValue()));

        // Auto-fix Render Aiven URL
        String dbUrl = System.getenv("url");
        if (dbUrl == null) dbUrl = System.getProperty("url");
        if (dbUrl != null && dbUrl.startsWith("mysql://")) {
            dbUrl = dbUrl.replaceFirst("^mysql://([^:]+:[^@]+@)?", "jdbc:mysql://");
            dbUrl = dbUrl.replace("ssl-mode=", "sslMode=");
            System.setProperty("url", dbUrl);
        }

        SpringApplication.run(MinorAppApplication.class, args);
    }

}