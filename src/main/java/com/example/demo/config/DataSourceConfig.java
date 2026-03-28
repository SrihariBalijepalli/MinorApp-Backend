package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Value("${url:}")
    private String url;

    @Value("${username:}")
    private String username;

    @Value("${password:}")
    private String password;

    @Bean
    public DataSource dataSource() {
        System.out.println("\n\n====== [ MINOR APP DATASOURCE INITIALIZATION ] ======");
        
        String cleanUrl = url != null ? url.trim().replace("\"", "").replace("'", "") : "";
        
        // Strip out the Aiven 'mysql://' and replace it with 'jdbc:mysql://' robustly
        if (cleanUrl.contains("mysql://") && !cleanUrl.contains("jdbc:mysql://")) {
             // Removes anything before and including mysql://, and also strips out any username:password@ if accidentally included
             cleanUrl = cleanUrl.replaceFirst(".*mysql://([^:]+:[^@]+@)?", "jdbc:mysql://");
             cleanUrl = cleanUrl.replace("ssl-mode=", "sslMode=");
        }

        System.out.println("[INFO] Intercepted URL from Render (length): " + (url != null ? url.length() : "NULL"));
        System.out.println("[INFO] Successfully Re-mapped JDBC URL   : " + cleanUrl);
        System.out.println("[INFO] Username retrieved (length)       : " + (username != null ? username.length() : "NULL"));
        System.out.println("=====================================================\n\n");

        return DataSourceBuilder.create()
                .url(cleanUrl)
                .username(username)
                .password(password)
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .build();
    }
}
