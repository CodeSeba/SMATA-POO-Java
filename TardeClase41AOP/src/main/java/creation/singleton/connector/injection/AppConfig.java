package creation.singleton.connector.injection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Connector connector(){
        return new Connector("com.mysql.jdbc.Driver","jdbc:mysql://localhost","root","root");
    }
}
