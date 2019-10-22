package com.javagda25.cloud.sentencefiller.controller;

import com.javagda25.cloud.sentencefiller.api.Randomizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FillingController {

    @Autowired
    private Randomizer randomizer;

    @GetMapping("/fill")
    public String fill (@RequestParam(name = "sentence", required = false) String sentence) {
        if (sentence!=null) {
            while (sentence.contains("!!!")) {
                sentence = sentence.replaceFirst("!!!", getRandomNumber());
            } while (sentence.contains("@@@")) {
                sentence = sentence.replaceFirst("@@@", getRandomWord());
            }
            return sentence;
        }
        return "Give a sentence dickhead!";
    }

    private String getRandomWord() {
        return randomizer.randomWord();
    }

    private String getRandomNumber() {
        return randomizer.randomNumber();
    }
}