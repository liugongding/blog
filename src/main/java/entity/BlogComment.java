package entity;

public class BlogComment {

	private int id;				//评论编号
	private String words;		//评论内容
	private String name;		//评论人的昵称
	private String articleId;	//对哪一篇文章进行评论
	public BlogComment() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWords() {
		return words;
	}
	public void setWords(String words) {
		this.words = words;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getArticleId() {
		return articleId;
	}
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	@Override
	public String toString() {
		return "BlogComment [id=" + id + ", words=" + words + ", name=" + name
				+ ", articleId=" + articleId + "]";
	}
	
}
