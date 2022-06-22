package com.example.albumapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.net.http.HttpResponse;

public record Album (int id,
                     String title,
                     String artist,
                     BigDecimal price,
                     String image_url)
{}
