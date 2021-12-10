package com.miro.dibt.core.utilities.business;

import com.miro.dibt.core.utilities.results.IResult;

import java.util.List;

public class BusinessRule {
    public static IResult run(IResult... logics) {
        for (var logic : logics) {
            if (!logic.isSuccess())
                return logic;
        }
        return null;
    }
}
