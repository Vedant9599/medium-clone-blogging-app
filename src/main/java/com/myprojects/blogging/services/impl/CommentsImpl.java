package com.myprojects.blogging.services.impl;

import com.myprojects.blogging.entities.Comment;
import com.myprojects.blogging.entities.Post;
import com.myprojects.blogging.exceptions.ResourceNotFoundException;
import com.myprojects.blogging.payloads.CommentsDto;
import com.myprojects.blogging.payloads.PostDto;
import com.myprojects.blogging.repositories.CommentsRepo;
import com.myprojects.blogging.repositories.PostRepo;
import com.myprojects.blogging.services.CommentsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentsImpl implements CommentsService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PostRepo postRepo;
    @Autowired
    private CommentsRepo commentsRepo;
    @Override
    public CommentsDto createComment(CommentsDto commentDto, Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","PostID", postId));
        Comment comment = this.modelMapper.map(commentDto, Comment.class);
        comment.setPost(post);

        Comment savedComment = this.commentsRepo.save(comment);

        return this.modelMapper.map(savedComment, CommentsDto.class);
    }

    @Override
    public void delete(Integer commentId) {
        Comment comment = this.commentsRepo.findById(commentId).orElseThrow(()-> new ResourceNotFoundException("comment","commentId", commentId));
        this.commentsRepo.delete(comment);

    }

}
