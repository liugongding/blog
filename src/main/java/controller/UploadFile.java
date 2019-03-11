package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import service.BlogImagesService;

@Controller
@RequestMapping("/upload")
public class UploadFile {

	@Autowired
	private ServletContext servletContext;
	@Autowired
	private BlogImagesService blogImSer;
	
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
		System.out.println(filePath+fileName);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		resultMap.put("code", "0");
		resultMap.put("msg", "");
		map.put("src","../upload/"+fileName);
		resultMap.put("data", map);
		return resultMap;
	}


	@RequestMapping("view")
	@ResponseBody
	public String view(HttpServletRequest request, HttpServletResponse response) {
		FileInputStream fis = null;
		OutputStream os = null;
		try {
			fis = new FileInputStream("E:\\log\\1.jpg");
			os = response.getOutputStream();
			int count = 0;
			byte[] buffer = new byte[1024 * 8];
			while ((count = fis.read(buffer)) != -1) {
				os.write(buffer, 0, count);
				os.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			fis.close();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "index";
	}
}
