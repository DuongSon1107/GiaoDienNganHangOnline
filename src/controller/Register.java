package controller;

import AccountInfo.AccountInfo;
import JSONHandling.JSONWriter;
import controller.Login;
import Account.Account;
import AccountList.AccountList;
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

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Register extends JFrame {
    public AccountList accountList;
    public void SetAccountList(AccountList setAccountList) {
        accountList = setAccountList;
    }
    static Random generator = new Random();
    public static int accountNumber = generator.nextInt((999999999 - 100000000) + 1) + 100000000;

    private JPanel contentPane;
    private JTextField textField; //Họ tên
    private JTextField textField_1;//Số Điện thoại
    private JTextField txtD;
    private JTextField textField_3;//email
    private JTextField textField_4;//Địa chỉ
    private JTextField textField_5;//CMND
    private JTextField textField_6;//mật khẩu
    private JTextField textField_7;//Xác nhận mật khẩu
    private JTextField textField_8;//Số dư ban đầu
    private IntRangeComboBox ngayComboBox;
    private IntRangeComboBox thangComboBox;
    private IntRangeComboBox namComboBox;
    private JButton btnXcNhnng;
    private JButton btnCTi;
    private Login login; //Gui Đăng nhập
    private boolean isNgaySinhSet = false;
    public Account currentAccount;

    /**
     * Launch the application.
     */

    /**
     * Create the frame.
     */
    public Register(Login login, AccountList accountList) {
        this.accountList = accountList;
        this.login = login;
        setResizable(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        //@@OMG
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
                }
        });
        setBounds(100, 100, 653, 680);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblngKS = new JLabel("Đăng kí sử dụng tài khoản");
        lblngKS.setForeground(new Color(0, 128, 128));
        lblngKS.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblngKS.setBounds(192, 11, 278, 24);
        contentPane.add(lblngKS);

        textField = new JTextField();
        textField.setBorder(null);
        textField.setBounds(139, 82, 379, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblHTn = new JLabel("Họ tên:");
        lblHTn.setBounds(139, 58, 55, 14);
        contentPane.add(lblHTn);

        JSeparator separator = new JSeparator();
        separator.setBounds(139, 105, 379, 2);
        contentPane.add(separator);

        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(139, 160, 379, 2);
        contentPane.add(separator_1);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBorder(null);
        textField_1.setBounds(139, 137, 379, 20);
        contentPane.add(textField_1);

        JLabel lblSt = new JLabel("Sđt");
        lblSt.setBounds(139, 113, 55, 14);
        contentPane.add(lblSt);

        btnXcNhnng = new JButton("Xác Nhận Đăng Ký");
        btnXcNhnng.setBounds(139, 607, 177, 23);
        contentPane.add(btnXcNhnng);

        btnCTi = new JButton("Đã có tài khoản");
        btnCTi.setBounds(326, 607, 192, 23);
        contentPane.add(btnCTi);

//        JSeparator separator_2 = new JSeparator();
//        separator_2.setBounds(139, 220, 379, 2);
//        contentPane.add(separator_2);


        JLabel lblNgySinh = new JLabel("Ngày sinh");
        lblNgySinh.setBounds(139, 173, 55, 14);
        contentPane.add(lblNgySinh);

        JSeparator separator_3 = new JSeparator();
        separator_3.setBounds(139, 278, 379, 2);
        contentPane.add(separator_3);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBorder(null);
        textField_3.setBounds(139, 255, 379, 20);
        contentPane.add(textField_3);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(139, 231, 55, 14);
        contentPane.add(lblEmail);

        JSeparator separator_4 = new JSeparator();
        separator_4.setBounds(139, 337, 379, 2);
        contentPane.add(separator_4);

        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBorder(null);
        textField_4.setBounds(139, 314, 379, 20);
        contentPane.add(textField_4);

        JLabel lblaCh = new JLabel("Địa chỉ");
        lblaCh.setBounds(139, 290, 55, 14);
        contentPane.add(lblaCh);

        JSeparator separator_5 = new JSeparator();
        separator_5.setBounds(139, 397, 379, 2);
        contentPane.add(separator_5);

        textField_5 = new JTextField();
        textField_5.setColumns(10);
        textField_5.setBorder(null);
        textField_5.setBounds(139, 374, 379, 20);
        contentPane.add(textField_5);

        JLabel lblCmnd = new JLabel("CMND");
        lblCmnd.setBounds(139, 350, 55, 14);
        contentPane.add(lblCmnd);

        JSeparator separator_6 = new JSeparator();
        separator_6.setBounds(139, 457, 379, 2);
        contentPane.add(separator_6);

        textField_6 = new JTextField();
        textField_6.setColumns(10);
        textField_6.setBorder(null);
        textField_6.setBounds(139, 434, 379, 20);
        contentPane.add(textField_6);

        JLabel lblMtKhu = new JLabel("Mật khẩu");
        lblMtKhu.setBounds(139, 410, 55, 14);
        contentPane.add(lblMtKhu);

        JSeparator separator_7 = new JSeparator();
        separator_7.setBounds(139, 517, 379, 2);
        contentPane.add(separator_7);

        textField_7 = new JTextField();
        textField_7.setColumns(10);
        textField_7.setBorder(null);
        textField_7.setBounds(139, 494, 379, 20);
        contentPane.add(textField_7);

        JLabel lblXcNhnMt = new JLabel("Xác nhận mật khẩu");
        lblXcNhnMt.setBounds(139, 470, 114, 14);
        contentPane.add(lblXcNhnMt);

        JSeparator separator_8 = new JSeparator();
        separator_8.setBounds(139, 575, 379, 2);
        contentPane.add(separator_8);

        textField_8 = new JTextField();
        textField_8.setColumns(10);
        textField_8.setBorder(null);
        textField_8.setBounds(139, 552, 379, 20);
        contentPane.add(textField_8);

        JLabel lblSDBan = new JLabel("Số dư ban đầu (VND)");
        lblSDBan.setBounds(139, 528, 196, 14);
        contentPane.add(lblSDBan);
//
//        JSeparator separator_9 = new JSeparator();
//        separator_9.setBounds(176, 207, 9, 2);
//        contentPane.add(separator_9);

//        txtD = new JTextField();
//        txtD.setText("dd");
//        txtD.setColumns(10);
//        txtD.setBorder(null);
//        txtD.setBounds(139, 197, 23, 20);
//        contentPane.add(txtD);
//
//        txtMm = new JTextField();
//        txtMm.setText("mm");
//        txtMm.setColumns(10);
//        txtMm.setBorder(null);
//        txtMm.setBounds(192, 197, 23, 20);
//        contentPane.add(txtMm);
//
//        JSeparator separator_9_1 = new JSeparator();
//        separator_9_1.setBounds(226, 207, 9, 2);
//        contentPane.add(separator_9_1);
//
//        txtYy = new JTextField();
//        txtYy.setText("yy");
//        txtYy.setColumns(10);
//        txtYy.setBorder(null);
//        txtYy.setBounds(245, 197, 39, 20);
//        contentPane.add(txtYy);

        buildNgaySinh();
//        choice = new Choice();
//        JComboBox<Integer> jComboBox = new JComboBox<>();
//        jComboBox.setBounds(139, 205, 45, 20);
        contentPane.add(ngayComboBox);
//
//        choice_1 = new Choice();
//        choice_1.setBounds(190, 205, 40, 20);
        contentPane.add(thangComboBox);
//
//        choice_2 = new Choice();
//        choice_2.setBounds(236, 205, 68, 20);
        contentPane.add(namComboBox);

        buildListeners();
        setVisible(true);
    }

    //build ngaysinh
    public void buildNgaySinh() {
        ngayComboBox = new IntRangeComboBox(1,31,"Ngày");
        thangComboBox = new IntRangeComboBox(1,12,"Tháng");
        namComboBox = new IntRangeComboBox(1900,2010,"Năm");
        ngayComboBox.setBounds(139, 190, 60, 40);
        thangComboBox.setBounds(210, 190, 60, 40);
        namComboBox.setBounds(280, 190, 68, 40);
        ngayComboBox.setBackground(Color.WHITE);
        thangComboBox.setBackground(Color.WHITE);
        namComboBox.setBackground(Color.WHITE);

        thangComboBox.addActionListener(e -> {
            int thang = thangComboBox.getSelectedIndex()+1;
            ngayComboBox.removeAllItems();
            if(thang==1||thang==3||thang==5||thang==7||thang==8||thang==10||thang==12) {
                for (int i = 1; i<=31;i++){
                    ngayComboBox.addItem(i);
                }
            } else if (thang==4||thang==6||thang==9||thang==11) {
                for (int i = 1; i<=30;i++){
                    ngayComboBox.addItem(i);
                }
            } else if (thang == 2) {
                setNgayChoThang2();
            }
        });
        namComboBox.addActionListener(e -> {
            setNgayChoThang2();
        });
    }
    //Action Listeners
    public void buildListeners() {
        btnXcNhnng.addActionListener(e -> {
            boolean isContinue = true;
            String ten, sdt, email, diaChi, cmnd, matkhau, ngaySinh =null;
            int soDuBanDau;
            try {
                isError();
                ten = getTen();
                sdt = getSDT();
                email = getEmail();
                diaChi = getDiaChi();
                cmnd = getCMND();
                matkhau = getMatKhau();
                soDuBanDau = getSoDuBanDauInt();
                ngaySinh = getNgaySinh(); //Có dạng dd//mm/yy

            } catch (BankException err){
                String message = err.errMessage;
                JOptionPane.showMessageDialog(null,message);
                isContinue = false;
            }

            //Codes sau đây chỉ chạy khi mọi rằng buộc (isError) đã được thoả mãn!
            if(isContinue) {
                //Cửa sổ xác nhận
                int choice = JOptionPane.showOptionDialog(null,
                        "Bạn đã chắc chắn muốn tạo tài khoản?",
                        "Tạo tài khoản",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        new String[]{"Có", "Không"},"Có");

                //Nếu chọn "Có"
                if (choice == JOptionPane.YES_OPTION) {
                    System.out.println(ngaySinh);

                    Account account = new Account(textField.getText(),textField_6.getText(),ngayComboBox.getSelectedItem().toString().concat("/").concat(thangComboBox.getSelectedItem().toString()).concat("/").concat(namComboBox.getSelectedItem().toString()),textField_1.getText(),textField_4.getText(),textField_3.getText(),textField_5.getText(),Double.valueOf(textField_8.getText()));
                    while(accountList.AccountNumberCheck(accountList, accountNumber) == true) {
                         account = new Account(textField.getText(),textField_6.getText(),ngayComboBox.getSelectedItem().toString().concat("/").concat(thangComboBox.getSelectedItem().toString()).concat("/").concat(namComboBox.getSelectedItem().toString()),textField_1.getText(),textField_4.getText(),textField_3.getText(),textField_5.getText(),Double.valueOf(textField_8.getText()));
                    }
                    // while (=true) do (Account account = new Account...)
                    login.accountList.Add(account);
                    currentAccount = account;

                    //Cập nhật file json
                    List<AccountInfo> infoList = new ArrayList<>();
                    for (int i = 0; i < accountList.GetSize(); i++) {
                        AccountInfo info = new AccountInfo(accountList.GetAccount(i));
                        infoList.add(info);
                    }
                    File file = new File("Accounts.json");
                    JSONWriter jsonWriter = new JSONWriter(file, infoList);
                    jsonWriter.jsonWrite();


                    //TODO:"Chắc" là nối ở đây đấy bạn ạ!
                    //TODO:Tạo Object Account mới cho người dùng tại đây Ex: new Account(ten,diachi,...)
                    //TODO:Add Account mới tạo vào trong cơ sở dữ liệu nào đó? bằng cách nào đó? mà người làm cái GUI này(tôi) đéo bt
                    //TODO:Xây dựng giao diện người dùng chính (MainGUI) dựa trên Object Account vừa tạo
                    Login login = new Login(accountList);
                    //TODO:Còn thiếu khả năng nhận vào một Object Account
                    dispose(); //Loại bỏ cửa sổ đăng kí!
                }
            }
        });

        btnCTi.addActionListener(e -> {
            login.setVisible(true);
            dispose();
        });
    }

    //Các method xét điều kiện của input
    public void isError() throws BankException{
        isTenError();
        isSDTError();
        isEmailError();
        isDiaChiError();
        isCMNDError();
        isMatKhauError();
        isSoDuError();
    }

    public void isTenError() throws BankException{
        String ten = textField.getText().trim();
        if(login.isNull(ten)) throw new BankException("Tên không được để trống!");
        if(login.isDigit(ten)) throw new BankException("Tên không được có số!");
    }

    public void isSDTError() throws BankException{
        String sdt = textField_1.getText().trim();
        if(login.isNull(sdt)) throw new BankException("Số điện thoại không được để trống!");
        if(!login.isDigit(sdt)) throw new BankException("Số điện thoại có kí tự không hợp lệ!");
    }

    public void isEmailError() throws BankException {
        String email = textField_3.getText().trim();
        if(login.isNull(email)) throw new BankException("Email không được để trống!");
    }

    public void isDiaChiError() throws BankException {
        String diaChi = textField_4.getText().trim();
        if(login.isNull(diaChi)) throw new BankException("Địa chỉ không được để trống!");
    }

    public void isCMNDError() throws BankException {
        String cmnd = textField_5.getText().trim();
        if(login.isNull(cmnd)) throw new BankException("CMND không được để trống!");
        if(!login.isDigit(cmnd)) throw new BankException("Số điện thoại có kí tự không hợp lệ!");
        if(cmnd.length()!=12) throw new BankException("Số CMND phải có 12 kí tự số!");
    }

    public void isMatKhauError() throws BankException {
        String matkhau = textField_6.getText().trim();
        String xacMinh = textField_7.getText().trim();
        if(login.isNull(matkhau)) throw new BankException("Mật khẩu không được để trống!");
        if(login.isNull(xacMinh)) throw new BankException("Xác minh mật khẩu không được để trống!");
        if(!matkhau.equals(xacMinh)) throw new BankException("Mật khẩu xác minh không khớp!");
    }

    public void isSoDuError() throws BankException {
        String soDu = textField_8.getText().trim();
        if(login.isNull(soDu)) throw new BankException("Số dư không được để trống!");
        if(!login.isDigit(soDu)) throw new BankException("Số dư ban đầu có kí tự không hợp lệ!");
        if(getSoDuBanDauInt()<50000) throw new BankException("Số dư ban đầu phải lớn hơn 50.000 VND!");
    }

    //getters
    public int getSoDuBanDauInt() {
        return Integer.parseInt(textField_8.getText().trim());
    }

    public String getTen() {
        return textField.getText().trim();
    }

    public String getSDT() {
        return textField_1.getText().trim();
    }

    public String getNgaySinh() {
        int ngay = (int)ngayComboBox.getSelectedItem();
        int thang = (int)thangComboBox.getSelectedItem();
        int nam = (int)namComboBox.getSelectedItem();
        return String.format("%d/%d/%d",ngay,thang,nam);
    }

    public String getEmail() {
        return textField_3.getText().trim();
    }

    public String getDiaChi() {
        return textField_4.getText().trim();
    }

    public String getCMND() {
        return textField_5.getText().trim();
    }

    public String getMatKhau() {
        return textField_6.getText().trim();
    }

    public class IntRangeComboBox extends JComboBox<Integer> {
        public IntRangeComboBox(int start, int end, String title) {
            super();
            setBorder(BorderFactory.createTitledBorder(title));
            for (int i = start; i <= end;i++) {
                addItem(i);
            }
            setEditable(false);
        }
    }

    public static boolean isNamNhuan(int year){
        return (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0));
    }

    public void setNgayChoThang2(){
        int thang2Days = 0;
        if (thangComboBox.getSelectedIndex()+1==2) {
            ngayComboBox.removeAllItems();
            if(isNamNhuan((int)namComboBox.getSelectedItem())){
                thang2Days = 29;
            }
            else {
                thang2Days = 28;
            }
            for (int i = 1; i<=thang2Days;i++){
                ngayComboBox.addItem(i);
            }
        }
    }
}

