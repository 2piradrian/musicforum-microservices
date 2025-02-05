package com.twopiradrian.report_server.data.forum_server;

import com.twopiradrian.entity.Forum;
import com.twopiradrian.report_server.config.beans.LoadBalancerConfiguration;
import com.twopiradrian.report_server.data.forum_server.dto.GetMonthlyForumsRes;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@FeignClient(name = "forum-server")
@LoadBalancerClient(name = "forum-server", configuration = LoadBalancerConfiguration.class)
public interface ForumServerRepository {

    @GetMapping("/forum-server/api/forum/get-monthly-forums")
    GetMonthlyForumsRes getMonthlyForums (
            @RequestHeader(value = "Authorization") String token,
            @RequestParam(value = "month") Integer month,
            @RequestParam(value = "year") Integer year
    );

}
