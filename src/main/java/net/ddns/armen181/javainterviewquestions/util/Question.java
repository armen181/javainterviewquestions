package net.ddns.armen181.javainterviewquestions.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Question {

private String title;
private String body;

    public Question(String title, String body) {
        this.title = title;
        this.body = body;
    }

    @Override
    public String toString() {
        return "Question{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
