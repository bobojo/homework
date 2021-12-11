package jdbc_day;

import java.sql.*;
import jdbc_day.Student;
import java.util.*;

public class demo4 {
    public static void main(String[] args) {
        List<Student> list=new demo4().findAll();
        System.out.println(list);
        //System.out.println(list.size());
    }
    public List<Student> findAll(){
        ResultSet rs=null;
        Statement stmt=null;
        Connection conn=null;
        List<Student> list=null;
        try {
            //1.ע������(����try catch �����Զ����쳣��
            Class.forName("com.mysql.jdbc.Driver");
            //2.����sql
            String sql = "select * from student where SNO = 's003'";
            //3.��ȡConnection����
            conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_day?"
            		+ "useUnicode=true&characterEncoding=UTF8","root","0000");
            //4.��ȡִ��sql�Ķ���
            stmt = conn.createStatement();
            //5.ִ��sql
            rs=stmt.executeQuery(sql);
            //6.������
            //���α������ƶ�һλ
            Student stu = null;
            list=new ArrayList<Student>();
            System.out.println("��4��Ч��");
            System.out.println("-------------------------");
            while(rs.next()) {
            	String sno = rs.getString("SNO");
            	String name = rs.getString("Name");
            	int age = rs.getInt("Age");
            	String college = rs.getString("College");
            	
            	stu = new Student();
            	stu.setSNO(sno);
            	stu.setName(name);
            	stu.setAge(age);
            	stu.setCollege(college);
            	
                //װ�ؼ���
                list.add(stu);
            	
            	//System.out.println(sno + ", " + name + ", " + age + ", " + college);
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
        return list;
    }
}
