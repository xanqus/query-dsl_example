package com.ll.exam.qsl.user.controller;

import com.ll.exam.qsl.user.entity.SiteUser;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping("/user/{id}")
    public SiteUser user(@PathVariable Long id) {
        return null;
    }
}
