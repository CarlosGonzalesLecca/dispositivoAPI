package com.zegel.serviceRestDispositivo.Rest;

import com.zegel.serviceRestDispositivo.Business.UserBusiness;
import com.zegel.serviceRestDispositivo.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")

public class UserRest {
    @Autowired
    private UserBusiness userBusiness;

    @PostMapping("/user/create")
    public User createUser(@RequestBody User user) {
        try {
            return userBusiness.createUser(user);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No es posible guardar los datos", e);
        }
    }
}
