package jdbc_day;

import java.sql.*;

public class demo1 {
	public static void main(String[] args) {
        Statement stmt=null;
        Connection conn=null;
        try {
            //1.ע������(����try catch �����Զ����쳣��
            Class.forName("com.mysql.jdbc.Driver");
            //2.����sql
            String sql1 ="insert into student values('s001','�ϴ�',20,'�����ѧԺ')";
            //String sql2 ="insert into student values('s002','�϶�',19,'�����ѧԺ')";
            //String sql3 ="insert into student values('s003','����',18,'�����ѧԺ')";
            //String sql4 ="insert into student values('s004','����',17,'�����ѧԺ')";
            //3.��ȡConnection����
            conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_day?"
            		+ "useUnicode=true&characterEncoding=UTF8","root","0000");
            //4.��ȡִ��sql�Ķ���
            stmt = conn.createStatement();
            //5.ִ��sql
            int count=stmt.executeUpdate(sql1);//Ӱ�������
            //6.������
            System.out.println(count);
            if (count>0){
                System.out.println("��ӳɹ�");
            }else{
                System.out.println("���ʧ��");
            }
        } catch (ClassNotFoundException e) {
           e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //7.�ͷ���Դ�������ָ���쳣
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
