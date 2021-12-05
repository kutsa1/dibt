package com.miro.dibt.dataAccess.abstracts;

import com.miro.dibt.entities.concretes.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReportDao extends JpaRepository<Report, Integer> {
}
