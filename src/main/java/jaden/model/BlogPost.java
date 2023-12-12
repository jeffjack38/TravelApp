package jaden.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BlogPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    // in case lob is not enough you will need to alter your table to be long text
    /**
     * alter table ([blog post table name] modify column content longtext;
     * so for me it was: blog_post modify column content longtext;
     */
    @Lob
    private String content;
    private String author;
    private Date date;
    
    public BlogPost() {
    	super();
    }
    
    public BlogPost(String title) {
    	super();
    	this.title = title;
    }
    
    public BlogPost(String title, Date date) {
    	super();
    	this.title = title;
    	this.date = date;
    }
    
    public BlogPost(String title, Date date, String content) {
    	super();
    	this.title = title;
    	this.date = date;
    	this.content = content;
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
	@Override
	public String toString() {
		return "BlogPost [id=" + id + ", title=" + title + ", content=" + content + ", date=" + date + "]";
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

   
}
