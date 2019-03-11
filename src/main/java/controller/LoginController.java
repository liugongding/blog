package controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import service.LoginService;
import entity.Login;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	LoginService loginSer;

	@ResponseBody
	@RequestMapping("logindemo")
	public Object login(Login login ,@RequestParam(value = "password") String password) {
		Map<String, String> resultMap = new HashMap<String, String>();
		if (loginSer.getLoginData(login)!=null) {
			resultMap.put("stateCode", "1");
		} else  {
			resultMap.put("stateCode", "0");
		} 
		return resultMap;
	}
}
