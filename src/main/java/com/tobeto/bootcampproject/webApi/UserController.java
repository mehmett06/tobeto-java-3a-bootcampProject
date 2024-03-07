package com.tobeto.bootcampproject.webApi;

import com.tobeto.bootcampproject.business.abstracts.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController extends BaseController{
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> getAllUsers(

    ){
        return handleDataResult(userService.getAll());
    }

    @GetMapping("/getUserByEmail/{email}")
    public ResponseEntity<?> getUserByEmail(
            @PathVariable String email
    ){
        return handleDataResult(userService.getUserByEmail(email));
    }

}
