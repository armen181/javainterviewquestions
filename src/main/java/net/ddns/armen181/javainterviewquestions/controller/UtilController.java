package net.ddns.armen181.javainterviewquestions.controller;

import net.ddns.armen181.javainterviewquestions.service.HTMLParsService;
import net.ddns.armen181.javainterviewquestions.util.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class UtilController {

    Random rand = new Random();

    private HTMLParsService htmlParsService;

    public UtilController(HTMLParsService htmlParsService) {

        this.htmlParsService = htmlParsService;

    }

    @GetMapping("/getById")
    public Question getById(@RequestHeader int id) {
        return htmlParsService.findQuestions("/home/armen-pc/Desktop/1000_Q/Top-1000-Java-converted.html").get(id);

    }
    @GetMapping("/getByRandom")
    public Question getByRandom() {

        return htmlParsService.findQuestions("/home/armen-pc/Desktop/1000_Q/Top-1000-Java-converted.html").get(
                rand.nextInt(htmlParsService.findQuestions("/home/armen-pc/Desktop/1000_Q/Top-1000-Java-converted.html").size() + 1)
        );

    }
}
