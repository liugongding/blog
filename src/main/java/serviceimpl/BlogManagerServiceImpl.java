package serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import service.BlogManagerService;
import dao.BlogManagerDAO;
import entity.BlogArticles;

@Service
public class BlogManagerServiceImpl implements BlogManagerService {

	@Resource
	private BlogManagerDAO blogManDAO;
	
	public Integer addBlogType(BlogArticles articles) {
		return blogManDAO.addBlogType(articles);
	}

	public Integer updateBlogType(BlogArticles blogType) {
		return blogManDAO.updateBlogType(blogType);
	}

	public Integer deleteBlogType(Integer id) {
		return blogManDAO.deleteBlogType(id);
	}

	public BlogArticles getById(Integer id) {
		return blogManDAO.getById(id);
	}
	
	public List<BlogArticles> listByPage(@Param("start")int start, @Param("end")int end) {
		return blogManDAO.listByPage(start, end);
		
	}
	public int getTotal() {
		return blogManDAO.getTotal();
	}


}
