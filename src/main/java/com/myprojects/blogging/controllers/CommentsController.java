package com.myprojects.blogging.controllers;

import com.myprojects.blogging.entities.Comment;
import com.myprojects.blogging.payloads.CommentsDto;
import com.myprojects.blogging.services.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CommentsController {
    @Autowired
    private CommentsService commentservice;
    @PostMapping("/post/{postId}/comments")
    public ResponseEntity<CommentsDto> createComments(@RequestBody CommentsDto comment, @PathVariable Integer postId){
        CommentsDto comm = this.commentservice.createComment(comment, postId);

        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }

    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<?> deleteComments(@PathVariable Integer commentId){
        this.commentservice.delete(commentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
