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
import Account.Account;
import AccountList.AccountList;

import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.Panel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Home extends JFrame {
    public  Account currentAccount;
    public AccountList accountList;
    public  void SetCurrentAccount(Account insert){
        this.currentAccount = insert;
    }
    private JPanel contentPane;
    private Image image_logo = new ImageIcon(Login.class.getResource("../image/logo.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
    private JLabel lblChuynKhon; //Chuyển khoản
    private JLabel lblLsGiaoDch; //Lịch sử giao dịch
    private JLabel lblngXut; //Gửi tiết kiệm
    private JLabel lblNpTin; //Nạp tiền
    private JLabel lblngXut_1_1; //Đăng xuất
    private JLabel lblVnd;//Số dư
    private JLabel lbTen;//Tên
    private JLabel lbSoTK;//Số TK
    private JLabel lbVayTien;//Vay tiền
    private JLabel lblNewLabel; //Mở tk số đẹp
    private Home home;

    /**
     * Launch the application.
     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    Home frame = new Home();
//                    frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

    /**
     * Create the frame.
     */
    public Home(Account currentAccount, AccountList accountList) {
        home = this;
        this.accountList = accountList;
        this.currentAccount = currentAccount;

        setResizable(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        //@@OMG
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                List<AccountInfo> infoList = new ArrayList<>();
                for (int i = 0; i < accountList.GetSize(); i++) {
                    AccountInfo info = new AccountInfo(accountList.GetAccount(i));
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
        panel.setBackground(UIManager.getColor("Button.darkShadow"));
        panel.setBounds(0, 0, 171, 503);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblogo = new JLabel("");
        lblogo.setBounds(36, 29, 102, 92);
        panel.add(lblogo);
        lblogo.setIcon(new ImageIcon(image_logo));

        JLabel lblHome = new JLabel("Trang chủ");
        lblHome.setFont(new Font("Tahoma", Font.PLAIN, 21));
        lblHome.setForeground(new Color(255, 255, 0));
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
        lbVayTien.setForeground(Color.WHITE);
        lbVayTien.setFont(new Font("Tahoma", Font.PLAIN, 21));
        lbVayTien.setBounds(10, 400, 139, 33);
        panel.add(lbVayTien);

        JLabel lblCauchemarBank = new JLabel("Cauchemar Bank");
        lblCauchemarBank.setForeground(Color.WHITE);
        lblCauchemarBank.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblCauchemarBank.setBounds(34, 133, 102, 17);
        panel.add(lblCauchemarBank);

        Panel panel_1 = new Panel();
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setBounds(188, 42, 468, 196);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblTiKhonThanh = new JLabel("Tài khoản thanh toán");
        lblTiKhonThanh.setBounds(10, 11, 158, 14);
        panel_1.add(lblTiKhonThanh);

        JLabel lblTngSD = new JLabel("Tổng số dư");
        lblTngSD.setBounds(10, 36, 122, 14);
        panel_1.add(lblTngSD);

        lblVnd = new JLabel("6,850,000 VND");
        lblVnd.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblVnd.setForeground(new Color(0, 128, 128));
        lblVnd.setBounds(10, 50, 200, 14);
        panel_1.add(lblVnd);

        lbTen = new JLabel("LE TUAN TU");
        lbTen.setFont(new Font("Tahoma", Font.BOLD, 16));
        lbTen.setBounds(10, 86, 200, 20);
        panel_1.add(lbTen);

        lbSoTK = new JLabel("102767961345");
        lbSoTK.setFont(new Font("Tahoma", Font.BOLD, 13));
        lbSoTK.setForeground(new Color(0, 128, 128));
        lbSoTK.setBounds(10, 111, 103, 17);
        panel_1.add(lbSoTK);

        Panel panel_2 = new Panel();
        panel_2.setBackground(UIManager.getColor("Button.background"));
        panel_2.setBounds(188, 232, 468, 42);
        contentPane.add(panel_2);
        panel_2.setLayout(null);

//        lblNewLabel = new JLabel("+ Mở tài khoản số đẹp");
//        lblNewLabel.setForeground(new Color(0, 128, 128));
//        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
//        lblNewLabel.setBounds(156, 11, 201, 31);
//        panel_2.add(lblNewLabel);

        Panel panel_3 = new Panel();
        panel_3.setBackground(Color.WHITE);
        panel_3.setBounds(188, 295, 468, 42);
        contentPane.add(panel_3);
        panel_3.setLayout(null);

        JLabel lblVayTinOnline = new JLabel("SĐT Liên hệ: 19001009");
        lblVayTinOnline.setForeground(new Color(0, 128, 128));
        lblVayTinOnline.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblVayTinOnline.setBounds(10, 11, 200, 20);
        panel_3.add(lblVayTinOnline);

        setVisible(true);
        buildListener();
//        updateTT(currentAccount);
    }

    //update Thong tin se cap nhat lại thong tin ngươi dung dua vao obj Account ?
    public void updateTT() {
        updateTen();
        updateSodu();
        updateSoTk();
    }
    public void updateTen() {
//        String ten = TODO: Nhận vào tên người dùng
//        lbTen.setText("Vo The Phong");
        lbTen.setText(currentAccount.userName);
    }

    public void updateSodu() {
//        int soDu = TODO: Nhận vào số dư ở đây Vd: obj.balance hay bất cứ hàm get quần què gì đấy!
//        lblVnd.setText(soduTxt);
          Double soDu = currentAccount.GetBalance();
          String soduTxt = String.format("%,.0f VND",soDu);
          lblVnd.setText(soduTxt);
    }

    public void updateSoTk() {
//        int soTK = TODO: Nhận vào số tk ở đây, String hay int tuỳ thuộc
//        lbSoTK.setText("21312312312");
        int soTK = currentAccount.accountNumber;
        lbSoTK.setText(String.valueOf(soTK));

    }
    //Build Listener
    public void buildListener() {
        lblChuynKhon.addMouseListener(new ChuyenKhoanListener());
        lblLsGiaoDch.addMouseListener(new LSGDListener());
        lblngXut.addMouseListener(new GuiTKListener());
        lblNpTin.addMouseListener(new NapTienListener());
        lblngXut_1_1.addMouseListener(new DangXuatListener());
        lbVayTien.addMouseListener(new VayTienListener());
    }

    //mouselistener classes
    //Thêm actions cho các nút(label) ở đây
    private class ChuyenKhoanListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("Click dc Chuyen khoan r! Ối giời ơi!!!!");
            new SendMoney(home);
            setVisible(false);
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
            setVisible(false);
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
            setVisible(false);
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
            setVisible(false);
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
            setVisible(false);
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
            List<AccountInfo> infoList = new ArrayList<>();
            for (int i = 0; i < home.accountList.GetSize(); i++) {
                AccountInfo info = new AccountInfo(home.accountList.GetAccount(i));
                infoList.add(info);
            }
            File file = new File("Accounts.json");
            JSONWriter jsonWriter = new JSONWriter(file, infoList);
            jsonWriter.jsonWrite();
            new Login(accountList);
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

}
