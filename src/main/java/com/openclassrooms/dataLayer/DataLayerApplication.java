package com.openclassrooms.dataLayer;



import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.openclassrooms.dataLayer.model.Category;
import com.openclassrooms.dataLayer.model.Comment;
import com.openclassrooms.dataLayer.model.Product;
import com.openclassrooms.dataLayer.service.CategoryService;
import com.openclassrooms.dataLayer.service.CommentService;
import com.openclassrooms.dataLayer.service.ProductService;


@SpringBootApplication
public class DataLayerApplication implements CommandLineRunner{

	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CommentService commentService;
	
	public static void main(String[] args) {
		SpringApplication.run(DataLayerApplication.class, args);
	}

	@Override
	@Transactional 
	public void run(String... args) throws Exception {
		
		Iterable<Category> searchResults = categoryService.getCategoriesByName("Promotion");
		searchResults.forEach(
				category -> System.out.println(category.getName()));
		searchResults = categoryService.findByProductsName("AssuranceAuTiersFidelite");
		searchResults.forEach(
				category -> System.out.println(category.getName()));
		
		Iterable<Product> searchProduct = productService.getProductsByCostLessThan(3000);
		searchProduct.forEach(
				product -> System.out.println(product.getCost()));
		
		Iterable<Comment> searchComment = commentService.getCommentContaining("deçu");
		searchComment.forEach(
				comment -> System.out.println(comment.getContent()));
		/*
		Iterable<Product> searchResults = productService.getProductsByName("AssuranceAuTiersSimple");
		searchResults.forEach(
				product -> System.out.println(product.getProductId()));
		
		searchResults = productService.getProductByCategoryName("Promotion");
		searchResults.forEach(product -> System.out.println(product.getName()));
		
		*/
		/*
		productService.deleteProductById(3);
		commentService.deleteCommentById(3);
		categoryService.deleteCategoryById(3);
		*/
		
		/*
		Product existingProduct = productService.getProductById(1).get();
		System.out.println(existingProduct.getCost());
		
		existingProduct.setCost(4000);
		productService.addProduct(existingProduct);
		
		existingProduct = productService.getProductById(1).get();
		System.out.println(existingProduct.getCost());
		*/
		/*
		Product productAssuranceAuTiers = productService.getProductById(1).get();
		
		Comment newComment = new Comment();
		newComment.setContent("Assurance peu intéressante.");
		productAssuranceAuTiers.addComment(newComment);
		
		commentService.getComments().forEach(
				comment -> System.out.println(comment.getContent()));
				
		*/
		
		/*
		categoryService.getCategories().forEach(
				category -> System.out.println(category.getName()));
		
		Category newCategory = new Category();
		newCategory.setName("Promotion");
		
		newCategory = categoryService.addCategory(newCategory);
		
		categoryService.getCategories().forEach(
				category -> System.out.println(category.getName()));
		
		Product newProduct = new Product();
		newProduct.setName("AssuranceAuTiersFidelite");
		newProduct.setDescription("Les garanties de l'assurance au tiers à un prix"
				+ "moindre grace à vitre fidélité!");
		newProduct.setCost(1100);
		
		newCategory.addProduct(newProduct);
		
		newProduct = productService.addProduct(newProduct);
		
		productService.getProducts().forEach(
				product -> System.out.println(product.getName()));
		
		newProduct.getCategories().forEach(
				category -> System.out.println(category.getName()));
		*/
		
		/*
		Optional<Product>optProduct = productService.getProductById(1);
		Product productId1 = optProduct.get();
		
		System.out.println(productId1.getName());
		
		productId1.getComments().forEach(comment -> System.out.println(comment.getContent()));
		
		System.out.println();
		
		Optional <Comment> optComment = commentService.getCommentById(1);
		Comment commentId1 = optComment.get();
		System.out.println(commentId1.getContent());
		
		System.out.println(commentId1.getProduct().getName());
		
		*/
		
		/*
		Optional<Product> optProduct = productService.getProductById(1);
		Product productId1 = optProduct.get();

		System.out.println(productId1.getName());
		
		productId1.getCategories().forEach(
				category -> System.out.println(category.getName()));
		
		Optional<Category> optCategory = categoryService.getCategoryById(1);
		Category category = optCategory.get();
		System.out.println(category.getName());
		category.getProducts().forEach(
				product -> System.out.println(product.getName()));	
				
				*/
		
		/*
		Optional<Category> optCategory = categoryService.getCategoryById(1);
		Category categoryId1 = optCategory.get();
		
		System.out.println(categoryId1.getName());
		
		categoryId1.getProducts().forEach(
				product -> System.out.println(product.getName()));
				*/
		
		
		/*
		Optional<Product> optProduct = productService.getProductById(1);
		Product productId1 = optProduct.get();
		
		System.out.println(productId1.getName());
		
		productId1.getComments().forEach(
				comment -> System.out.println(comment.getContent()));
				*/
		
		/*
		Iterable<Product> products = productService.getProducts();
		products.forEach(product -> System.out.println(product.getName()));
		
		System.out.println();System.out.println();
		
		
		Iterable<Category> categories = categoryService.getCategories();
		categories.forEach(category -> System.out.println(category.getName()));
		
		System.out.println();System.out.println();
		
		
		Iterable<Comment> comments  = commentService.getComments();
		comments.forEach(comment -> System.out.println(comment.getContent()));
		
		System.out.println(); System.out.println();
		
		
		Optional<Product> optProduct = productService.getProductById(1);
		Product productId1 = optProduct.get();
		System.out.println(productId1.getName());
		
		System.out.println(); System.out.println();
		
		Optional<Category> optCategory = categoryService.getCategoryById(1);
		Category categoryId1 = optCategory.get();
		System.out.println(categoryId1.getName());
		
		System.out.println(); System.out.println();
		
		Optional<Comment> optComment = commentService.getCommentById(1);
		Comment commentId1 = optComment.get();
		System.out.println(commentId1.getContent());
		*/
	}

}
