package jdbc_day;

import java.sql.*;

public class demo5 {
	public static void main(String[] args) {
        Statement stmt=null;
        Connection conn=null;
        ResultSet rs=null;
        try {
            //1.ע������(����try catch �����Զ����쳣��
            Class.forName("com.mysql.jdbc.Driver");
            //2.����sql
            String sql1 = "update student set College = 'ͨ��ѧԺ' where SNO = 's001'";
            String sql2 = "select * from student";
            //3.��ȡConnection����
            conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_day?"
            		+ "useUnicode=true&characterEncoding=UTF8","root","0000");
            //4.��ȡִ��sql�Ķ���
            stmt = conn.createStatement();
            //5.ִ��sql
            int count = stmt.executeUpdate(sql1);
            System.out.println(count);
            if (count>0){
                System.out.println("�޸ĳɹ�");
            }else{
                System.out.println("�޸�ʧ��");
            }
            rs=stmt.executeQuery(sql2);
            //6.������
            //���α������ƶ�һλ
            System.out.println("��5��Ч��");
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
            //7.�ͷ���Դ�������ָ���쳣
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
