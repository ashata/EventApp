package org.hoboventures.wedding.service;

import org.hoboventures.wedding.dto.Comment;

import java.util.List;

/**
 * Created by Asha on 4/22/2017.
 */
public interface CommentService {

    Long saveComment(Comment comment);
    List<Comment> findAll();
    Long deleteComment(Comment comment);

}
