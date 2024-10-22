package com.example.JobProject.controller.payload;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record NewCryptoCurrencyPayload(
        @NotNull (message = "{catalogue.cryptocurrency.create.errors.title_is_null}")
        @Size(min = 3, max=50, message = "{catalogue.cryptocurrency.create.errors.title_size_is_invalid}") // заключается сообщение ошибки в {} для подтягивания механизма локализации, следственно они указываются в messages.properties
        String title,
        @Size(min = 3, max=1000, message = "{catalogue.cryptocurrency.create.errors.description_size_is_invalid}")
        String description){

}
