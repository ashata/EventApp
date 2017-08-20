package org.hoboventures.wedding.service.impl;

import org.hoboventures.wedding.dto.Comment;
import org.hoboventures.wedding.dao.CommentRepository;
import org.hoboventures.wedding.service.CommentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asha on 4/22/2017.
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Resource private CommentRepository commentRepository;

    @Override
    public Long saveComment(Comment comment) {
        Long returnVal;
        try {
            //elastic logs
            if (comment.getId() == null) {
                //saving
            } else {
                //editing
            }
            comment = commentRepository.save(comment);
            returnVal = 0L;
        }
        catch (Exception ex){
            returnVal = -1L;
        }
        return returnVal;
    }

    @Override
    public List<Comment> findAll() {
        List<Comment> commentList = new ArrayList<Comment>();
        Pageable page = new PageRequest(2, 10);
        Page<Comment> commentPages = commentRepository.findAll(page);
        if(commentPages != null && commentPages.getContent() != null){
           commentList = commentPages.getContent();
        }
        return commentList;
    }

    @Override
    public Long deleteComment(Comment comment) {
        Long returnVal = -2L;
        try {
            if (comment.getId() != null) {
                commentRepository.delete(comment);
                returnVal = 0L;
            }
        }
        catch (Exception ex){
            returnVal = -1L;
        }
        return returnVal;
    }
}
