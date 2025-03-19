package com.example.comparateur.test.controller;

import com.example.comparateur.test.entity.Test;
import com.example.comparateur.test.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {


    private final TestService ts;

    // Create a TypeMobile
    @PostMapping("/create")
    public Test createTest(@RequestBody Test  test) {
        return ts.saveTest(test);
    }


}
