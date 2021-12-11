package jdbc_day;

import java.sql.*;

public class demo1 {
	public static void main(String[] args) {
        Statement stmt=null;
        Connection conn=null;
        try {
            //1.注册驱动(这里try catch 不再自动抛异常）
            Class.forName("com.mysql.jdbc.Driver");
            //2.定义sql
            String sql1 ="insert into student values('s001','老大',20,'计算机学院')";
            //String sql2 ="insert into student values('s002','老二',19,'计算机学院')";
            //String sql3 ="insert into student values('s003','老三',18,'计算机学院')";
            //String sql4 ="insert into student values('s004','老四',17,'计算机学院')";
            //3.读取Connection对象
            conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_day?"
            		+ "useUnicode=true&characterEncoding=UTF8","root","0000");
            //4.获取执行sql的对象
            stmt = conn.createStatement();
            //5.执行sql
            int count=stmt.executeUpdate(sql1);//影响的行数
            //6.处理结果
            System.out.println(count);
            if (count>0){
                System.out.println("添加成功");
            }else{
                System.out.println("添加失败");
            }
        } catch (ClassNotFoundException e) {
           e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //7.释放资源，避免空指针异常
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
