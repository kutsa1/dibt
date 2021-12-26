package com.miro.dibt.business.abstracts;

import com.miro.dibt.core.utilities.business.IServiceBase;
import com.miro.dibt.core.utilities.results.DataResult;
import com.miro.dibt.entities.Dtos.CommentDetailDto;
import com.miro.dibt.entities.concretes.Comment;

import java.util.List;

public interface ICommentSerive extends IServiceBase<Comment> {
    DataResult<List<CommentDetailDto>> getAllCommentDetailDto();
}
