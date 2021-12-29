package com.miro.dibt.api.controller;

import com.miro.dibt.business.abstracts.ICommentService;
import com.miro.dibt.core.api.ControllerBase;
import com.miro.dibt.core.utilities.results.ErrorResult;
import com.miro.dibt.entities.concretes.Comment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/comments")
public class CommentController extends ControllerBase<Comment, ICommentService> {

    ICommentService iCommentService;

    public CommentController(ICommentService iCommentService) {
        super(iCommentService);
        this.iCommentService = iCommentService;
    }

    @GetMapping("/getallcommentdetail")
    ResponseEntity<?> getAllCommentDetail() {
        var result = iCommentService.getAllCommentDetailDto();
        if (result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(new ErrorResult(result.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/addcommenttouser")
    ResponseEntity<?> addCommentToUser(@RequestParam int commentId, int userId) {
        var result = iCommentService.addCommentToUser(commentId,userId);
        if (result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(new ErrorResult(result.getMessage()), HttpStatus.BAD_REQUEST);
    }
    @PostMapping("/addreporttocoment")
    ResponseEntity<?> addCommentToReport(@RequestParam int commentId, int reportId) {
        var result = iCommentService.addCommentToReport(commentId,reportId);
        if (result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(new ErrorResult(result.getMessage()), HttpStatus.BAD_REQUEST);
    }

}
