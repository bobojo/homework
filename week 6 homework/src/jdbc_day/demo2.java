package jdbc_day;

import java.sql.*;

public class demo2 {
	public static void main(String[] args) {
        Statement stmt=null;
        Connection conn=null;
        ResultSet rs=null;
        try {
            //1.注册驱动(这里try catch 不再自动抛异常）
            Class.forName("com.mysql.jdbc.Driver");
            //2.定义sql
            String sql = "select * from student";
            //3.读取Connection对象
            conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_day?"
            		+ "useUnicode=true&characterEncoding=UTF8","root","0000");
            //4.获取执行sql的对象
            stmt = conn.createStatement();
            //5.执行sql
            rs=stmt.executeQuery(sql);
            //6.处理结果
            //让游标向下移动一位
            System.out.println("第2题效果");
            System.out.println("-------------------------");
            while(rs.next()) {
            	String sno = rs.getString("SNO");
            	String name = rs.getString("Name");
            	int age = rs.getInt("Age");
            	String college = rs.getString("College");
            	System.out.println(sno + ", " + name + ", " + age + ", " + college);
            }
        } catch (ClassNotFoundException e) {
           e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //7.释放资源，避免空指针异常
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }        	
            if(stmt!=null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
	}
}
