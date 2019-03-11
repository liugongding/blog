package service;

import entity.Login;

public interface LoginService {

	/**
	 * 查询登陆者的账号密码
	 * @param username
	 * @param password
	 * @return
	 */
	Login getLoginData(Login login);
	
}
