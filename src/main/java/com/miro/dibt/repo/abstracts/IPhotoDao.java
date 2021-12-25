package com.miro.dibt.repo.abstracts;

import com.miro.dibt.entities.Dtos.PhotoWithReportDetailDto;
import com.miro.dibt.entities.concretes.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPhotoDao extends JpaRepository<Photo,Integer> {


    @Query("select new com.miro.dibt.entities.Dtos.PhotoWithReportDetailDto(r.id,p.id,p.imgUrl) from Report r inner join r.photos p")
    List<PhotoWithReportDetailDto> getAllPhotoWithReportDetailDto();
}
