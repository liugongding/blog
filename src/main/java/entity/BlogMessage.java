package entity;

public class BlogMessage {

	private int id;			//唯一标识
	private String name;	//留言人昵称
	private String words;	//留言的内容
	
	public BlogMessage(){
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWords() {
		return words;
	}
	public void setWords(String words) {
		this.words = words;
	}
	@Override
	public String toString() {
		return "BlogMessage [id=" + id + ", name=" + name + ", words=" + words
				+ "]";
	}
	
}
