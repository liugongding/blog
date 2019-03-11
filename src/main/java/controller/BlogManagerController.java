package controller;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import service.BlogManagerService;
import entity.BlogArticles;

@Controller
@RequestMapping("/test")
public class BlogManagerController {

	@Autowired
	private BlogManagerService blogManSer;
	@Autowired
	private ServletContext servletContext;
	
	@RequestMapping("/uploadImages")
	@ResponseBody
	public Map<String, Object> upload(@RequestParam(value = "file") MultipartFile file,
			HttpServletRequest request) throws Exception {
		String uuid = UUID.randomUUID().toString();// 获取一个随机字符串
		String ext = FilenameUtils.getExtension(file.getOriginalFilename());// 获取文件拓展名（获取文件名称）
		String fileName = uuid + "." + ext;
		String filePath = servletContext.getRealPath("/upload");
		Files.copy(file.getInputStream(), Paths.get(filePath, fileName));
		System.out.println(fileName);
		System.out.println(filePath);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("code", "0");
		resultMap.put("msg", "");
		resultMap.put("data", filePath);
		return resultMap;
	}
	///数据表格分页
	@RequestMapping("list")
	@ResponseBody
	public Map<String, Object> findAllNews(int page, int limit) {
		int start = limit * (page - 1);// 开始页
		int end = page * limit;// 结束页
		List<BlogArticles> eilist = blogManSer.listByPage(start, end);// 查询所有
		int count = blogManSer.getTotal();// 查询总数
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("data", eilist);
		resultMap.put("count", count);
		resultMap.put("msg", "");
		resultMap.put("code", "0");
		return resultMap;
	}
	
	//通过id删除指定文章
	@RequestMapping("delete")
	@ResponseBody
	public String deleteBlog(Integer id) {
		if (id != null) {
			blogManSer.deleteBlogType(id);
			return "success";
		}
		return "false";
	}
	
	//添加文章
	@RequestMapping("addBlog")
	@ResponseBody
	public Object addBlog(BlogArticles articles) {
		// addMessage(Message message)的对象是从页面获取的
		Map<String, String> res = new HashMap<String, String>();
		if (blogManSer.addBlogType(articles) > 0) {
			res.put("stateCode", "1");
		} else {
			res.put("stateCode", "0");
		}
		return res;
	}
	
	
	//后台管理通过id进行查看文章
	@PostMapping("getBlogById")
	@ResponseBody
	public String getBlogById1(Integer id) {
		if(id !=null) {
			blogManSer.getById(id);
			return "success";
		} else {
			return "falure";
		}
	}
}