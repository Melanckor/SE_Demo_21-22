package com.example.demo.datamodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Book {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id ; 
private String name;
private String author;
private int year;
private float price; 

public Book() {
		// TODO Auto-generated constructor stub
	}

public Book(String name, String author,int year,int price) {
	this.name = name;
	this.author = author;
	this.year = year;
	this.price = price;
	// TODO Auto-generated constructor stub
}




public float getPrice() {
	return price;
}

public void setPrice(float price) {
	this.price = price;
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
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}
}
