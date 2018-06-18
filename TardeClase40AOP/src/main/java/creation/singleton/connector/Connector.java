package creation.singleton.connector;

import java.sql.Connection;
import java.sql.DriverManager;

public final class Connector {
    private static Connection conn=null;
    private Connector(){}
    public synchronized static Connection getConnection(){
        if(conn==null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn=DriverManager.getConnection("jdbc:mysql://localhost", "root", "root");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
}
