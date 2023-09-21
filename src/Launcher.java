import Account.*;
import AccountInfo.AccountInfo;
import AccountList.AccountList;
import JSONHandling.AccountToAccountInfo;
import JSONHandling.JSONReader;
import JSONHandling.JSONWriter;
import controller.Login;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


//import Tools.Tools;


public class Launcher {
//    public static void main(String[] args){
//
//
//        AccountList accountList = new AccountList();
//        ArrayList<Account> list = accountList.CreateAccountList();
//        Account account1 = new Account("Nam","123456","27/12/2333","0965481356","sadas","asdas",
//                "021654",565);
////        System.out.println(account1.SetUserName("Hoang"));
//        account1.GetTransactionHistory().add("Tài khoản 1 ăn cướp 20000000 đô của tài khoản 2");
//        account1.GetTransactionHistory().add("tét 2");
//        System.out.println(account1.GetTransactionHistory());
//        System.out.println("check 12");
//        System.out.println(account1.accountNumber);
//        System.out.println("check 14");
////        Account account2 = new Account(Account.accountNumber,"nguoi dung 2","3","ádas","21321513","dá","dá","ád",200);
////        Account account3 = new Account(Account.accountNumber,"nguoi dung 3","2","ádas","21389713","dá","dá","ád",200);
////        list.add(account1);
////        list.add(account2);
////        list.add(account3);
//        System.out.println("check 24");
////        account1.SetUserName("Le Hoang Nam");
//        System.out.println(account1.GetUserName());
//        System.out.println("check 27");
////        accountList.PasswordCheck(list,"0","1");
////        System.out.println(accountList.GetCurrentIndex());
////        System.out.println(accountList.PasswordCheck(list,"0965481356","123456"));
//        System.out.println("check 32");
//        int currentIndex = accountList.GetCurrentIndex();
//        //list.remove(currentIndex);
//        System.out.println(list.get(0).GetPhoneNumber());
//
////        File file = new File("Accounts.json");
//        AccountToAccountInfo lmao = new AccountToAccountInfo(list);
//        List<AccountInfo> abc = lmao.listHandling();
//
////        JSONWriter jsonWriter = new JSONWriter(file, infoList);
////        jsonWriter.jsonWrite();
////        JSONReader jsonReader = new JSONReader(file);
////        infoList = jsonReader.jsonRead();
////        for (AccountInfo info: infoList) {
////            System.out.println(info.username + info.accountNumber);
////        }
//    }

    public static void main(String[] args) {
//        accountList.Add(account1);
//        accountList.Add(account2);


        //TODO:Lập các Accounts mới ở đây
        Account account1 = new Account ("Nam","123","asdas","9999","dasdas","das","das",100000);
        Account account2 = new Account ("Phong","123456","asdas","999","dasdas","das","das",100000);

        //TODO:Add các Account vào trong một ArrayList
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(account1);
        accounts.add(account2);

        //TODO:Thực hiện tạo lần đầu
//        //Tạo lần đầu (ĐÃ TẠ0)
//        List<AccountInfo> infoList = new ArrayList<>();
//        for (int i = 0; i < accounts.size(); i++) {
//            AccountInfo info = new AccountInfo(accounts.get(i));
//            infoList.add(info);
//        }
//        File file = new File("Accounts.json");
//        JSONWriter jsonWriter = new JSONWriter(file, infoList);
//        jsonWriter.jsonWrite();



        //         Đọc file json và tạo một infoAccount list
        File file = new File("Accounts.json");
        List<AccountInfo> infoList;
        JSONReader jsonReader = new JSONReader(file);
        infoList = jsonReader.jsonRead();

        for (AccountInfo info: infoList) {
            System.out.println(info.accountNumber + ": " + info.username);
        }

        AccountList accountList = new AccountList();
        //Chuyển từ infoAccount ra Account
        for (AccountInfo info: infoList) {
            accountList.Add(new Account(info));
            System.out.println("LÀM DC RỒI ỐI GIƯỜI ƠI!@#!@#!@#!@#!@");
        }

        //Khởi tạo cửa sổ đăng nhập
        //TODO: Sẽ nhận một obj dạng Danh Sách(list) chứa các Accounts
        Login login = new Login(accountList);
//        login.SetAccountList(accountList);;
    }
}
