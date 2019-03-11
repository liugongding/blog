package service;

import java.util.List;

import entity.BlogArticles;

public interface BlogManagerService {

	//添加博客类别
	public Integer addBlogType(BlogArticles blogtype);
	
	//更新博客类别
	public Integer updateBlogType(BlogArticles blogType);
	
	//删除博客类别
	public Integer deleteBlogType(Integer id);
	
	//通过id进行查询
	BlogArticles getById(Integer id);
	
	//显示博客信息
	public List<BlogArticles> listByPage(int start, int end);
	int getTotal();
}
