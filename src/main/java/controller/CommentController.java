package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import service.BlogCommentService;
import util.PageBean;

import com.alibaba.fastjson.JSONObject;

import entity.BlogComment;

@Controller
@RequestMapping("/comment")
public class CommentController<requestHttpServletRequest> {

	@Autowired
	BlogCommentService blogCoSer;

	/**
	 * 增加文章的评论
	 * @param comment
	 * @return
	 */
	@PostMapping("addComment")
	@ResponseBody
	public String addComment(BlogComment comment) {
		if (comment != null) {
			blogCoSer.addComment(comment);
			return "success";
		} else {
			return "falure";
		}
	}

	/**
	 * 显示评论信息
	 * @param pageSize
	 * @param pageCode
	 * @param id
	 * @return
	 */
	@RequestMapping("listComment")
	@ResponseBody
	public JSONObject listComment(
			@RequestParam(value = "pageSize") int pageSize,
			@RequestParam(value = "pageCode") int pageCode, 
			@RequestParam(value = "id")String id) {
		PageBean<BlogComment> list = blogCoSer.listComment(pageSize, pageCode,id);
		JSONObject json = new JSONObject();
		json.put("comment", JSONObject.toJSON(list));
		return json;
	}
}
