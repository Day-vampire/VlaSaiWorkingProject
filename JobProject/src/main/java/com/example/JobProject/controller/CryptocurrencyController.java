package com.example.JobProject.controller;

import com.example.JobProject.controller.payload.NewCryptoCurrencyPayload;
import com.example.JobProject.controller.payload.UpdateCryptoCurrencyPayload;

import com.example.JobProject.entity.CryptocurrencyOld;
import com.example.JobProject.service.CryptocurrencyService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;
import java.util.NoSuchElementException;

// отдельный интерфейс для редоктирования крипты и ее страницы
 // (разделение контроллеров для удобства так как тут запросы по id)
@Controller
@RequiredArgsConstructor
@RequestMapping("catalogue/cryptocurrency/{cryptocurrencyId:\\d+}")// общий адресс
public class CryptocurrencyController {

    private final CryptocurrencyService cryptocurrencyService;
    private final MessageSource messageSource; // подключение пропертиес с сообщениями для (механизм интернализации)

    @ModelAttribute("cryptocurrency") // хранение/возврат крипты по id. Уменьшает код (он одинаков для предостовления страницы продукта и его редоктирования )
    public CryptocurrencyOld cryptocurrency(@PathVariable("cryptocurrencyId") int cryptocurrencyId) {
        return this.cryptocurrencyService.findCryptocurrencyById(cryptocurrencyId).orElseThrow(()-> new NoSuchElementException("catalogue.error.cryptocurrency.not_found"));
    }

    @GetMapping
    public String getCryptocurrency(){
        return "catalogue/cryptocurrency/cryptocurrency";
    }

    @GetMapping("edit")
    public String getCryptocurrencyEditPage() {
        return "catalogue/cryptocurrency/edit";
    }
    @PostMapping("edit")
     public String updateCryptocurrency(@ModelAttribute(name="cryptocurrency",binding = false) CryptocurrencyOld cryptocurrency, @Valid UpdateCryptoCurrencyPayload payload, BindingResult bindingResult, Model model) { // payload используется как объект, который создается для передачи данных с формы
        if (bindingResult.hasErrors()){
            model.addAttribute("payload", payload);
            model.addAttribute("errors", bindingResult.getAllErrors().stream()
                    .map(ObjectError::getDefaultMessage)
                    .toList());
            return "catalogue/cryptocurrency/edit"; // возврат на страницу создания
        }
        else {
        this.cryptocurrencyService.updateCryptocurrency(cryptocurrency.getId(), payload.title(),payload.description());
        return "redirect:/catalogue/cryptocurrency/%d".formatted(cryptocurrency.getId());
    }}

    @PostMapping ("delete")
    public String deleteCryptocurrency(@ModelAttribute("cryptocurrency") CryptocurrencyOld cryptocurrency) {
        this.cryptocurrencyService.deleteCryptocurrency(cryptocurrency.getId());
        return "redirect:/catalogue/cryptocurrency/cryptocurrences";
    }
    @ExceptionHandler(NoSuchElementException.class) // отлавливатель ошибок
    public String handleNoSuchElementException(NoSuchElementException e,
                                               Model model,
                                               HttpServletResponse response,
                                               Locale locale) {
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        model.addAttribute("error",
                this.messageSource.getMessage(e.getMessage(), null, locale));
        return "errors/404";
    }

}
