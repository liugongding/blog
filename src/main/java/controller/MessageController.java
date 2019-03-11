package controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import service.BlogMessageService;
import util.PageBean;

import com.alibaba.fastjson.JSONObject;

import entity.BlogMessage;

@Controller
@RequestMapping("/test")
public class MessageController {

	@Autowired
	private BlogMessageService BlogMeSer;

	/**
	 * 增加留言信息
	 * 
	 * @param message
	 * @return
	 */
	@RequestMapping("addmessage")
	@ResponseBody
	public Object addMessage(BlogMessage message) {
		// addMessage(Message message)的对象是从页面获取的
		Map<String, String> res = new HashMap<String, String>();
		if (BlogMeSer.addMessage(message) > 0) {
			res.put("stateCode", "1");
		} else {
			res.put("stateCode", "0");
		}
		return res;
	}

	/**
	 * 分页查询留言信息
	 * 
	 * @param pageSize
	 * @param pageCode
	 * @return
	 */
	@RequestMapping("listMessage")
	@ResponseBody
	public JSONObject listMessage(
			@RequestParam(value = "pageSize") int pageSize,
			@RequestParam(value = "pageCode") int pageCode) {
		JSONObject json = new JSONObject();
		PageBean<BlogMessage> list = BlogMeSer.listMessage(pageSize, pageCode);
		json.put("message", JSONObject.toJSON(list));
		return json;
	}
}
