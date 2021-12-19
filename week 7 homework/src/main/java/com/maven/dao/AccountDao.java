package com.maven.dao;

import java.util.List;

import com.maven.domain.*;


public interface AccountDao {

	// 1��ѯ���м�¼ 
	List<Account> findAll();
	
	// 2ͨ��idɾ����¼ 
	int deleteByPrimaryKey(String id);
	
	// 3�����¼ 
	int insert(Account record);
	
	// 4ͨ��id���Ҷ��� 
	Account selectByPrimaryKey(String id);
	
	// 5����Account 
	int updateByPrimaryKey(Account record);

}
