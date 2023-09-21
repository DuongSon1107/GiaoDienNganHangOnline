package JSONHandling;

import AccountInfo.AccountInfo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JSONReader {
    File file;
    List<AccountInfo> list;
    public JSONReader(File file) {
        this.file = file;
    }

    public List<AccountInfo> jsonRead() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<AccountInfo> infoList;
            // Read JSON file into Java object.
            TypeReference<List<AccountInfo>> listType = new TypeReference<List<AccountInfo>>() {};
            infoList = mapper.readValue(file, listType);
            for (AccountInfo info: infoList) {
                System.out.println("Username: "+ info.username);
            }
            return infoList;
//            List<AccountInfo> newList = new ArrayList<>(list);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
