package com.miro.dibt.business.abstracts;


import com.miro.dibt.core.utilities.business.IServiceBase;
import com.miro.dibt.core.utilities.results.DataResult;
import com.miro.dibt.entities.Dtos.ReportDetailDto;
import com.miro.dibt.entities.concretes.Report;

import java.util.List;

public interface IReportService extends IServiceBase<Report> {
    DataResult<List<ReportDetailDto>> getAllReportDetailDto();
}
