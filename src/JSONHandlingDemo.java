import AccountInfo.AccountInfo;
import JSONHandling.JSONReader;

import java.io.File;
import java.util.List;

public class JSONHandlingDemo {

    /** JSONWriter demonstration */
    public static void main(String[] args) {
        File file = new File("Accounts.json");
        List<AccountInfo> infoList;
        JSONReader jsonReader = new JSONReader(file);
        infoList = jsonReader.jsonRead();

        for (AccountInfo info: infoList) {
            System.out.println(info.accountNumber + ": " + info.username);
        }
    }


    /** JSONWriter demonstration */
//    public static void main(String[] args) {
//        List<AccountInfo> infoList = new ArrayList<>();
//        for (int i = 0; i < 100; i++) {
//            AccountInfo info = new AccountInfo();
//            info.accountNumber = i;
//            info.username = "LMAO Long Long" + i;
//            infoList.add(info);
//        }
//        File file = new File("Accounts.json");
//        JSONWriter jsonWriter = new JSONWriter(file, infoList);
//        jsonWriter.jsonWrite();
//    }
}
