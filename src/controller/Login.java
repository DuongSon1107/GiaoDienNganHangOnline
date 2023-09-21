package controller;

//import controller.Home;
import Account.Account;
import AccountList.AccountList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class Login extends JFrame {
    public AccountList accountList;
    public void SetAccountList(AccountList setAccountList){
        accountList = setAccountList;
    }
    public Account currentAccount;

    private JPanel contentPane;
    private JButton btnngNhp;//Nút đăng nhập
    private JButton btnMTiKhon; //Nút mở tài khoản
    private Image image_logo = new ImageIcon(Login.class.getResource("../image/log.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
    private Image image_user = new ImageIcon(Login.class.getResource("../image/user.jpg")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
    private Image image_pass = new ImageIcon(Login.class.getResource("../image/key-icon.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
    private JTextField textField;
    public JPasswordField passwordField;
    //TODO: Khai một AccList ở đây
    //TODO: Khai một obj Acc ở đây (sẽ chỉ đến Obj Acc thoả mãn input ?)
    /**
     * Launch the application.
     */
//    public static void main(String[] args) {
//        AccountList accountList = new AccountList();
//        Account account1 = new Account ("Nam","123","asdas","9999","dasdas","das","das",213);
//        accountList.Add(account1);
//        //Khởi tạo cửa sổ đăng nhập
//        //TODO: Sẽ nhận một obj dạng Danh Sách(list) chứa các Accounts
//        Login login = new Login();
//        System.out.println(accountList.GetAccount(0).phoneNumber);
//        System.out.println(accountList.GetAccount(0).password);
//        System.out.println(String.valueOf(login.passwordField.getPassword()));
//    }


    public static void main(String[] args) {
    AccountList accountList = new AccountList();
    Account account1 = new Account ("Nam","123","asdas","9999","dasdas","das","das",213);
    accountList.Add(account1);
    //Khởi tạo cửa sổ đăng nhập
    //TODO: Sẽ nhận một obj dạng Danh Sách(list) chứa các Accounts
    Login login = new Login(accountList);
    login.SetAccountList(accountList);;
}

    /**
     * Create the frame.
     */
    public Login(AccountList accountList) {
        this.accountList = accountList;
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 588, 393);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 128, 128));
        contentPane.setBorder(new LineBorder(new Color(0, 0, 139), 0));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        btnngNhp = new JButton("ĐĂNG NHẬP");
        btnngNhp.setBounds(189, 279, 235, 31);
        contentPane.add(btnngNhp);


        btnMTiKhon = new JButton("MỞ TÀI KHOẢN");
        btnMTiKhon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnMTiKhon.setBounds(189, 322, 235, 31);
        contentPane.add(btnMTiKhon);

        JLabel lblogo = new JLabel("New label");
        lblogo.setBounds(251, 23, 92, 90);
        contentPane.add(lblogo);
        lblogo.setIcon(new ImageIcon(image_logo));

        JLabel lblCauchemarBank = new JLabel("Cauchemar Bank");
        lblCauchemarBank.setForeground(Color.WHITE);
        lblCauchemarBank.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblCauchemarBank.setBounds(248, 130, 102, 17);
        contentPane.add(lblCauchemarBank);

        Panel panel = new Panel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(152, 163, 306, 40);
        contentPane.add(panel);
        panel.setLayout(null);

        textField = new JTextField();
        textField.setBorder(BorderFactory.createTitledBorder("Số Điện Thoại"));
        textField.setBounds(0, 0, 258, 40);
        panel.add(textField);
        textField.setColumns(10);


        JLabel lbuser = new JLabel("");
        lbuser.setBounds(260, 0, 46, 40);
        panel.add(lbuser);
        lbuser.setIcon(new ImageIcon(image_user));

        Panel panel_1 = new Panel();
        panel_1.setBackground(Color.WHITE);
        panel_1.setBounds(152, 209, 306, 40);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        passwordField = new JPasswordField();
        passwordField.setBorder(BorderFactory.createTitledBorder("Mật Khẩu"));
        passwordField.setBounds(0, 0, 259, 40);
        panel_1.add(passwordField);


        JLabel lbpass = new JLabel("");
        lbpass.setBounds(260, 0, 46, 40);
        panel_1.add(lbpass);
        lbpass.setIcon(new ImageIcon(image_pass));
//		setUndecorated(true);

        buildListeners();
        setVisible(true);
    }

    //Action Listeners
    public void buildListeners() {
        //Button đăng nhập
        btnngNhp.addActionListener(e -> {
            boolean isContinue = true;
            try{
                isError(accountList);
            } catch (BankException err){
                String message = err.errMessage;
                JOptionPane.showMessageDialog(null,message);
                isContinue = false;
            }

            if (isContinue) {
                System.out.println("Chạy đc rồi!");
                currentAccount = accountList.GetAccount(accountList.GetCurrentIndex());
                // get current index tạo giá trị current account
                //TODO: Chạy khi đã có được Account thoả mãn điều kiện để gán vào biến objAcc
                //TODO: Gán obj Acc thoả mãn điều kiền vào biến Acc khai ở trên
                //TODO: new Home(objAcc,arrAccs) -> Nhan object Account o day va khoi tao giao dien chinh
                setVisible(false);

                Home home = new Home(currentAccount,accountList);
                home.updateTT();

            }
        });

        //Button Đăng kí
        btnMTiKhon.addActionListener(e -> {
                new Register(this,accountList); //ĐỂ quay lại dc LoginGUI
                setVisible(false);
        });
    }


    public void isError(AccountList accountList) throws BankException{
        isSoTKError();
        isMKError();
        isInputsLegal(accountList);
    }

    //Xét xem số tài khoản có hợp lệ không
    public void isSoTKError() throws BankException {
        String soTKStr = textField.getText();
        if (!isDigit(soTKStr)) throw new BankException("Số tài khoản có kí tự không hợp lệ!");
        if(isNull(soTKStr)) throw new BankException("Không được để trống số tài khoản!");

    }

    public void isMKError() throws BankException{
        String matKhau = getMatKhau();
        if(isNull(matKhau)) throw new BankException("Mật khẩu không được để trống!");
    }

    //Xét xem tài khoản với mật khẩu có khớp với csdl ko ?
    public void isInputsLegal(AccountList accountList) throws BankException{
        if(accountList.PasswordCheck(getSoTK(),String.valueOf(passwordField.getPassword())) == false) throw new BankException("Không có Số Điện Thoại hoặc sai Mật Khẩu");
        //TODO:Xét số Tk với mật khẩu với các Object Account nằm trong List nhận vào (for loop?)
        //TODO:nếu không số tk không tồn tại -> throws BankException("Không tồn tại số tài khoản này")
        //TODO:nếu mật khẩu không khớp -> throws BankException("Mật khẩu không khớp với số tài khoản")
        //TODO:gán Object Account thoả mãn điều kiện vào biến objAcc trong GUI này
    }

    //getters
    //Get số tk
    public String getSoTK() {
        return textField.getText().trim();
    }
    //Lấy mật khẩu ra dạng string
    public String getMatKhau() {
        StringBuilder strB = new StringBuilder();
        char[] cArr = passwordField.getPassword();
        for (char c: cArr) {
            strB.append(c);
        }
        System.out.println(strB);
        return strB.toString().trim();
    }
    //balalala
    public static boolean isNull(String str) {
        return str.trim().equals("");
    }

    public static boolean isDigit(String str){
        boolean status = true;
        char[] cArr = str.toCharArray();
        for (char c :cArr){
            if("1234567890".indexOf(c)==-1) {
                status = false;
            }
        }
        return  status;
    }

}
