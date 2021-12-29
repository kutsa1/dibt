package com.miro.dibt.repo.abstracts;

import com.miro.dibt.entities.concretes.CommentLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentLikeDao extends JpaRepository<CommentLike,Integer> {
}
