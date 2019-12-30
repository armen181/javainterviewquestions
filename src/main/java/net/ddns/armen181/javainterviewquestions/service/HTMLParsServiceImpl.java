package net.ddns.armen181.javainterviewquestions.service;

import net.ddns.armen181.javainterviewquestions.util.Question;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

@Service
public class HTMLParsServiceImpl implements HTMLParsService {

    private List<Question> list = new ArrayList<>();


    @Override
    public String readStringFromFile(String path) throws IOException {
        String data = "Error Reading";
        Resource resource = new ClassPathResource(path);
        data = asString(resource);
        return data;
    }


    @Override
    public List<Question> findQuestions(String paths) {
        if (list.isEmpty()) {
            try {
                StringBuilder stringBuilder = new StringBuilder(readStringFromFile(paths));
                list = new ArrayList<>();
                boolean status = false;
                int start = 0;
                int end = 0;
                while (!status) {
                    // === Finding Question ===
                    start = stringBuilder.indexOf("<h1 style=\"page-break-before:always; \"", end);
                    end = stringBuilder.indexOf("<h1 style=\"page-break-before:always; \"", start + 1);
                    if (start < 0 || end < 0) {
                        status = true;
                    } else {
                        StringBuilder sB = new StringBuilder(stringBuilder.substring(start + 39, end));
                        list.add(new Question(sB.substring(sB.indexOf(">") + 1, sB.indexOf("</")), sB.substring(sB.indexOf("\n"))));
                    }
                }
                System.out.println("HTML file parsed");
                return list;

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error reading HTML file");
                return null;
            }
        } else
            return list;


    }

    public static String asString(Resource resource) {
        try (Reader reader = new InputStreamReader(resource.getInputStream(), UTF_8)) {
            return FileCopyUtils.copyToString(reader);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
