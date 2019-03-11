package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import entity.BlogArticles;

@Repository
public interface BlogManagerDAO {

	/**
	 * 添加博客类别信息
	 * @param blogtype
	 * @return
	 */
	Integer addBlogType(BlogArticles blogtype);
	
	/**
	 * 更新博客类别信息
	 * @param blogType
	 * @return
	 */
	Integer updateBlogType(BlogArticles blogType);
	
	/**
	 * 删除博客类别信息
	 * @param blogType
	 * @return
	 */
	Integer deleteBlogType(Integer id);
	
	/**
     * 根据id查询博客类别信息
     * @param id
     * @return
     */
    BlogArticles getById(Integer id);
    
	/**
	 * 分页查询博客类别信息
	 * @param start
	 * @param end
	 * @return
	 */
	List<BlogArticles> listByPage(@Param("start") int start, @Param("end") int end);
	int getTotal();
}
