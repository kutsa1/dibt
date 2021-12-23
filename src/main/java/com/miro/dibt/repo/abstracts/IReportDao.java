package com.miro.dibt.repo.abstracts;

import com.miro.dibt.entities.Dtos.ReportDetailDto;
import com.miro.dibt.entities.concretes.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IReportDao extends JpaRepository<Report, Integer> {
    Report getById(int reportId);



    @Query("select new com.miro.dibt.entities.Dtos.ReportDetailDto(r.id,r.text,p.name,r.category.categoryName,r.dateOfReport,r.numberOfLike) from Person p inner join p.reports r ")
    List<ReportDetailDto> getAllReportDetailDto();
}