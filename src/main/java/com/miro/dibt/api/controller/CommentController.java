package com.miro.dibt.api.controller;

import com.miro.dibt.business.abstracts.ICommentSerive;
import com.miro.dibt.core.api.ControllerBase;
import com.miro.dibt.core.utilities.results.ErrorResult;
import com.miro.dibt.entities.concretes.Comment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/comments")
public class CommentController extends ControllerBase<Comment, ICommentSerive> {

    ICommentSerive iCommentSerive;

    public CommentController(ICommentSerive iCommentSerive) {
        super(iCommentSerive);
        this.iCommentSerive = iCommentSerive;
    }

    @GetMapping("/getallcommentdetail")
    ResponseEntity<?> getAllCommentDetail() {
        var result = iCommentSerive.getAllCommentDetailDto();
        if (result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(new ErrorResult(result.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
