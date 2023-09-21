package JSONHandling;

import Account.Account;
import AccountInfo.AccountInfo;

import java.util.ArrayList;
import java.util.List;

public class AccountInfoToAccount {
    List<AccountInfo> list;
    public AccountInfoToAccount(List<AccountInfo> list) {
        this.list = list;
    }

    /** Make a new AccountInfo list from Account list */
    public List<Account> listHandling() {
        List<Account> accountList = new ArrayList<>();
        for (AccountInfo info: list) {
            Account account = new Account(info);
            accountList.add(account);
        }
        return accountList;
    }
}
