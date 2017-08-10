package cn.itcast.spring.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.itcast.spring.dao.AccountDAO;
import cn.itcast.spring.domain.Account;
import cn.itcast.spring.service.AccountService;
@SuppressWarnings("unused")

@Transactional
@Service("accountService")
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountDAO accountDAO;

	@Override
	public void saveAccount(Account account) {
		accountDAO.save(account);
		System.out.println("AccountServiceImpl..save");
	}

	@Override
	public void updateAccount(Account account) {
		accountDAO.update(account);
		System.out.println("AccountServiceImpl..updateAccount");
	}

	@Override
	public void deleteAccount(Account account) {
		accountDAO.delete(account);
		System.out.println("AccountServiceImpl..deleteAccount");
	}

	@Override
	public List<Account> findAllAccountList() {
		System.out.println("AccountServiceImpl..findAll");
		return accountDAO.findAll();
	}

	@Override
	public List<Account> findAccountListByNameLike(DetachedCriteria criteria) {
		System.out.println("AccountServiceImpl..findAccountListByNameLike");
		return accountDAO.findAccountListByNameLike(criteria);
	}
	
	@Override
	public List<Account> findAccountListByNameLike(String name) {
		System.out.println("AccountServiceImpl..findAccountListByNameLike");
		return accountDAO.findAccountListByNameLike("Account.findAccountListByNameLike",name);
	}
	
}
