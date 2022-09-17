package com.booksharing.repository;

import org.springframework.data.repository.CrudRepository;

import com.booksharing.entity.Comment;

public interface CommentRepo extends CrudRepository<Comment, Integer> {

}
