package entity;

public class BlogArticles {

	private int id;				//唯一标识
	private String time;		//发表时间
	private String name;		//作者
	private String title;		//文章标题
	private String articles;	//内容
	public BlogArticles() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArticles() {
		return articles;
	}
	public void setArticles(String articles) {
		this.articles = articles;
	}
	@Override
	public String toString() {
		return "BlogArticles [id=" + id + ", time=" + time + ", name=" + name
				+ ", title=" + title + ", articles=" + articles + "]";
	}

}
