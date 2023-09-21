package Account;

import java.util.ArrayList;
import java.util.List;


public class AccountInfo {
    public int accountNumber;
    public String username;
    public String password;
    public String dateOfBirth;
    public String phoneNumber;
    public String address;
    public String email;
    public String cccd;
    public List transactionHistory;
    public double balance;

    public AccountInfo(Account account) {
        this.accountNumber = account.accountNumber;
        this.username = account.GetUserName();
        this.password = account.GetPassword();
        this.dateOfBirth = account.GetDateOfBirth();
        this.phoneNumber = account.GetPhoneNumber();
        this.address = account.GetAddress();
        this.email = account.GetEmail();
        this.cccd = account.GetCCCC();
        this.transactionHistory = account.GetTransactionHistory();
        this.balance = account.GetBalance();
    }
    public AccountInfo() {

    }


}
