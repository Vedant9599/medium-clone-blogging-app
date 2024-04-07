package com.myprojects.blogging.repositories;

import com.myprojects.blogging.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepo extends JpaRepository<Comment, Integer> {
}
