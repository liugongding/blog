package entity;

public class BlogImages{
	
	private int id;
	private String fileName;
	private String filePath;
	
	public BlogImages(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public String toString() {
		return "BlogImages [id=" + id + ", fileName=" + fileName
				+ ", filePath=" + filePath + "]";
	}
	
	
}