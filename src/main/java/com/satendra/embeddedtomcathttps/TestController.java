package com.satendra.embeddedtomcathttps;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
public class TestController {

    @GetMapping("test")
    public Collection<String> getTestResult(){
        return List.of("this is test result 1","this is test result 2");
    }

}
