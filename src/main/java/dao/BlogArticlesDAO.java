package dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import entity.BlogArticles;

@Repository
public interface BlogArticlesDAO {
	
	//将分页查询的结果封装到map中
	public List<BlogArticles> findByPage(Map<String, Object> resultMap);
	
	//获取文章总量
	int selectCount();
	
	//通过文章id进行阅读
	BlogArticles getById(Integer id);
}
