package com.example.demo;

import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class WeatherService {

    private final WeatherRepository repository;

    public WeatherService(WeatherRepository repository) {
        this.repository = repository;
    }

    public WeatherRecord getWeather(String pincode, LocalDate date) {

        return repository.findByPincodeAndDate(pincode, date)
                .orElseGet(() -> {

                    WeatherRecord record = new WeatherRecord();

                    record.setPincode(pincode);
                    record.setLatitude(18.5204);
                    record.setLongitude(73.8567);
                    record.setDate(date);
                    record.setTemperature(30.0);
                    record.setDescription("Sunny");

                    return repository.save(record);
                });
    }
}


