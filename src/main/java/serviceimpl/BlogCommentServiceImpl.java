package serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.BlogCommentService;
import util.PageBean;
import dao.BlogCommentDAO;
import entity.BlogComment;

@Service
public class BlogCommentServiceImpl implements BlogCommentService {

	@Autowired
	private BlogCommentDAO BlogCoDAO;
	
	//添加评论
	public void addComment(BlogComment comment) {
		BlogCoDAO.addComment(comment);
	}

	//分页查询所有评论
	public PageBean<BlogComment> listComment(int pageSize, int pageCode, String id) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		PageBean<BlogComment> pageBean = new PageBean<BlogComment>();
		//页码和每页的数量封装到pageBean中
		pageBean.setPageCode(pageCode);
		pageBean.setPageSize(pageSize);
		
		//获取总量并计算出总共有多少页
		int totalCount = BlogCoDAO.getCount();
		pageBean.setTotalCount(totalCount);
		Double num = Math.ceil(totalCount / pageSize);
	    pageBean.setTotalPage(num.intValue());
	    
	    //设置limit分页查询的起始位置和终止位置,参考mysql的limit用法
	    resultMap.put("start", (pageCode-1)*pageSize);
	    resultMap.put("count", pageBean.getPageSize());
	    resultMap.put("id",id);
	    List<BlogComment> list = BlogCoDAO.listComment(resultMap);
	    pageBean.setBeanList(list);
		return pageBean;
	}

	
}
