package dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import entity.BlogComment;
@Repository
public interface BlogCommentDAO {

	public void addComment(BlogComment comment);//添加评论
	
	//将所有评论封装到map中
	public List<BlogComment> listComment(Map<String, Object> map);
	
	//获取评论总量
	public int getCount();
}
