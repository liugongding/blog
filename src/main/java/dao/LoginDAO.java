package dao;

import org.springframework.stereotype.Repository;

import entity.Login;
@Repository
public interface LoginDAO {

	Login getLoginData(Login login);
	
}
