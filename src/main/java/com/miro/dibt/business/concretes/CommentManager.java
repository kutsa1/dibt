package com.miro.dibt.business.concretes;

import com.miro.dibt.business.abstracts.ICommentService;
import com.miro.dibt.business.abstracts.IReportService;
import com.miro.dibt.business.abstracts.IUserService;
import com.miro.dibt.business.tools.Messages;
import com.miro.dibt.core.utilities.business.BusinessRule;
import com.miro.dibt.core.utilities.results.*;
import com.miro.dibt.entities.Dtos.CommentDetailDto;
import com.miro.dibt.entities.concretes.Comment;
import com.miro.dibt.repo.abstracts.ICommentDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentManager implements ICommentService {
    private final ICommentDao iCommentDao;
    private final IUserService iUserService;
    private final IReportService iReportService;

    @Override
    public DataResult<List<Comment>> getAll() {
        return new SuccesDataResult(iCommentDao.findAll(), Messages.commentListed);
    }

    @Override
    public IResult add(Comment comment) {
        comment.setDate(LocalDateTime.now());
        iCommentDao.save(comment);
        return new SuccessResult(Messages.commentSave);
    }

    @Override
    public IResult update(Comment comment) {
        iCommentDao.save(comment);
        return new SuccessResult(Messages.commentUpdate);
    }

    @Override
    public IResult delete(Comment comment) {
        iCommentDao.delete(comment);
        return new SuccessResult(Messages.commentDelete);
    }

    @Override
    public DataResult<Comment> getById(Integer id) {

        return new SuccesDataResult<>(iCommentDao.getById(id), Messages.commentListed);
    }

    @Override
    public DataResult<List<CommentDetailDto>> getAllCommentDetailDto() {
        return new SuccesDataResult<>(iCommentDao.getAllCommentDetailDto());
    }

    @Override
    public IResult addCommentToUser(int commentId, int userId) {

        var result = BusinessRule.run(isCommentExistById(commentId), isExistUserById(userId));

        if (result != null)
            return result;

        var comment = iCommentDao.getById(commentId);
        var user = iUserService.getById(userId);
        comment.setUser(user.getData());
        iCommentDao.save(comment);

        return new SuccessResult(Messages.commentAddedToUser);
    }


    @Override
    public IResult addCommentToReport(int commentId, int reportId) {
        var result = BusinessRule.run(isCommentExistById(commentId), isReportExistById(reportId));

        if (result != null)
            return result;
        var comment = iCommentDao.getById(commentId);
        var report = iReportService.getById(reportId);

        comment.setReport(report.getData());

        iCommentDao.save(comment);
        return new SuccessResult();
    }

    private IResult isReportExistById(int reportId) {

        var result = iReportService.getById(reportId);
        if (result.getData() == null)
            return new ErrorResult(Messages.reportNotFound);
        return new SuccessResult();
    }

    private IResult isCommentExistById(int commentId) {
        var result = iCommentDao.existsById(commentId);
        if (!result)
            return new ErrorResult(Messages.commentNotFound);

        return new SuccessResult();
    }

    private IResult isExistUserById(int userId) {

        var result = iUserService.existsById(userId);
        if (!result.isSuccess())
            return new ErrorResult(Messages.userNotFound);
        return new SuccessResult();
    }


}
