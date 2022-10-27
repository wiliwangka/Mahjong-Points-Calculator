package persistence;

//reference: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

import org.json.*;

// Represents a reader that reads workroom from JSON data stored in file
public class HandReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public HandReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it;

    public ArrayList<String> read() throws IOException {
        String jsonData = readFile(source);
//        JSONObject jsonObject = new JSONObject(jsonData);
//        return parseWorkRoom(jsonObject);

        ArrayList<String> list = new ArrayList<String>();
        JSONArray jsonArray = new JSONArray(jsonData);
        if (jsonArray != null) {
            int len = jsonArray.length();
            for (int i = 0; i < len; i++) {
                list.add(jsonArray.get(i).toString());
            }
        }
        return list;
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }
}

