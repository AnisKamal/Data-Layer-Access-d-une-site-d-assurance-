package com.openclassrooms.dataLayer.repository;

import org.springframework.data.repository.CrudRepository;

import com.openclassrooms.dataLayer.model.Comment;

public interface CommentRepository extends CrudRepository<Comment, Integer>{
	
	public Iterable<Comment> findByContentContaining(String expression);
	
}
