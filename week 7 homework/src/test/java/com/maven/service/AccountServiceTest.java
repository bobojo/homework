package com.maven.service;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.maven.domain.Account;

public class AccountServiceTest {
	
	private AccountService accountService;
	
	@Before 
	public void init() throws IOException{
		accountService = new AccountService(); 
	}
	
    @Test
    public void testFindAll(){// 1��ѯ���м�¼
        List<Account> findAll = accountService.findAll();
        for (Account account : findAll) {
            System.out.println(account);
        }
    }
    @Test
    public void testDeleteByPrimaryKey() {// 2ͨ��idɾ����¼
        accountService.deleteByPrimaryKey("3");
    }
    @Test
    public void testInsert() throws IOException{// 3�����¼
        accountService.insert(new Account("4","С��",300,"2021-5-8","2021-11-11"));
    }
    @Test
    public void testSelectByPrimaryKey() {// 4ͨ��id���Ҷ���
        Account selectByPrimaryKey = accountService.selectByPrimaryKey("1");
        System.out.println(selectByPrimaryKey);
    }
    @Test
    public void updateByPrimaryKey() {// 5����Account
        accountService.updateByPrimaryKey(new Account("1","С��",300,"2020-5-1","2021-12-1"));
    }
    @Test
    public void transfer() {// 6ת�˹���
        accountService.transfer("2","1",50);
    }
}