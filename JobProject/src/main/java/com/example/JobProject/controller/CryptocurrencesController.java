package com.example.JobProject.controller;

import com.example.JobProject.controller.payload.NewCryptoCurrencyPayload;


import com.example.JobProject.entity.CryptocurrencyOld;

import com.example.JobProject.service.CryptocurrencyService;
import com.google.gson.Gson;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.google.gson.Gson;
@Controller
@RequiredArgsConstructor
@RequestMapping("catalogue/cryptocurrency") // общий адресс
public class CryptocurrencesController {

    private final CryptocurrencyService cryptocurrencyService;


    @GetMapping ("cryptocurrences")
    public String getCryptocurrencesList(Model model) {
        model.addAttribute("cryptocurrences", this.cryptocurrencyService.getAllCryptocurrencies());
        return "catalogue/cryptocurrency/list";

    }

    @GetMapping("create")
    public String getNewCryptocurrencyPage() {
        return "catalogue/cryptocurrency/new_cryptocurrency";
    }

    @PostMapping("create")
    public String createCryptocurrency(@Valid NewCryptoCurrencyPayload payload,
                                       BindingResult bindingResult,
                                       Model model) { // расширение Errors. Если есть ошибки, они передаются в Model , как и веденная информация пользователем, что бы ее не утратить
        if (bindingResult.hasErrors()){
            model.addAttribute("payload", payload);
            model.addAttribute("errors", bindingResult.getAllErrors().stream()
                    .map(ObjectError::getDefaultMessage)
                    .toList());
            return "catalogue/cryptocurrency/new_cryptocurrency"; // возврат на страницу создания
        }
        else {
            CryptocurrencyOld cryptocurrency = this.cryptocurrencyService.createCurrency(payload.title(), payload.description()); //создание с помощью payload
            return "redirect:/catalogue/cryptocurrency/%d".formatted(cryptocurrency.getId()); // перенаправление на страницу крипты
        }
    }


}
