package JSONHandling;

import Account.*;
import AccountInfo.AccountInfo;

import java.util.ArrayList;
import java.util.List;

public class AccountToAccountInfo {
    List<Account> list;
    public AccountToAccountInfo(List<Account> list) {
        this.list = list;
    }

    /** Make a new AccountInfo list from Account list */
    public List<AccountInfo> listHandling() {
        List<AccountInfo> infoList = new ArrayList<>();
        for (Account account: list) {
            AccountInfo info = new AccountInfo(account);
            infoList.add(info);
        }
        return infoList;
    }
}

