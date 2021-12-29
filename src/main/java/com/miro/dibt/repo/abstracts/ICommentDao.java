package com.miro.dibt.repo.abstracts;

import com.miro.dibt.entities.Dtos.CommentDetailDto;
import com.miro.dibt.entities.concretes.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICommentDao extends JpaRepository<Comment, Integer> {


    //    @Query("select new com.miro.dibt.entities.Dtos.CommentDetailDto(c.id,r.id,u.username,c.text,c.date) from Comment c inner join c.user u inner join c.report r where r.id=:reportId")
//    List<CommentDetailDto> getAllCommentDetailDto(int reportId);
//}
    @Query("select new com.miro.dibt.entities.Dtos.CommentDetailDto(c.id,r.id,u.username,c.text,c.date) from Comment c inner join c.user u inner join c.report r")
    List<CommentDetailDto> getAllCommentDetailDto();
}
