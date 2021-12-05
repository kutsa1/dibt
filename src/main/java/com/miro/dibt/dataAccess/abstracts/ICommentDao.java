package com.miro.dibt.dataAccess.abstracts;

import com.miro.dibt.entities.concretes.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentDao extends JpaRepository<Comment, Integer> {
}
