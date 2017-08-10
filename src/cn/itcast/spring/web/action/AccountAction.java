package cn.itcast.spring.web.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import cn.itcast.spring.domain.Account;
import cn.itcast.spring.service.AccountService;

@SuppressWarnings("serial")

@Controller("accountAction")
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/")
public class AccountAction extends ActionSupport implements ModelDriven<Account> {
	@Autowired
	private AccountService accountService;

	private Account account = new Account();
	
	public Account getModel() {
		return account;
	}
	
	@Action(value="account_add",results={@Result(name="success",location="/success.jsp")})
	public String add() throws Exception {
//		org.springframework.web.context.ContextLoaderListener ds;
//		org.springframework.orm.hibernate5.LocalSessionFactoryBean sf;
//		sf.setMappingResources(mappingResources);
//		sf.setHibernateProperties(hibernateProperties);
//		sf.setDataSource(dataSource);
//		sf.setPackagesToScan(packagesToScan);
		System.out.println("AccountAction..add");
		accountService.saveAccount(account);
		return SUCCESS;
	}
}
