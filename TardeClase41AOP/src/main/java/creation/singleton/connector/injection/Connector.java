package creation.singleton.connector.injection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
    private Connection conn=null;
    private String driver;
    private String url;
    private String user;
    private String pass;
    public Connector() { }
    public Connector(String driver, String url, String user, String pass) {
        this.driver = driver;
        this.url = url;
        this.user = user;
        this.pass = pass;
    }
    public Connection getConnection(){
        if(conn==null){
            try {
                Class.forName(driver);
                conn=DriverManager.getConnection(url, user, pass);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
}
