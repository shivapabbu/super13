package com.super13.accountservice.client;

import com.super13.accountservice.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "auth-service")
public interface AuthServiceClient {

    @PostMapping("/uaa/users")
    void createUser(User user);

}
