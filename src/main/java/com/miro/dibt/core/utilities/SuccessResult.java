package com.miro.dibt.core.utilities;

public class SuccessResult extends Result {
    public SuccessResult(String message) {

        super(true, message);
    }

    public SuccessResult() {
        super(true);
    }
}
