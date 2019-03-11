package service;

import util.PageBean;
import entity.BlogArticles;

public interface BlogArticlesService {
	/**
	 * 分页查询出文章内容
	 * @param pageCode
	 * @param pageSize
	 * @return
	 */
	public PageBean<BlogArticles> findByPage(int pageCode, int pageSize);
	/**
	 * 通过文章id进行阅读
	 * @param id
	 * @return
	 */
	BlogArticles getById(Integer id);
}
