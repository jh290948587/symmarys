package base.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Administrator on 2017/5/16.
 */
public class OracleTest {
    public static void main(String[] args) throws Exception {
        //设定数据库驱动，数据库连接地址、端口、名称，用户名，密码
//        String driverName = "oracle.jdbc.driver.OracleDriver";
//        String url = "jdbc:oracle:thin:@192.168.0.7:1521:dna2";  //test为数据库名称，1521为连接数据库的默认端口
//        String user = "tuyianalyze";   //aa为用户名
//        String password = "tuyia123";  //123为密码

        String driverName = "org.postgresql.Driver";
        String url = "jdbc:postgresql://192.168.1.103:5433/databank";  //test为数据库名称，1521为连接数据库的默认端口
        String user = "postgres";   //aa为用户名
        String password = "postgres";  //123为密码
        //数据库连接对象
        Connection conn = null;
        //反射Oracle数据库驱动程序类
        Class.forName(driverName);
        //获取数据库连接
        conn = DriverManager.getConnection(url, user, password);
        String sql = "select * from category";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet =
                preparedStatement.executeQuery();
        while(resultSet.next()){
            Object object = resultSet.getObject(2);
            System.out.println(object);
        }
    }
}
