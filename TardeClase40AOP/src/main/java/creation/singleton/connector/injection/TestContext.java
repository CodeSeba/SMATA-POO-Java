package creation.singleton.connector.injection;

import java.sql.Connection;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestContext {
    public static void main(String[] args) throws Exception {
        ApplicationContext context=null;
        //context=new ClassPathXmlApplicationContext(
        //        "creation/singleton/connector/injection/SpringXMLConfig.xml"
        //);
        
        context=new AnnotationConfigApplicationContext(AppConfig.class);
        
        Connector connector=context.getBean("connector",Connector.class);
        Connection conn=connector.getConnection();
        conn.createStatement().execute("drop database if exists test");
        conn.createStatement().execute("create database test");
        conn.createStatement().execute("use test");
    }
}
