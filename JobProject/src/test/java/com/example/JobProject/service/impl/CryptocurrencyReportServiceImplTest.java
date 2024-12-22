package com.example.JobProject.service.impl;

import com.example.JobProject.dto.CryptocurrencyReportDto;
import com.example.JobProject.entity.CryptocurrencyReport;
import com.example.JobProject.mapper.CryptocurrencyReportMapper;

import com.example.JobProject.repository.CryptocurrencyReportRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CryptocurrencyReportServiceImplTest {

    @Mock
    private CryptocurrencyReportRepository cryptocurrencyReportRepository;

    @Mock
    private CryptocurrencyReportMapper cryptocurrencyReportMapper;

    @InjectMocks
    private CryptocurrencyReportServiceImpl cryptocurrencyReportService;

    private CryptocurrencyReport cryptocurrencyReport;
    private CryptocurrencyReportDto cryptocurrencyReportDto;

    @BeforeEach
    void setUp() {
        cryptocurrencyReport = new CryptocurrencyReport();
        cryptocurrencyReport.setId(1L);

        cryptocurrencyReport.setReportName("Report 1");
        cryptocurrencyReport.setCryptocurrencyId("BTC");
        cryptocurrencyReport.setReportDate(new Date());

        cryptocurrencyReportDto = new CryptocurrencyReportDto();
        cryptocurrencyReportDto.setId(1L);
        cryptocurrencyReportDto.setUserId(123L);
        cryptocurrencyReportDto.setReportName("Report 1");
        cryptocurrencyReportDto.setCryptocurrencyId("BTC");
        cryptocurrencyReportDto.setReportDate(new Date());
    }

    @Test
    void testFindByUserId() {
        when(cryptocurrencyReportRepository.findByUserId(123L)).thenReturn(List.of(cryptocurrencyReport));
        when(cryptocurrencyReportMapper.toCryptocurrencyReportDto(cryptocurrencyReport)).thenReturn(cryptocurrencyReportDto);

        List<CryptocurrencyReportDto> result = cryptocurrencyReportService.findByUserId(123L);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Report 1", result.get(0).getReportName());
        verify(cryptocurrencyReportRepository, times(1)).findByUserId(123L);
    }

    @Test
    void testFindByCryptocurrencyReportTypeIdAndUserId() {
        when(cryptocurrencyReportRepository.findByCryptocurrencyReportTypeIdAndUserId(1L, 123L)).thenReturn(List.of(cryptocurrencyReport));
        when(cryptocurrencyReportMapper.toCryptocurrencyReportDto(cryptocurrencyReport)).thenReturn(cryptocurrencyReportDto);

        List<CryptocurrencyReportDto> result = cryptocurrencyReportService.findByCryptocurrencyReportTypeIdAndUserId(1L, 123L);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Report 1", result.get(0).getReportName());
        verify(cryptocurrencyReportRepository, times(1)).findByCryptocurrencyReportTypeIdAndUserId(1L, 123L);
    }

    @Test
    void testFindByCryptocurrencyIdAndUserId() {
        when(cryptocurrencyReportRepository.findByCryptocurrencyIdAndUserId("BTC", 123L)).thenReturn(List.of(cryptocurrencyReport));
        when(cryptocurrencyReportMapper.toCryptocurrencyReportDto(cryptocurrencyReport)).thenReturn(cryptocurrencyReportDto);

        List<CryptocurrencyReportDto> result = cryptocurrencyReportService.findByCryptocurrencyIdAndUserId("BTC", 123L);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Report 1", result.get(0).getReportName());
        verify(cryptocurrencyReportRepository, times(1)).findByCryptocurrencyIdAndUserId("BTC", 123L);
    }

    @Test
    void testFindByReportDateAndUserId() {
        Date reportDate = new Date();
        when(cryptocurrencyReportRepository.findByReportDateAndUserId(reportDate, 123L)).thenReturn(List.of(cryptocurrencyReport));
        when(cryptocurrencyReportMapper.toCryptocurrencyReportDto(cryptocurrencyReport)).thenReturn(cryptocurrencyReportDto);

        List<CryptocurrencyReportDto> result = cryptocurrencyReportService.findByReportDateAndUserId(reportDate, 123L);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Report 1", result.get(0).getReportName());
        verify(cryptocurrencyReportRepository, times(1)).findByReportDateAndUserId(reportDate, 123L);
    }

    @Test
    void testFindByReportNameAndUserId() {
        when(cryptocurrencyReportRepository.findByReportNameAndUserId("Report 1", 123L)).thenReturn(Optional.of(cryptocurrencyReport));
        when(cryptocurrencyReportMapper.toCryptocurrencyReportDto(cryptocurrencyReport)).thenReturn(cryptocurrencyReportDto);

        CryptocurrencyReportDto result = cryptocurrencyReportService.findByReportNameAndUserId("Report 1", 123L);

        assertNotNull(result);
        assertEquals("Report 1", result.getReportName());
        verify(cryptocurrencyReportRepository, times(1)).findByReportNameAndUserId("Report 1", 123L);
    }

    @Test
    void testFindByReportNameAndUserId_NotFound() {
        when(cryptocurrencyReportRepository.findByReportNameAndUserId("Report 2", 123L)).thenReturn(Optional.empty());

        CryptocurrencyReportDto result = cryptocurrencyReportService.findByReportNameAndUserId("Report 2", 123L);

        assertNull(result);
        verify(cryptocurrencyReportRepository, times(1)).findByReportNameAndUserId("Report 2", 123L);
    }

    // Новый тест, проверка пустого списка для findByUserId
    @Test
    void testFindByUserId_EmptyList() {
        when(cryptocurrencyReportRepository.findByUserId(123L)).thenReturn(List.of());

        List<CryptocurrencyReportDto> result = cryptocurrencyReportService.findByUserId(123L);

        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(cryptocurrencyReportRepository, times(1)).findByUserId(123L);
    }

    // Новый тест, проверка вызова mappers'а
    @Test
    void testMapperCalledCorrectly() {
        when(cryptocurrencyReportRepository.findByUserId(123L)).thenReturn(List.of(cryptocurrencyReport));
        when(cryptocurrencyReportMapper.toCryptocurrencyReportDto(cryptocurrencyReport)).thenReturn(cryptocurrencyReportDto);

        cryptocurrencyReportService.findByUserId(123L);

        verify(cryptocurrencyReportMapper, times(1)).toCryptocurrencyReportDto(cryptocurrencyReport);
    }

    // Новый тест, проверка findByCryptocurrencyReportTypeIdAndUserId с пустым результатом
    @Test
    void testFindByCryptocurrencyReportTypeIdAndUserId_EmptyResult() {
        when(cryptocurrencyReportRepository.findByCryptocurrencyReportTypeIdAndUserId(1L, 123L)).thenReturn(List.of());

        List<CryptocurrencyReportDto> result = cryptocurrencyReportService.findByCryptocurrencyReportTypeIdAndUserId(1L, 123L);

        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(cryptocurrencyReportRepository, times(1)).findByCryptocurrencyReportTypeIdAndUserId(1L, 123L);
    }

    // Новый тест, проверка findByCryptocurrencyIdAndUserId с пустым результатом
    @Test
    void testFindByCryptocurrencyIdAndUserId_EmptyResult() {
        when(cryptocurrencyReportRepository.findByCryptocurrencyIdAndUserId("BTC", 123L)).thenReturn(List.of());

        List<CryptocurrencyReportDto> result = cryptocurrencyReportService.findByCryptocurrencyIdAndUserId("BTC", 123L);

        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(cryptocurrencyReportRepository, times(1)).findByCryptocurrencyIdAndUserId("BTC", 123L);
    }

    // Новый тест, проверка findByReportDateAndUserId с пустым результатом
    @Test
    void testFindByReportDateAndUserId_EmptyResult() {
        Date reportDate = new Date();
        when(cryptocurrencyReportRepository.findByReportDateAndUserId(reportDate, 123L)).thenReturn(List.of());

        List<CryptocurrencyReportDto> result = cryptocurrencyReportService.findByReportDateAndUserId(reportDate, 123L);

        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(cryptocurrencyReportRepository, times(1)).findByReportDateAndUserId(reportDate, 123L);
    }

    // Новый тест, проверка, что метод findByReportNameAndUserId вернет null, если ничего не найдено
}