package dao;

import org.springframework.stereotype.Repository;

import entity.BlogImages;

@Repository
public interface BlogImagesDAO {

	/**
	 * 添加图片信息
	 * @param fileName
	 * @param filePath
	 * @return
	 */
	public BlogImages addImages(String fileName, String filePath);
}
