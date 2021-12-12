package com.miro.dibt.api.controller;

import com.miro.dibt.business.abstracts.IEmailService;
import com.miro.dibt.core.api.ControllerBase;
import com.miro.dibt.entities.concretes.Email;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/emails")
public class EmailController extends ControllerBase<Email, IEmailService> {

    IEmailService iEmailService;

    public EmailController(IEmailService iEmailService) {
        super(iEmailService);
        this.iEmailService = iEmailService;
    }
}
