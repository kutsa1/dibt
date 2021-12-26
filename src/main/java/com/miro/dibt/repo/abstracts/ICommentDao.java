package com.miro.dibt.repo.abstracts;

import com.miro.dibt.entities.Dtos.CommentDetailDto;
import com.miro.dibt.entities.concretes.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICommentDao extends JpaRepository<Comment, Integer> {

    @Query("select new com.miro.dibt.entities.Dtos.CommentDetailDto(c.id,p.name,c.text,r.id,c.date,c.numberOfLike) from Person p join p.comments c join p.reports r")
    List<CommentDetailDto> getAllCommentDetailDto();
}
