package com.example.adminpage.controller.api;

import com.example.adminpage.ifs.CrudInterface;
import com.example.adminpage.moel.network.Header;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface {


    @Override
    @PostMapping("") //api/user
    public Header create() {
        return null;
    }

    @Override
    @GetMapping("{id}")//api//user//{id}
    public Header read(@PathVariable(name="id") Long id) {
        return null;
    }

    @Override
    @PutMapping("")
    public Header update() {
        return null;
    }

    @Override
    @DeleteMapping("{id}")
    public Header delete(@PathVariable(name="id") Long id) {
        return null;
    }
}
