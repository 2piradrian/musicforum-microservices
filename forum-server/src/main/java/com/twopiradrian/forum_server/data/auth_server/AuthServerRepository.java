package com.twopiradrian.forum_server.data.auth_server;

import com.twopiradrian.entity.TokenClaims;
import com.twopiradrian.entity.User;
import com.twopiradrian.forum_server.config.beans.LoadBalancerConfiguration;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Optional;

@FeignClient(name = "auth-server")
@LoadBalancerClient(name = "auth-server", configuration = LoadBalancerConfiguration.class)
public interface AuthServerRepository {

    @GetMapping("/auth-server/api/users/auth")
    Optional<TokenClaims> auth (@RequestHeader("Authorization") String token);

    @GetMapping("/auth-server/api/users/get-by-id/{userId}")
    Optional<User> getById (@PathVariable String userId);

}
