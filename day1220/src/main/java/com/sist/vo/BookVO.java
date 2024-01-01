package com.sist.vo;

public class BookVO {

	private int bookId;
	private String bookName;
	private int price;
	private String publisher;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public BookVO(int bookId, String bookName, int price, String publisher) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.price = price;
		this.publisher = publisher;
	}
	public BookVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
