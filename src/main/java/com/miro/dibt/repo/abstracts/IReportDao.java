package com.miro.dibt.repo.abstracts;

import com.miro.dibt.entities.concretes.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReportDao extends JpaRepository<Report, Integer> {
    Report getByIdAnd(int reportId);
}