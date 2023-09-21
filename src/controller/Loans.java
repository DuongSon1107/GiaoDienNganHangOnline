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
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import Account.Loan;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Loans extends JFrame {

    private JPanel contentPane;
    private Image image_logo = new ImageIcon(Login.class.getResource("../image/logo.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
    private JTextField textField;
    private JPasswordField passwordField;
    private JLabel lblChuynKhon; //Chuyển khoản
    private JLabel lblLsGiaoDch; //Lịch sử giao dịch
    private JLabel lblngXut; //Gửi tiết kiệm
    private JLabel lblNpTin; //Nạp tiền
    private JLabel lblngXut_1_1; //Đăng xuất
    private JLabel lbVayTien;//Vay tiền
    private JLabel lblHome;//Trang chu
    private JLabel lbSoTk;
    private JLabel lblVnd;
    private Home home;
    private Loans loans;
    private Loan loan;

    /**
     * Launch the application.
     */


    /**
     * Create the frame.
     */
    public Loans(Home home) {
        this.home = home;
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        //@@OMG
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                List<AccountInfo> infoList = new ArrayList<>();
                for (int i = 0; i < home.accountList.GetSize(); i++) {
                    AccountInfo info = new AccountInfo(home.accountList.GetAccount(i));
                    infoList.add(info);
                }
                File file = new File("Accounts.json");
                JSONWriter jsonWriter = new JSONWriter(file, infoList);
                jsonWriter.jsonWrite();
                System.exit(0);
            }
        });
        setBounds(100, 100, 682, 542);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 128, 128));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        Panel panel = new Panel();
        panel.setBounds(0, 0, 171, 503);
        panel.setBackground(UIManager.getColor("Button.darkShadow"));
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblogo = new JLabel("");
        lblogo.setBounds(36, 29, 102, 92);
        panel.add(lblogo);
        lblogo.setIcon(new ImageIcon(image_logo));

        lblHome = new JLabel("Trang chủ");
        lblHome.setFont(new Font("Tahoma", Font.PLAIN, 21));
        lblHome.setForeground(Color.WHITE);
        lblHome.setBounds(10, 181, 102, 33);
        panel.add(lblHome);

        lblChuynKhon = new JLabel("Chuyển khoản");
        lblChuynKhon.setForeground(Color.WHITE);
        lblChuynKhon.setFont(new Font("Tahoma", Font.PLAIN, 21));
        lblChuynKhon.setBounds(10, 225, 139, 33);
        panel.add(lblChuynKhon);

        lblLsGiaoDch = new JLabel("LS giao dịch");
        lblLsGiaoDch.setForeground(Color.WHITE);
        lblLsGiaoDch.setFont(new Font("Tahoma", Font.PLAIN, 21));
        lblLsGiaoDch.setBounds(10, 269, 139, 33);
        panel.add(lblLsGiaoDch);

        lblngXut = new JLabel("Gửi tiết kiệm");
        lblngXut.setForeground(Color.WHITE);
        lblngXut.setFont(new Font("Tahoma", Font.PLAIN, 21));
        lblngXut.setBounds(10, 313, 139, 33);
        panel.add(lblngXut);

        lblNpTin = new JLabel("Nạp tiền");
        lblNpTin.setForeground(Color.WHITE);
        lblNpTin.setFont(new Font("Tahoma", Font.PLAIN, 21));
        lblNpTin.setBounds(10, 356, 139, 33);
        panel.add(lblNpTin);

        lblngXut_1_1 = new JLabel("Đăng xuất");
        lblngXut_1_1.setForeground(Color.WHITE);
        lblngXut_1_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
        lblngXut_1_1.setBounds(10, 440, 139, 33);
        panel.add(lblngXut_1_1);

        lbVayTien = new JLabel("Vay tiền");
        lbVayTien.setForeground(new Color(255, 255, 0));
        lbVayTien.setFont(new Font("Tahoma", Font.PLAIN, 21));
        lbVayTien.setBounds(10, 400, 139, 33);
        panel.add(lbVayTien);

        JLabel lblCauchemarBank = new JLabel("Cauchemar Bank");
        lblCauchemarBank.setForeground(Color.WHITE);
        lblCauchemarBank.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblCauchemarBank.setBounds(34, 133, 102, 17);
        panel.add(lblCauchemarBank);


        Panel panel_1 = new Panel();
        panel_1.setBounds(169, 0, 497, 85);
        panel_1.setBackground(new Color(0, 128, 128));
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblVayTin = new JLabel("Vay Tiền");
        lblVayTin.setFont(new Font("Tahoma", Font.BOLD, 23));
        lblVayTin.setBounds(208, 27, 131, 32);
        panel_1.add(lblVayTin);

        JButton btnYuCu = new JButton("Yêu Cầu");
        btnYuCu.setBounds(373, 339, 89, 23);
        contentPane.add(btnYuCu);
        //TODO: Thực hiện vay ở đây
        btnYuCu.addActionListener(e -> {
//            int soTienVay;
            boolean isContinue = true;
            try{
                isError();
//                soTienVay = getSoTienInt();
            } catch (BankException err){
                String message = err.errMessage;
                JOptionPane.showMessageDialog(null,message);
                isContinue = false;
            }

            if (isContinue) {
                System.out.println("Chạy đc rồi!");
                //TODO: Thực hiện vay dựa trên số tiền soTienVay
                loan = new Loan(1,6,getSoTienInt(),0.06);
                try {
                    JOptionPane.showMessageDialog(null,home.currentAccount.bankLoan(loan));
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                updateTT();

            }
        });

        Panel panel_2 = new Panel();
        panel_2.setBounds(195, 109, 442, 78);
        panel_2.setBackground(new Color(255, 255, 255));
        contentPane.add(panel_2);
        panel_2.setLayout(null);

        JLabel lblTTiKhon = new JLabel("Từ tài khoản: ");
        lblTTiKhon.setBounds(10, 11, 102, 14);
        panel_2.add(lblTTiKhon);

        lbSoTk = new JLabel("102868421340");
        lbSoTk.setForeground(new Color(0, 128, 128));
        lbSoTk.setBounds(10, 28, 102, 14);
        panel_2.add(lbSoTk);

        JLabel lblSDKh = new JLabel("Số dư khả dụng");
        lblSDKh.setBounds(10, 53, 102, 14);
        panel_2.add(lblSDKh);

        lblVnd = new JLabel("8,500,000 VND");
        lblVnd.setBounds(105, 53, 102, 14);
        panel_2.add(lblVnd);

        Panel panel_3 = new Panel();
        panel_3.setBounds(195, 217, 442, 85);
        panel_3.setBackground(new Color(255, 255, 255));
        contentPane.add(panel_3);
        panel_3.setLayout(null);

        JLabel lblNewLabel = new JLabel("Số tiền muốn vay (VND)");
        lblNewLabel.setBounds(10, 11, 199, 14);
        panel_3.add(lblNewLabel);

        textField = new JTextField();
        textField.setBorder(null);
        textField.setBounds(10, 36, 119, 20);
        panel_3.add(textField);
        textField.setColumns(10);

        JSeparator separator = new JSeparator();
        separator.setBounds(10, 57, 134, 2);
        panel_3.add(separator);

        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(240, 57, 134, 2);
        panel_3.add(separator_1);

        JLabel lblNhpLiMt = new JLabel("Nhập lại mật khẩu");
        lblNhpLiMt.setBounds(240, 8, 119, 14);
        panel_3.add(lblNhpLiMt);

        passwordField = new JPasswordField();
        passwordField.setBorder(null);
        passwordField.setBounds(240, 36, 119, 20);
        panel_3.add(passwordField);
        buildListener();
        updateTT();
        setVisible(true);
        loans = this;

    }

    //is Error
    public void isError() throws BankException{
        isSoTienError();
        isMKError();
    }

    //Xét xem số tài khoản có hợp lệ không
    public void isSoTienError() throws BankException {
        String soTKStr = textField.getText();
        if (!Login.isDigit(soTKStr)) throw new BankException("Số tiền có kí tự không hợp lệ!");
        if(Login.isNull(soTKStr)) throw new BankException("Không được để trống số tiền!");

    }

    //Xét xem mật khẩu có hợp lệ không
    public void isMKError() throws BankException{
        String matKhau = getMatKhau();
        if(Login.isNull(matKhau)) throw new BankException("Mật khẩu không được để trống!");
        if(home.accountList.PasswordCheck(home.currentAccount.phoneNumber,String.valueOf(passwordField.getPassword())) == false) throw new BankException("Không có Số Điện Thoại hoặc sai Mật Khẩu");

        //TODO: So sánh mk nhập vào với mk của Account
        //TODO: sai -> throw new BankException("Mật khẩu không chính xác!")
    }
    //getters
    public String getMatKhau() {
        StringBuilder strB = new StringBuilder();
        char[] cArr = passwordField.getPassword();
        for (char c: cArr) {
            strB.append(c);
        }
        return strB.toString().trim();
    }


    public int getSoTienInt() {
        return Integer.parseInt(textField.getText().trim());
    }
    //update
    public void updateTT() {
        updateSoduKD();
        updateSoTk();
    }

    public void updateSoduKD() {
//        int soDu = TODO: Nhận vào số dư ở đây Vd: obj.balance hay bất cứ hàm get quần què gì đấy!
        //int soduKD = soDu -50000
        String soduTxt = String.format("%,.0f VND",home.currentAccount.GetBalance()-50000);
        lblVnd.setText(soduTxt);

    }

    public void updateSoTk() {
//        int soTK = TODO: Nhận vào số tk ở đây, String hay int tuỳ thuộc
        lbSoTk.setText(String.valueOf(home.currentAccount.accountNumber));
    }









    //Build Listener
    public void buildListener() {
        lblChuynKhon.addMouseListener(new ChuyenKhoanListener());
        lblLsGiaoDch.addMouseListener(new LSGDListener());
        lblngXut.addMouseListener(new GuiTKListener());
        lblNpTin.addMouseListener(new NapTienListener());
        lblngXut_1_1.addMouseListener(new DangXuatListener());
        lbVayTien.addMouseListener(new VayTienListener());
        lblHome.addMouseListener(new TrangChuListener());
    }



    //mouselistener classes
    //Thêm actions cho các nút(label) ở đây
    private class ChuyenKhoanListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("Click dc Chuyen khoan r! Ối giời ơi!!!!");
            new SendMoney(home);
            loans.dispose();
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    private class LSGDListener implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("Click dc LSGD r! Ối giời ơi!!!!");
            new History(home);
            loans.dispose();
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    private class GuiTKListener implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("Click dc Gửi Tiết kiệm r! Ối giời ơi!!!!");
            new SavingGUI(home);
            loans.dispose();
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
    private class NapTienListener implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("Click dc Nạp tiền r! Ối giời ơi!!!!");
            new initAmount(home);
            loans.dispose();
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
    private class VayTienListener implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    private class DangXuatListener implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("Click dc Đăng xuất r! Ối giời ơi!!!!");
            new Login(home.accountList);
            List<AccountInfo> infoList = new ArrayList<>();
            for (int i = 0; i < home.accountList.GetSize(); i++) {
                AccountInfo info = new AccountInfo(home.accountList.GetAccount(i));
                infoList.add(info);
            }
            File file = new File("Accounts.json");
            JSONWriter jsonWriter = new JSONWriter(file, infoList);
            jsonWriter.jsonWrite();
            loans.dispose();
            home.dispose();
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    private class TrangChuListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            home.setVisible(true);
            home.updateTT();
            loans.dispose();
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
