package com.example.JobProject.service.impl;

import com.example.JobProject.entity.NewsSource;
import com.example.JobProject.exception.AlreadyExistsException;
import com.example.JobProject.exception.NotFoundException;
import com.example.JobProject.repository.NewsSourceRepository;
import com.example.JobProject.service.NewsSourceService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsSourceServiceImpl implements NewsSourceService {

    private final NewsSourceRepository newsSourceRepository;

    @Transactional(readOnly = true)
    public NewsSource findByName(String name) {
        return newsSourceRepository
                .findByName(name)
                .orElseThrow(()-> new NotFoundException("NewsSource with name %s not found".formatted(name)));
    }

    @Transactional(readOnly = true)
    public NewsSource findById(Long id) {
        return newsSourceRepository
                .findById(id)
                .orElseThrow(()-> new NotFoundException("NewsSource with id %d not found".formatted(id)));
    }

    @Transactional(readOnly = true)
    public NewsSource findByDomen(String domen) {
        return newsSourceRepository
                .findByDomen(domen)
                .orElseThrow(()-> new NotFoundException("NewsSource with domen %s not found".formatted(domen)));
    }

    @Transactional(readOnly = true)
    public List<NewsSource> findAll() {
        return newsSourceRepository.findAll();
    }

    @Transactional
    public NewsSource save(NewsSource newsSource) {
        String newsSourceName = newsSource.getName();
        if (newsSourceRepository.findByName(newsSourceName)!=null){
            throw new AlreadyExistsException("NewsSource with name %s already exists".formatted(newsSourceName));
        }
        String newsSourceDomen = newsSource.getDomen();
        if (newsSourceRepository.findByDomen(newsSourceDomen)!=null){
            throw new AlreadyExistsException("NewsSource with domen %s already exists".formatted(newsSourceDomen));
        }
        newsSourceRepository.save(newsSource);
        return newsSource;
    }

    @Transactional
    public void delete(Long id) {
        newsSourceRepository.deleteById(id);
    }

}
