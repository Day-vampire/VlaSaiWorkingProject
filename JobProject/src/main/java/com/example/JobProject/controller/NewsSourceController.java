package com.example.JobProject.controller;

import com.example.JobProject.aspect.MyAnnotationForLog;
import com.example.JobProject.entity.NewsSource;
import com.example.JobProject.service.NewsSourceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("news-sources")
@PreAuthorize("hasAuthority('ROLE_USER')")
public class NewsSourceController {

        private final NewsSourceService newsSourceService;

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        @MyAnnotationForLog
        public NewsSource save(@RequestBody NewsSource newsSource) {
            return newsSourceService.save(newsSource);
        }

        @DeleteMapping("/{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void delete(@PathVariable Long id) {
            newsSourceService.delete(id);
        }

        @GetMapping
        @ResponseStatus(HttpStatus.OK)
        @MyAnnotationForLog
        public List<NewsSource> findAll() {
            return newsSourceService.findAll();
        }

        @GetMapping ("/{id}")
        @ResponseStatus(HttpStatus.OK)
        @MyAnnotationForLog
        public NewsSource findById(@PathVariable Long id) {
            return newsSourceService.findById(id);
        }

        @GetMapping ("/name/{name}")
        @ResponseStatus(HttpStatus.OK)
        @MyAnnotationForLog
        public NewsSource findByName(@PathVariable String name) {
            return newsSourceService.findByName(name);
        }

        @GetMapping ("/domen/{domen}")
        @ResponseStatus(HttpStatus.OK)
        @MyAnnotationForLog
        public NewsSource findByDomen(@PathVariable String name) {
            return newsSourceService.findByDomen(name);
        }

    }
