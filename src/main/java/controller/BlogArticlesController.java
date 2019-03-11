package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import service.BlogArticlesService;
import util.PageBean;

import com.alibaba.fastjson.JSONObject;

import entity.BlogArticles;

@Controller
@RequestMapping("/Articles")
public class BlogArticlesController {
	
	@Autowired
	private BlogArticlesService BlogArtSer;
	
	/**
	 * 分页显示博客文章
	 */
	@RequestMapping("listArticles")
	@ResponseBody
	public JSONObject findByPage(
			@RequestParam(value = "pageCode") int pageCode,
			@RequestParam(value = "pageSize") int pageSize) {
		JSONObject json = new JSONObject();
		// 将前台获取的pageCode和pageSize封装到PageBean中
		PageBean<BlogArticles> list = BlogArtSer.findByPage(pageCode,pageSize);
		//将查询出来的集合对象转化成json数据
		json.put("blog", JSONObject.toJSON(list));
		return json;
	}

	/**
	 * 根据哪一篇文章的id进行阅读
	 * @param id
	 * @return
	 */
	@PostMapping("getBlogById")
	@ResponseBody
	public JSONObject getBlogById(Integer id) {
		JSONObject json = new JSONObject();
		//通过id查询出文章
		BlogArticles blog = BlogArtSer.getById(id);
		//将文章对象转化成json数据类型
		json.put("blog", JSONObject.toJSON(blog));
		return json;
	}
	
	@PostMapping("getDetails")
	@ResponseBody
	public String getDetails(Integer id) {
		if(id !=null) {
			BlogArtSer.getById(id);
			return "success";
		} else {
			return "falure";
		}
	}
}
