package net.ddns.armen181.javainterviewquestions.service;

import net.ddns.armen181.javainterviewquestions.util.Question;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class HTMLParsServiceImpl implements HTMLParsService {


    @Override
    public String readStringFromFile(String paths) throws IOException {
        String data = "Error Reading";
        try {
            data = new String(Files.readAllBytes(Paths.get(paths)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }


    @Override
    public List<Question> findQuestions(String paths) {
        String data = "Error Reading";
        try {
            data = readStringFromFile(paths);
            StringBuilder stringBuilder = new StringBuilder(data);
            List<Question> list = new ArrayList<>();
            boolean status = false;
            int start = 0;
            int end = 0;
            while (!status) {



                // === Finding Question ===
                start = stringBuilder.indexOf("<h1 style=\"page-break-before:always; \"", end);

                end = stringBuilder.indexOf("<h1 style=\"page-break-before:always; \"", start + 1);
                if(start<0||end<0){
                    status=true;
                }else {

                    StringBuilder sB = new StringBuilder(stringBuilder.substring(start + 39, end));

                    // === Finding Title ===
                   // System.out.println(sB.substring(sB.indexOf(">") + 1, sB.indexOf("</")));

                    // === Finding Body ===
                   // System.out.println(sB.substring(sB.indexOf("\n")));

                    list.add(new Question(sB.substring(sB.indexOf(">") + 1, sB.indexOf("</")),sB.substring(sB.indexOf("\n"))));
                }

            }
            System.out.println(list.size());

            return list;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }


    }


    // == readFromInputStream ==
    private String readFromInputStream(InputStream inputStream)
            throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }
}
