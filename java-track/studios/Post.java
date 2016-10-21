import java.util.Date;

public class Post {
	
	/*
	 * properties
	 * body
	 * title
	 * author
	 * created-using the date type should not be updated once set, use final
	 * modify date-should be modifiable and update when changing title or body
	 */
	
	private String body;
	private String title;
	private String author;
	private final Date created;
	private Date modified;
	
	public Post(String title, String author, String body)
	{
		title = this.title;
		author = this.author;
		body = this.body;
		created = new Date();
		modified = this.modified;
	}
	
	/*
	 * need to set up method to determine if a title or body has been changed, and set the modified property
	 */
	
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getModified() {
		return modified;
	}

	public Date setModified(Date modified) {
		return this.modified = modified;
	}

	public String getAuthor() {
		return author;
	}

	public Date getCreated() {
		return created;
	}

	public Date modifiedDate(){
		Date now = new Date();
		return setModified(now);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
}
