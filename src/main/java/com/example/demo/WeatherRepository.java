package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.Optional;

public interface WeatherRepository extends JpaRepository<WeatherRecord, Long> {

    Optional<WeatherRecord> findByPincodeAndDate(String pincode, LocalDate date);
}
