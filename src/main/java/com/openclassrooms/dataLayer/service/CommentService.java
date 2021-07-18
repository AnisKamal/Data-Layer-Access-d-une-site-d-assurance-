package com.openclassrooms.dataLayer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.dataLayer.model.Comment;
import com.openclassrooms.dataLayer.repository.CommentRepository;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository commentRepository;

	public Iterable<Comment> getComments(){
		return commentRepository.findAll();
	}
	
	public Optional<Comment> getCommentById(Integer id){
		return commentRepository.findById(id);
	}
	
	public Comment addComment(Comment comment) {
		return commentRepository.save(comment);
	}
	
	public void deleteCommentById(Integer id) {
		commentRepository.deleteById(id);
	}
	
	public Iterable<Comment> getCommentContaining(String expression){
		return commentRepository.findByContentContaining(expression);
	}
}
