package com.tobeto.bootcampproject.core.utilities.results.Error;

import com.tobeto.bootcampproject.core.utilities.results.Result;

public class ErrorResult extends Result {
    public ErrorResult(){
        super(false);
    }
public ErrorResult(String message){
    super(false,message);
}
}
