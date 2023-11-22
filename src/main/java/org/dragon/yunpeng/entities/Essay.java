package org.dragon.yunpeng.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

@Indexed
@Entity
@Table(name = "ESSAY")
public class Essay implements Serializable {

	@Id
	@Column(name = "ESSAY_ID")
	@GeneratedValue
	private Long id;

	@FullTextField
	@Column(name = "TITLE")
	private String title;

	@Column(name = "AUTHOR")
	private String author;

	@FullTextField
	@Lob
	@Column(name = "CONTENT", columnDefinition = "clob")
	private String content;

	public Essay() {
	}

	public Essay(long id, String title, String author, String content) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Id: " + id + ", Title: " + title + ", Author: " + author + ", Content: " + content;

	}
}
