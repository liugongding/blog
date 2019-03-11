package serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import service.BlogMessageService;
import util.PageBean;
import dao.BlogMessageDAO;
import entity.BlogMessage;

@Service
public class BlogMessageServiceImpl implements BlogMessageService {

	@Resource
	BlogMessageDAO blogMessDAO;
	
	public int addMessage(BlogMessage message) {
		return blogMessDAO.addMessage(message);
	}

	public PageBean<BlogMessage> listMessage(int pageSize,int pageCode) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		PageBean<BlogMessage> pageBean = new PageBean<BlogMessage>();
		//封装当前页和每页显示的数据
		pageBean.setPageCode(pageCode);
		pageBean.setPageSize(pageSize);
		//封装总数count和总页数
		int totalCount = blogMessDAO.getTotal();
		pageBean.setTotalCount(totalCount);
		Double num = Math.ceil(totalCount / pageSize);
	    pageBean.setTotalPage(num.intValue());
	    // 设置limit分页查询的起始位置和终止位置
	    resultMap.put("start",(pageCode - 1) * pageSize);
	    resultMap.put("count",pageBean.getPageSize());

        //封装每页显示的数据
        List<BlogMessage> list = blogMessDAO.listMessage(resultMap);
        pageBean.setBeanList(list);
        //System.out.println(totalCount);
        //System.out.println(list);
		return pageBean;
	}

}
