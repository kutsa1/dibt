package com.miro.dibt.api.controller;

import com.miro.dibt.business.abstracts.IReportService;
import com.miro.dibt.core.api.ControllerBase;
import com.miro.dibt.entities.concretes.Report;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/reports")
public class Reportcontroller extends ControllerBase<Report, IReportService> {

    IReportService iReportService;

    public Reportcontroller(IReportService iReportService) {
        super(iReportService);
        this.iReportService = iReportService;
    }
}
