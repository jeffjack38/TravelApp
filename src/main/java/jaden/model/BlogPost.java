// package
package jaden.model;

//imports
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

// sets up database
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BlogPost {

	// sets up id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	// sets up title
	private String title;
	// in case lob is not enough you will need to alter your table to be long text
	/**
	 * alter table ([blog post table name] modify column content longtext; so for me
	 * it was: blog_post modify column content longtext;
	 */
	@Lob
	private String content;
	// sets up author
	private String author;
	// sets up date
	private Date date;

	// no args constructor
	public BlogPost() {
		super();
	}

	// title constructor
	public BlogPost(String title) {
		super();
		this.title = title;
	}

	// sets up title and date constructor
	public BlogPost(String title, Date date) {
		super();
		this.title = title;
		this.date = date;
	}

	// sets up most args
	public BlogPost(String title, Date date, String content) {
		super();
		this.title = title;
		this.date = date;
		this.content = content;
	}

	// all args
	public BlogPost(String title, Date date, String author, String content) {
		super();
		this.title = title;
		this.date = date;
		this.content = content;
		this.author = author;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	// to string
	@Override
	public String toString() {
		return "BlogPost [id=" + id + ", title=" + title + ", content=" + content + ", date=" + date + "]";
	}

}
