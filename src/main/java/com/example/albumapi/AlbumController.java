package com.example.albumapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AlbumController {

    Map<String, String> warningMessage = Map.of("message", "Hit the /albums endpoint to retrieve a list of albums!");
    Album[] albums = {
        new Album(1, "You, Me and an App Id", "Daprize", BigDecimal.valueOf(56.99), "https://aka.ms/albums-daprlogo"),
        new Album(2, "Seven Revision Army", "The Blue-Green Stripes", BigDecimal.valueOf(13.99), "https://aka.ms/albums-containerappslogo"),
        new Album(3, "Scale It Up", "KEDA Club", BigDecimal.valueOf(13.99), "https://aka.ms/albums-kedalogo"),
        new Album(4, "Lost in Translation", "MegaDNS", BigDecimal.valueOf(12.99),"https://aka.ms/albums-envoylogo"),
        new Album(5, "Lock Down Your Love", "V is for VNET", BigDecimal.valueOf(12.99), "https://aka.ms/albums-vnetlogo"),
        new Album(6, "Sweet Container O' Mine", "Guns N Probeses", BigDecimal.valueOf(14.99), "https://aka.ms/albums-containerappslogo")
    };

    @GetMapping("/")
    Map<String, String> warning() {
        return warningMessage;
    }

    @GetMapping("/albums")
    List<Album> albumAll() {
        return Arrays.asList(albums);
    }
}
