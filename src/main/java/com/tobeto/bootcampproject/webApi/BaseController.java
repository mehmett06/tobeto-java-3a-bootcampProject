package com.tobeto.bootcampproject.webApi;

import com.tobeto.bootcampproject.core.utilities.results.DataResults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
    public ResponseEntity<?> handleDataResult(DataResults<?> dataResults) {
        if (dataResults.isSuccess())
            return ResponseEntity.ok(dataResults);

        return ResponseEntity.badRequest().body(dataResults);
    }
}
