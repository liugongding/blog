package serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import service.BlogArticlesService;
import util.PageBean;
import dao.BlogArticlesDAO;
import entity.BlogArticles;

@Service
public class BlogArticlesServiceImpl implements BlogArticlesService {

	@Resource
	private	BlogArticlesDAO BlogArtDAO;
	
	//通过文章id进行阅读
	public BlogArticles getById(Integer id) {
		return BlogArtDAO.getById(id);
	}
	
	//分页查询出文章内容
	public PageBean<BlogArticles> findByPage(int pageCode, int pageSize) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
        PageBean<BlogArticles> pageBean = new PageBean<BlogArticles>();

        //封装当前页
        pageBean.setPageCode(pageCode);
        pageBean.setPageSize(pageSize);

        // 封装总记录数（从数据库中查询）
        int totalCount = BlogArtDAO.selectCount();
        pageBean.setTotalCount(totalCount);

        //获取总量并计算出有多少页
        double tc = totalCount;
        Double num = Math.ceil(tc / pageSize);
        pageBean.setTotalPage(num.intValue());

        // 设置limit分页查询的起始位置和终止位置
        resultMap.put("start",(pageCode - 1) * pageSize);
        resultMap.put("size",pageBean.getPageSize());

        //封装每页显示的数据
        List<BlogArticles> list = BlogArtDAO.findByPage(resultMap);
        pageBean.setBeanList(list);
        return pageBean;
	}

}
