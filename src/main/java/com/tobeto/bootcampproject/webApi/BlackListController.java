package com.tobeto.bootcampproject.webApi;

import com.tobeto.bootcampproject.business.abstracts.BlacklistService;
import com.tobeto.bootcampproject.business.request.create.blacklist.CreateBlacklistRequest;
import com.tobeto.bootcampproject.core.aspects.logging.Loggable;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/blacklists")
@AllArgsConstructor
public class BlackListController extends BaseController {
    private BlacklistService blacklistService;

    @Loggable
    @PostMapping
    public ResponseEntity<?> add(@RequestBody @Valid CreateBlacklistRequest blacklistRequest) {
        return handleDataResult(blacklistService.create(blacklistRequest));
    }
}
