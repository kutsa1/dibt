package com.miro.dibt.api.controller;

import com.miro.dibt.business.abstracts.ICommentSerive;
import com.miro.dibt.core.api.ControllerBase;
import com.miro.dibt.entities.concretes.Comment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/comments")
public class CommentController extends ControllerBase<Comment, ICommentSerive> {

    ICommentSerive iCommentSerive;

    public CommentController(ICommentSerive iCommentSerive) {
        super(iCommentSerive);
        this.iCommentSerive=iCommentSerive;
    }
}
