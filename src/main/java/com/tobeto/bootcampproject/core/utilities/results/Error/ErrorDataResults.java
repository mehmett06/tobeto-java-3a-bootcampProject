package com.tobeto.bootcampproject.core.utilities.results.Error;

import com.tobeto.bootcampproject.core.utilities.results.DataResults;

public class ErrorDataResults <T> extends DataResults<T> {

    public ErrorDataResults(T data,String message) {
        super(data,false,message);
    }
    public ErrorDataResults(T data) {
        super(data,false);
    }
    public ErrorDataResults(String message) {
        super(null,false,message);
    }
    public ErrorDataResults() {
        super(null,false);
    }

}
