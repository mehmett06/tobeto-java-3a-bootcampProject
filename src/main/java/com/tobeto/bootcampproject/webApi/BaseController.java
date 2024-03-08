package com.tobeto.bootcampproject.webApi;

import com.tobeto.bootcampproject.core.utilities.results.DataResults;
import com.tobeto.bootcampproject.core.utilities.results.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
    public ResponseEntity<?> handleDataResult(DataResults<?> dataResults) {
        if (dataResults.isSuccess())
            return ResponseEntity.ok(dataResults);

        return ResponseEntity.badRequest().body(dataResults);
    }

    public ResponseEntity<?> handleResult(Result result) {
        if (result.isSuccess()) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
}
