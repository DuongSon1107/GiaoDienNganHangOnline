package JSONHandling;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.io.File;
import java.util.List;

public class JSONWriter {
    File file;
    List list;

    public JSONWriter(File file, List list) {
        this.file = file;
        this.list = list;
    }

    public void jsonWrite() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            // Write Java list info a JSON file.
            mapper.writeValue(file, list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}


