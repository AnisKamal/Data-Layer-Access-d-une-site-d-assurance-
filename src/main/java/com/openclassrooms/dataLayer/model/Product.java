package com.openclassrooms.dataLayer.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;


@Entity
@Table(name = "produit")
@DynamicUpdate
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "produit_id")
	private int  productId;
	
	@Column(name = "nom")
	private String name;
	
	@Column(name= "description")
	private String description;
	
	@Column(name = "cout")
	private int cost;
	
	
	@OneToMany(
			mappedBy = "product",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	List<Comment> comments = new ArrayList<>();
	
	@ManyToMany(
			mappedBy = "products", 
			cascade = CascadeType.ALL
			)
	private List<Category> categories = new ArrayList<>();
	
	
	
	/*
	@ManyToMany(
			fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			})
	@JoinTable(
			name = "categorie_produit",
			joinColumns = @JoinColumn(name="produit_id"),
			inverseJoinColumns = @JoinColumn(name="categorie_id")
			)
	private List<Category> categories = new ArrayList<>();
	*/
	
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public void addComment(Comment comment) {
		comments.add(comment);
		comment.setProduct(this);
	}
	
	public void removeComment(Comment comment) {
		comments.remove(comment);
		comment.setProduct(null);
	}
	
	/*
	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	*/
	
	
	
}
