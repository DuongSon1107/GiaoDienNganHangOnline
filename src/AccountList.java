import Account.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountList {
    private ArrayList accountList;          //Danh sách tài khoản
    private int preRollAcountNumber;
    private String insertPassword;
    private String insertPhoneNumber;
    private int insertAccounNumber;
    private int currentIndex=-1;
    private Account account;
    private int i;



    public void SetCurrentIndex(int i){
        currentIndex = i;
    }

    public int GetCurrentIndex(){
        return currentIndex;
    }

    public AccountList(){
        this.accountList = new ArrayList();
    }

    //Tạo List account
    public ArrayList<Account> CreateAccountList() {
        ArrayList<Account> accountList = new ArrayList<Account>();
        return accountList;
    }

    //Kiểm tra xem có trùng số tài khoản không, false - không trùng (lấy số này), true - trùng (thực hiện lại hàm generator)
    public boolean AccountNumberCheck(ArrayList<Account> accountList) {
        int i;
        boolean accountNumberCheck = false;
        for (i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).GetAccountNumber() == preRollAcountNumber) {
                accountNumberCheck = true;
                break;
            } else {
                accountNumberCheck = false;
            }
        }
        return accountNumberCheck;
    }

    //Nhập sđt
    public void SetInsertPhoneNumber(){
        this.insertPhoneNumber = new String();
    }

    //Nhập password
    public void SetInsertPassword(){
        this.insertPassword = new String();
    }

    //Kiểm tra sđt và mật khẩu khi đăng nhập: Nếu nhập đúng mật khẩu (truyền vào accountlist, số điện thoại và mật khẩu, true - đúng mật khẩu, false - sai mk/ko có số điện thoại tương ứng)
    public boolean PasswordCheck(ArrayList<Account> accountList, String insertPhoneNumber,String insertPassword) {
        boolean passwordCheck = false;
        for (i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).GetPhoneNumber().equals(insertPhoneNumber) == true) {
                if (accountList.get(i).GetPassword().equals(insertPassword) == true) {
                    passwordCheck = true;
                    currentIndex = i;
                    break;
                } else {
                    System.out.println("Sai mật khẩu");
                    passwordCheck = false;
                }
            }
        }
        return passwordCheck;
    }

    //Xóa tài khoản (đổi String số tài khoản người dùng nhập vào thành int rồi đưa vào hàm)
    public void DeleteAccount(ArrayList<Account> accountList){
        accountList.remove(currentIndex);
    }
}
