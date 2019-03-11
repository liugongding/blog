package serviceimpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import service.BlogImagesService;
import dao.BlogImagesDAO;
import entity.BlogImages;

@Service
public class BlogImagesServiceImpl implements BlogImagesService {

	@Resource
	BlogImagesDAO blogImDAO;
	public BlogImages addImages(String fileName, String filePath) {
		return blogImDAO.addImages(fileName, filePath);
	}

}
