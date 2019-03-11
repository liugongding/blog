package service;


import util.PageBean;
import entity.BlogComment;

public interface BlogCommentService {
	
	//添加评论
	public void addComment(BlogComment comment);
	
	//根据文章id分页查询所有评论
	public PageBean<BlogComment> listComment(int pageSize, int pageCode, String id);
}
