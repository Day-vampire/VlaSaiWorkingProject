package com.example.JobProject.controller;

import com.example.JobProject.aspect.MyAnnotationForLog;
import com.example.JobProject.dto.NewsSubscriptionDto;
import com.example.JobProject.service.NewsSubscriptionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("newsSubscriptions")
@PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
public class NewsSubscriptionController {

    private final NewsSubscriptionService newsSubscriptionService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @MyAnnotationForLog
    public List<NewsSubscriptionDto> findAll() {
        return newsSubscriptionService.findAll();
    }

    @GetMapping("/news-source/{newsSourceId}")
    @ResponseStatus(HttpStatus.OK)
    @MyAnnotationForLog
    public List<NewsSubscriptionDto> findByNewsSourceId(@PathVariable Long newsSourceId) {
        return newsSubscriptionService.findByNewsSourceId(newsSourceId);
    }

    @GetMapping("/user/{userId}")
    @ResponseStatus(HttpStatus.OK)
    @MyAnnotationForLog
    public List<NewsSubscriptionDto> findByUserId(@PathVariable Long userId) {
        return newsSubscriptionService.findByUserId(userId);
    }

    @GetMapping("/news-source/{newsSourceId}/user/{userId}")
    @ResponseStatus(HttpStatus.OK)
    @MyAnnotationForLog
    public NewsSubscriptionDto findByNewsSourceIdAndUserId(@PathVariable Long userId, @PathVariable Long newsSourceId) {
        return newsSubscriptionService.findByNewsSourceIdAndUserId(newsSourceId,userId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @MyAnnotationForLog
    public NewsSubscriptionDto create(@RequestBody NewsSubscriptionDto newsSubscriptionDto) {
        return newsSubscriptionService.save(newsSubscriptionDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        newsSubscriptionService.delete(id);
    }
}
