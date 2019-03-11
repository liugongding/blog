package service;

import util.PageBean;
import entity.BlogMessage;

public interface BlogMessageService {

	public int addMessage(BlogMessage message);		//添加留言
	
	public PageBean<BlogMessage> listMessage(int PageSize, int PageCode);
}
