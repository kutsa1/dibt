package com.miro.dibt.business.concretes;

import com.miro.dibt.business.abstracts.ICommentSerive;
import com.miro.dibt.business.tools.Messagess;
import com.miro.dibt.core.utilities.results.DataResult;
import com.miro.dibt.core.utilities.results.IResult;
import com.miro.dibt.core.utilities.results.SuccesDataResult;
import com.miro.dibt.core.utilities.results.SuccessResult;
import com.miro.dibt.dataAccess.abstracts.ICommentDao;
import com.miro.dibt.entities.concretes.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentManager implements ICommentSerive {
    private final ICommentDao iCommentDao;

    @Override
    public DataResult<List<Comment>> getAll() {
        return new SuccesDataResult(iCommentDao.findAll(), Messagess.commentListed);
    }

    @Override
    public IResult add(Comment comment) {
        iCommentDao.save(comment);
        return new SuccessResult(Messagess.commentSave);
    }

    @Override
    public IResult update(Comment comment) {
        iCommentDao.save(comment);
        return new SuccessResult(Messagess.commentUpdate);
    }

    @Override
    public IResult delete(Comment comment) {
        iCommentDao.delete(comment);
        return new SuccessResult(Messagess.commentDelete);
    }
}
