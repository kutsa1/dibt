package com.miro.dibt.business.concretes;

import com.miro.dibt.business.abstracts.IReportService;
import com.miro.dibt.business.tools.Messages;
import com.miro.dibt.core.utilities.results.DataResult;
import com.miro.dibt.core.utilities.results.IResult;
import com.miro.dibt.core.utilities.results.SuccesDataResult;
import com.miro.dibt.core.utilities.results.SuccessResult;
import com.miro.dibt.repo.abstracts.IReportDao;
import com.miro.dibt.entities.concretes.Report;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportManager implements IReportService {
    private final IReportDao iReportDao;


    @Override
    public DataResult<List<Report>> getAll() {
        return new SuccesDataResult(iReportDao.findAll(), Messages.reportListed);
    }

    @Override
    public IResult add(Report report) {
        report.setDateOfReport(LocalDateTime.now());
        iReportDao.save(report);
        return new SuccessResult(Messages.reportSave);
    }

    @Override
    public IResult update(Report report) {
        iReportDao.save(report);
        return new SuccessResult(Messages.reportUpdate);
    }

    @Override
    public IResult delete(Report report) {
        iReportDao.delete(report);
        return new SuccessResult(Messages.reportDelete);
    }

    @Override
    public DataResult<Report> getById(Integer id) {
        return null;
    }
}
