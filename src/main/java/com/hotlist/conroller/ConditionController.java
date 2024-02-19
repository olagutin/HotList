package com.hotlist.conroller;

import com.hotlist.entity.UserEntity;
import com.hotlist.exception.UserAlreadyExistException;
import com.hotlist.exception.UserNotFoundException;
import com.hotlist.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/condition")
public class ConditionController {

    @GetMapping
    public ResponseEntity getCondition() {
        try {
            return ResponseEntity.ok("The service is available");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error occurred");
        }
    }
}
