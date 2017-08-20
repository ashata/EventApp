package org.hoboventures.wedding.web;

import org.hoboventures.wedding.dto.Comment;
import org.hoboventures.wedding.util.JsonUtil;
import org.hoboventures.wedding.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Asha on 4/22/2017.
 */
@RestController
public class CommentController {

    @Autowired private CommentService commentService;

    @PostMapping(value = "comment")
    public String saveComment(@RequestBody String commentStr){
       Comment comment = JsonUtil.fromJson(commentStr, Comment.class);
        Long returnVal = commentService.saveComment(comment);
       return "";
    }

    @GetMapping(value = "fetchComments")
    public List<Comment> findAll(){
        return commentService.findAll();
    }

    @GetMapping(value = "deleteComment")
    public void deleteComment(@RequestBody String commentStr){
        Comment comment = JsonUtil.fromJson(commentStr, Comment.class);
        Long returnVal = commentService.deleteComment(comment);
    }

}
