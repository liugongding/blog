package serviceimpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import service.LoginService;
import dao.LoginDAO;
import entity.Login;

@Service
public class LoginServiceImpl implements LoginService {

	@Resource
	LoginDAO loginDAO;
	
	public Login getLoginData(Login login) {
		return loginDAO.getLoginData(login);
	}
}
