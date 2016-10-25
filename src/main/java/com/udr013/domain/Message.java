package com.udr013.domain;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**n
 * to know its value is represented as XML element in an XML document so we can use it
 * in MediaType.APPLICATION_XML we need to annotate it with @XmlRootElement
 */
@XmlRootElement
public class Message implements Serializable{

	private static final long serialVersionUID = 2816203441445864290L;

	private long id;
	private String message;
	private Date created;
	private String author;

	public Message(){

	}

	public Message(long id, String message, String author) {
		this.id = id;
		this.message = message;
		this.created = new Date();
		this.author = author;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}
