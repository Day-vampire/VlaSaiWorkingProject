package com.example.JobProject.service.impl;

import com.example.JobProject.dto.WalletTransactionDto;
import com.example.JobProject.entity.WalletTransaction;
import com.example.JobProject.mapper.WalletTransactionMapper;
import com.example.JobProject.repository.WalletTransactionRepository;
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
class WalletTransactionServiceImplTest {

    @Mock
    private WalletTransactionRepository walletTransactionRepository;

    @Mock
    private WalletTransactionMapper walletTransactionMapper;

    @InjectMocks
    private WalletTransactionServiceImpl walletTransactionService;

    private WalletTransaction walletTransaction;
    private WalletTransactionDto walletTransactionDto;

    @BeforeEach
    void setUp() {
        walletTransaction = new WalletTransaction();
        walletTransaction.setId(1L);

        walletTransaction.setDateOfTransaction(new Date());
        walletTransaction.setType("DEPOSIT");


        walletTransactionDto = new WalletTransactionDto();
        walletTransactionDto.setId(1L);
        walletTransactionDto.setCryptocurrencyWalletId(123L);
        walletTransactionDto.setDateOfTransaction(new Date());
        walletTransactionDto.setType("DEPOSIT");

    }

    @Test
    void testFindAll() {
        // Arrange
        when(walletTransactionRepository.findAll()).thenReturn(List.of(walletTransaction));
        when(walletTransactionMapper.toWalletTransactionDto(walletTransaction)).thenReturn(walletTransactionDto);

        // Act
        List<WalletTransactionDto> result = walletTransactionService.findAll();

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("DEPOSIT", result.get(0).getType());
        verify(walletTransactionRepository, times(1)).findAll();
    }

    @Test
    void testFindById() {
        // Arrange
        when(walletTransactionRepository.findById(1L)).thenReturn(Optional.of(walletTransaction));
        when(walletTransactionMapper.toWalletTransactionDto(walletTransaction)).thenReturn(walletTransactionDto);

        // Act
        WalletTransactionDto result = walletTransactionService.findById(1L);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("DEPOSIT", result.getType());
        verify(walletTransactionRepository, times(1)).findById(1L);
    }

    @Test
    void testFindById_NotFound() {
        // Arrange
        when(walletTransactionRepository.findById(1L)).thenReturn(Optional.empty());

        // Act
        WalletTransactionDto result = walletTransactionService.findById(1L);

        // Assert
        assertNull(result);
        verify(walletTransactionRepository, times(1)).findById(1L);
    }

    @Test
    void testFindByDateOfTransactionAndCryptocurrencyWalletId() {
        // Arrange
        Date date = new Date();
        when(walletTransactionRepository.findByDateOfTransactionAndCryptocurrencyWalletId(date, 123L))
                .thenReturn(List.of(walletTransaction));
        when(walletTransactionMapper.toWalletTransactionDto(walletTransaction)).thenReturn(walletTransactionDto);

        // Act
        List<WalletTransactionDto> result = walletTransactionService.findByDateOfTransactionAndCryptocurrencyWalletId(date, 123L);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("DEPOSIT", result.get(0).getType());
        verify(walletTransactionRepository, times(1)).findByDateOfTransactionAndCryptocurrencyWalletId(date, 123L);
    }

    @Test
    void testFindByDateOfTransactionAndCryptocurrencyWalletId_Empty() {
        // Arrange
        Date date = new Date();
        when(walletTransactionRepository.findByDateOfTransactionAndCryptocurrencyWalletId(date, 123L))
                .thenReturn(List.of());

        // Act
        List<WalletTransactionDto> result = walletTransactionService.findByDateOfTransactionAndCryptocurrencyWalletId(date, 123L);

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(walletTransactionRepository, times(1)).findByDateOfTransactionAndCryptocurrencyWalletId(date, 123L);
    }

    @Test
    void testFindByCryptocurrencyWalletId() {
        // Arrange
        when(walletTransactionRepository.findByCryptocurrencyWalletId(123L)).thenReturn(List.of(walletTransaction));
        when(walletTransactionMapper.toWalletTransactionDto(walletTransaction)).thenReturn(walletTransactionDto);

        // Act
        List<WalletTransactionDto> result = walletTransactionService.findByCryptocurrencyWalletId(123L);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("DEPOSIT", result.get(0).getType());
        verify(walletTransactionRepository, times(1)).findByCryptocurrencyWalletId(123L);
    }

    @Test
    void testFindByCryptocurrencyWalletId_Empty() {
        // Arrange
        when(walletTransactionRepository.findByCryptocurrencyWalletId(123L)).thenReturn(List.of());

        // Act
        List<WalletTransactionDto> result = walletTransactionService.findByCryptocurrencyWalletId(123L);

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(walletTransactionRepository, times(1)).findByCryptocurrencyWalletId(123L);
    }

    @Test
    void testFindByType() {
        // Arrange
        when(walletTransactionRepository.findByType("DEPOSIT")).thenReturn(List.of(walletTransaction));
        when(walletTransactionMapper.toWalletTransactionDto(walletTransaction)).thenReturn(walletTransactionDto);

        // Act
        List<WalletTransactionDto> result = walletTransactionService.findByType("DEPOSIT");

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("DEPOSIT", result.get(0).getType());
        verify(walletTransactionRepository, times(1)).findByType("DEPOSIT");
    }

    @Test
    void testFindByType_Empty() {
        // Arrange
        when(walletTransactionRepository.findByType("DEPOSIT")).thenReturn(List.of());

        // Act
        List<WalletTransactionDto> result = walletTransactionService.findByType("DEPOSIT");

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(walletTransactionRepository, times(1)).findByType("DEPOSIT");
    }

    @Test
    void testFindAll_EmptyList() {
        // Arrange
        when(walletTransactionRepository.findAll()).thenReturn(List.of());

        // Act
        List<WalletTransactionDto> result = walletTransactionService.findAll();

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(walletTransactionRepository, times(1)).findAll();
    }

    @Test
    void testMapperCalledCorrectly() {
        // Arrange
        when(walletTransactionRepository.findAll()).thenReturn(List.of(walletTransaction));
        when(walletTransactionMapper.toWalletTransactionDto(walletTransaction)).thenReturn(walletTransactionDto);

        // Act
        walletTransactionService.findAll();

        // Assert
        verify(walletTransactionMapper, times(1)).toWalletTransactionDto(walletTransaction);
    }
}
