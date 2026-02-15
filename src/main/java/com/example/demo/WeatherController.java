package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public WeatherRecord getWeather(
            @RequestParam String pincode,
            @RequestParam String date) {

        return weatherService.getWeather(pincode, LocalDate.parse(date));
    }
}

