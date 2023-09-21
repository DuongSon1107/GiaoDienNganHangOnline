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

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import static controller.Login.isDigit;
import static controller.Login.isNull;

public class initAmount extends JFrame {

    private JPanel contentPane;
    private Image image_logo = new ImageIcon(Login.class.getResource("../image/logo.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
    private JTextField textField;
    private JTextField textField_1;
    private JPasswordField passwordField;
    private JLabel lblChuynKhon; //Chuyển khoản
    private JLabel lblLsGiaoDch; //Lịch sử giao dịch
    private JLabel lblngXut; //Gửi tiết kiệm
    private JLabel lblNpTin; //Nạp tiền
    private JLabel lblngXut_1_1; //Đăng xuất
    private JLabel lbVayTien;//Vay tiền
    private JLabel lblHome; //Trang chu
    private Home home;
    private initAmount initAmount;

    /**
     * Launch the application.


    /**
     * Create the frame.
     */
    public initAmount(Home home) {
        this.home = home;
        initAmount = this;

        setResizable(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
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
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        Panel panel = new Panel();
        panel.setBackground(UIManager.getColor("Button.darkShadow"));
        panel.setBounds(0, 0, 171, 503);
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
        lblNpTin.setForeground(new Color(255, 255, 0));
        lblNpTin.setFont(new Font("Tahoma", Font.PLAIN, 21));
        lblNpTin.setBounds(10, 356, 139, 33);
        panel.add(lblNpTin);

        lblngXut_1_1 = new JLabel("Đăng xuất");
        lblngXut_1_1.setForeground(Color.WHITE);
        lblngXut_1_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
        lblngXut_1_1.setBounds(10, 440, 139, 33);
        panel.add(lblngXut_1_1);

        lbVayTien = new JLabel("Vay tiền");
        lbVayTien.setForeground(Color.WHITE);
        lbVayTien.setFont(new Font("Tahoma", Font.PLAIN, 21));
        lbVayTien.setBounds(10, 400, 139, 33);
        panel.add(lbVayTien);

        JLabel lblCauchemarBank = new JLabel("Cauchemar Bank");
        lblCauchemarBank.setForeground(Color.WHITE);
        lblCauchemarBank.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblCauchemarBank.setBounds(34, 133, 102, 17);
        panel.add(lblCauchemarBank);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(0, 128, 128));
        panel_1.setBounds(166, 0, 500, 69);
        contentPane.add(panel_1);

        JLabel lblNpLnu = new JLabel("Nạp Tiền");
        lblNpLnu.setForeground(new Color(255, 255, 255));
        lblNpLnu.setFont(new Font("Tahoma", Font.BOLD, 23));
        panel_1.add(lblNpLnu);


//        JSeparator separator = new JSeparator();
//        separator.setBounds(176, 120, 490, 7);
//        contentPane.add(separator);

        JLabel lblNhpSTin = new JLabel("Nhập số tiền (VND)");
        lblNhpSTin.setBounds(177, 138, 235, 14);
        contentPane.add(lblNhpSTin);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBorder(null);
        textField_1.setBounds(177, 158, 489, 20);
        contentPane.add(textField_1);

        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(176, 178, 490, 7);
        contentPane.add(separator_1);

        JLabel lblNhpMtKhu = new JLabel("Nhập mật khẩu");
        lblNhpMtKhu.setBounds(177, 197, 235, 14);
        contentPane.add(lblNhpMtKhu);

        JSeparator separator_2 = new JSeparator();
        separator_2.setBounds(176, 237, 490, 7);
        contentPane.add(separator_2);

        JButton btnNewButton = new JButton("Nạp tiền");
        btnNewButton.setBounds(379, 404, 89, 23);
        contentPane.add(btnNewButton);
        //TODO: Thực hiện nạp tiền ở đây
        btnNewButton.addActionListener(e -> {
//            int soTienNap = Integer.parseInt(null);
            boolean isContinue = true;
            try{
                isError();
//                soTienNap = getSoTienInt();
//                System.out.println(String.valueOf(soTienNap));
            } catch (BankException err){
                String message = err.errMessage;
                JOptionPane.showMessageDialog(null,message);
                isContinue = false;
            }

            if (isContinue) {
                System.out.println("Chạy đc rồi!");
                try {
                    home.currentAccount.inputMoney(getSoTienInt(), home.currentAccount.GetAccountNumber());
                    JOptionPane.showMessageDialog(null,"Giao dịch thành công");
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }

            }
        });

        passwordField = new JPasswordField();
        passwordField.setBorder(null);
        passwordField.setBounds(177, 216, 489, 20);
        contentPane.add(passwordField);

        buildListener();
        setVisible(true);

    }

    //isError
    public void isError() throws BankException{
        isSoTienError();
        isMKError();
    }

    public void isSoTienError() throws  BankException{
        textField_1.getText().trim();
        String sotien = textField_1.getText().trim();
        if(isNull(sotien)) throw new BankException("Không được để trống số tiền!");
        if(!isDigit(sotien)) throw new BankException("Số tiền có kí tự không hợp lệ!");
    }

    public void isMKError() throws BankException {
        String matKhau = getMatKhau();
        if(isNull(matKhau)) throw new BankException("Mật khẩu không được để trống!");
        if(home.accountList.PasswordCheck(home.currentAccount.phoneNumber,String.valueOf(passwordField.getPassword())) == false) throw new BankException("Không có Số Điện Thoại hoặc sai Mật Khẩu");

        //TODO: So sánh mk nhập vào với mk của Account
        //TODO: sai -> throw new BankException("Mật khẩu không chính xác!")
    }

    //getter
    public String getMatKhau() {
        StringBuilder strB = new StringBuilder();
        char[] cArr = passwordField.getPassword();
        for (char c: cArr) {
            strB.append(c);
        }
        return strB.toString().trim();
    }

    public int getSoTienInt() {
        return Integer.parseInt(textField_1.getText().trim());
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
            initAmount.dispose();
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
            initAmount.dispose();
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
            initAmount.dispose();
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
            System.out.println("Click dc Vay tiền r! Ối giời ơi!!!!");
            new Loans(home);
            initAmount.dispose();
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
            initAmount.dispose();
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
            initAmount.dispose();
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
