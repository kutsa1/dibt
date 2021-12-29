package com.miro.dibt.business.concretes;

import com.miro.dibt.business.abstracts.IReportService;
import com.miro.dibt.business.abstracts.IUserService;
import com.miro.dibt.business.tools.Messages;
import com.miro.dibt.core.utilities.business.BusinessRule;
import com.miro.dibt.core.utilities.results.*;
import com.miro.dibt.entities.Dtos.ReportDetailDto;
import com.miro.dibt.entities.concretes.Report;
import com.miro.dibt.repo.abstracts.IReportDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportManager implements IReportService {
    private final IReportDao iReportDao;
    IUserService iUserService;


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
        var result = iReportDao.existsById(id);
        if (result)
            return new SuccesDataResult<>(iReportDao.getById(id));
        return new ErrorDataResult<>(null);
    }

    @Override
    public DataResult<List<ReportDetailDto>> getAllReportDetailDto() {
        return new SuccesDataResult<>(iReportDao.getAllReportDetailDto());
    }

    @Override
    public IResult addReportToUser(int reportId, int userId) {
        var result = BusinessRule.run(isReportExistById(reportId), isUserExistById(userId));

        if (result != null)
            return result;
        var report = iReportDao.getById(reportId);
        var user = iUserService.getById(userId);
        report.setUser(user.getData());
        iReportDao.save(report);
        return new SuccessResult(Messages.reportAddedToUser);
    }
    private IResult isUserExistById(int userId) {
        var result = iUserService.existsById(userId);
        if (!result.isSuccess())
            return new ErrorResult(Messages.userNotFound);
        return new SuccessResult();
    }

    private IResult isReportExistById(int reportId) {
        var result = iReportDao.existsById(reportId);
        if (!result)
            return new ErrorResult(Messages.reportNotFound);
        return new SuccessResult();
    }
}
