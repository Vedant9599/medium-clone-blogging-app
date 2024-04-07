package com.myprojects.blogging.services;

import com.myprojects.blogging.payloads.CommentsDto;

import java.util.List;

public interface CommentsService {

    CommentsDto createComment(CommentsDto commentDto, Integer postId);

    void delete(Integer commentId);

}
