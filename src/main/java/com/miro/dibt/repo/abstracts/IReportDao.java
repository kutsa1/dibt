package com.miro.dibt.repo.abstracts;

import com.miro.dibt.entities.Dtos.ReportDetailDto;
import com.miro.dibt.entities.concretes.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IReportDao extends JpaRepository<Report, Integer> {

    @Query("select new com.miro.dibt.entities.Dtos.ReportDetailDto(r.id,r.text,u.username,c.categoryName,r.dateOfReport ) from Report r join r.user u join r.category c where r.status = true ")
    List<ReportDetailDto> getAllReportDetailDto();


}