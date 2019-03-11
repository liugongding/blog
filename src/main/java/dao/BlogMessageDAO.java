package dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import entity.BlogMessage;

@Repository
public interface BlogMessageDAO {

	public int addMessage(BlogMessage message);		//添加留言
		
	public int getTotal();						//获取留言总数
	
	List<BlogMessage> listMessage(Map<String, Object> map);//分页显示留言
}	
