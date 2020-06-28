package asseco.db;

import java.sql.*;

public class DataBaseHandler {

    Connection con;
    private String url;
    private String user;
    private String password;

    public DataBaseHandler(String url, String user, String password) throws Exception{
        DriverManager.registerDriver (new oracle.jdbc.OracleDriver());
        setUrl(url);
        setUser(user);
        setPassword(password);
    }

    public Statement getConnection() throws Exception {
        con=DriverManager.getConnection(getUrl(),getUser(),getPassword());
        Statement stmt=con.createStatement();
        return stmt;
    }

    public void DisConnectDB() throws Exception{
        con.close();
    }

    private String getUrl() {
        return url;
    }

    private void setUrl(String url) {
        this.url = url;
    }

    private  String getUser() {
        return user;
    }

    private void setUser(String user) {
        this.user = user;
    }

    private  String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}