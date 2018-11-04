package net.ddns.armen181.javainterviewquestions.service;

import net.ddns.armen181.javainterviewquestions.util.Question;

import java.io.IOException;
import java.util.List;

public interface HTMLParsService {
    String readStringFromFile(String path) throws IOException;
    List<Question> findQuestions(String data);
}
