package com.maven.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.maven.dao.AccountDao;
import com.maven.domain.Account;

public class AccountService {
	private InputStream inputStream; 
	private SqlSession sqlSession; 
	private AccountDao accountDao;
	//��ʼ��
	public AccountService() throws IOException{
		inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		sqlSession = factory.openSession(); 
		accountDao = sqlSession.getMapper(AccountDao.class);
	}
	
	//�ͷ���Դ
	private void destroy() { 
		try {
			sqlSession.commit(); 
			sqlSession.close(); 
			inputStream.close(); 
		} catch (IOException e) { 
			e.printStackTrace(); 
		} 
		
	}
	
	
    // 1��ѯ���м�¼
    List<Account> findAll() {
        List<Account> findAll = accountDao.findAll();
        destroy();
        return findAll;
    }
    // 2ͨ��idɾ����¼
    void deleteByPrimaryKey(String id) {
        accountDao.deleteByPrimaryKey(id);
        destroy();
    }
    // 3�����¼
    void insert(Account record) {
        accountDao.insert(record);
        destroy();
    }
    // 4ͨ��id���Ҷ���
    Account selectByPrimaryKey(String id) {
        Account selectByPrimaryKey = accountDao.selectByPrimaryKey(id);
        destroy();
        return selectByPrimaryKey;
    }
    // 5����Account
    void updateByPrimaryKey(Account record) {
        accountDao.updateByPrimaryKey(record);
        destroy();
    }
    // 6ת�˹��� ����ת����id��ת����id��ת�˽�� ʵ��ת��
    void transfer(String remitterId,String remitteeId,int money) {
        try {
            if (remitteeId == remitterId) {
                throw new Exception("ת�롢ת�����ظ���");
            }
            Account remitter = accountDao.selectByPrimaryKey(remitterId);
            Account remittee = accountDao.selectByPrimaryKey(remitteeId);
            int remitterMoney = remitter.getMoney();
            int remitteeMoney = remittee.getMoney();
            if (remitterMoney >= money){
                remitter.setMoney(remitterMoney - money);
                remittee.setMoney(remitteeMoney + money);
                accountDao.updateByPrimaryKey(remitter);
                accountDao.updateByPrimaryKey(remittee);
            } else {
                throw new Exception("���㡣");
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            destroy();
        }
    }
	
	
}
