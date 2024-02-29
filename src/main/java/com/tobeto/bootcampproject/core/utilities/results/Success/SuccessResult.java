package com.tobeto.bootcampproject.core.utilities.results.Success;

import com.tobeto.bootcampproject.core.utilities.results.Result;

public class SuccessResult extends Result {
    public SuccessResult() {
        super(true);
    }

    public SuccessResult(String message) {
        super(true, message);
    }
}
