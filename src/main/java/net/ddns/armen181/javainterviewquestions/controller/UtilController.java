package net.ddns.armen181.javainterviewquestions.controller;

import net.ddns.armen181.javainterviewquestions.service.HTMLParsService;
import net.ddns.armen181.javainterviewquestions.util.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UtilController {

    private HTMLParsService htmlParsService;

    public UtilController(HTMLParsService htmlParsService) {

        this.htmlParsService = htmlParsService;

    }

    @GetMapping("/")
    public Question isUser(@RequestHeader int id) {
        return htmlParsService.findQuestions("/home/armen-pc/Desktop/1000_Q/Top-1000-Java-converted.html").get(id);

    }
}
