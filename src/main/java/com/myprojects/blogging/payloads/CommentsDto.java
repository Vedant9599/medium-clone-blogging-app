package com.myprojects.blogging.payloads;

import com.myprojects.blogging.entities.Post;
import com.myprojects.blogging.entities.User;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class CommentsDto {

    @NotEmpty
    private String content;
    @NotEmpty
    private int id;

}
