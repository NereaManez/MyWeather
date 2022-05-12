package model;

import properties.MyConfig;
import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

public class MyDataSource {
    public static DataSource getMyMariaDBDataSource() {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();

        String host = MyConfig.getInstance().getDBHost();
        String port = MyConfig.getInstance().getDBPort();
        String schema = MyConfig.getInstance().getDBSchema();
        String user = MyConfig.getInstance().getUsername();
        String password = MyConfig.getInstance().getPassword();

        // jdbc:mysql://<host>:<port>/<schema>
        mysqlDataSource.setURL("jdbc:mysql://" + host + ":" + port + "/" + schema);
        mysqlDataSource.setUser(user);
        mysqlDataSource.setPassword(password);

        return mysqlDataSource;
    }
}
