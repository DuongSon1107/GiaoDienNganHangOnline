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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class History extends JFrame {

    private JPanel contentPane;
    private Image image_logo = new ImageIcon(Login.class.getResource("../image/logo.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
    private JLabel lblChuynKhon; //Chuyển khoản
    private JLabel lblLsGiaoDch; //Lịch sử giao dịch
    private JLabel lblngXut; //Gửi tiết kiệm
    private JLabel lblNpTin; //Nạp tiền
    private JLabel lblngXut_1_1; //Đăng xuất
    private JLabel lbVayTien;//Vay tiền
    private JLabel lblHome; //Trang chu
    private JLabel lbTen;
    private JLabel lbSotk;
    private JLabel lblSDKh;
    private JLabel lblVnd; //Số dư khả dụng
    private JLabel lblVnd_2;// Số dư
    private Home home;
    private History history;


    /**
     * Launch the application.
     */

    /**
     * Create the frame.
     */
    public History(Home home) {
        this.home = home;
        history = this;

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
        contentPane.setBackground(Color.WHITE);
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
        lblLsGiaoDch.setForeground(new Color(255, 255, 0));
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
        panel_1.setBackground(new Color(0, 128, 128));
        panel_1.setBounds(170, 0, 496, 146);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        Panel panel_2 = new Panel();
        panel_2.setBackground(new Color(255, 255, 255));
        panel_2.setBounds(10, 10, 476, 50);
        panel_1.add(panel_2);
        panel_2.setLayout(null);

        lbTen = new JLabel("LE TUAN TU");
        lbTen.setFont(new Font("Tahoma", Font.BOLD, 17));
        lbTen.setBounds(10, 8, 131, 14);
        panel_2.add(lbTen);

        lbSotk = new JLabel("102967951345");
        lbSotk.setForeground(new Color(0, 128, 128));
        lbSotk.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lbSotk.setBounds(10, 27, 101, 14);
        panel_2.add(lbSotk);

        lblSDKh = new JLabel("Số dư khả dụng");
        lblSDKh.setForeground(new Color(255, 255, 255));
        lblSDKh.setBounds(10, 68, 124, 14);
        panel_1.add(lblSDKh);

        lblVnd = new JLabel("6,850,000 VND");
        lblVnd.setForeground(new Color(255, 255, 255));
        lblVnd.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblVnd.setBounds(10, 93, 210, 14);
        panel_1.add(lblVnd);

        JLabel lblSDTi = new JLabel("Số dư tài khoản");
        lblSDTi.setForeground(Color.WHITE);
        lblSDTi.setBounds(266, 68, 124, 14);
        panel_1.add(lblSDTi);

        lblVnd_2 = new JLabel("6,900,000 VND");
        lblVnd_2.setForeground(Color.WHITE);
        lblVnd_2.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblVnd_2.setBounds(266, 93, 169, 14);
        panel_1.add(lblVnd_2);

        JButton btnChuynNgoiNgn = new JButton("Chuyển ngoài ngân hàng");
        btnChuynNgoiNgn.setBackground(new Color(0, 128, 128));
        btnChuynNgoiNgn.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnChuynNgoiNgn.setForeground(new Color(255, 255, 255));
        btnChuynNgoiNgn.setBounds(199, 169, 234, 23);
        contentPane.add(btnChuynNgoiNgn);

        JButton btnThanhTonQr = new JButton("Thanh toán QR");
        btnThanhTonQr.setBackground(new Color(230, 230, 250));
        btnThanhTonQr.setBounds(469, 170, 165, 23);
        contentPane.add(btnThanhTonQr);

        JLabel lblGiaoDch = new JLabel("Giao dịch 3 tháng gần đây");
        lblGiaoDch.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblGiaoDch.setBounds(199, 200, 277, 14);
        contentPane.add(lblGiaoDch);

        JSeparator separator = new JSeparator();
        separator.setBounds(170, 226, 496, 2);
        contentPane.add(separator);

        JTextArea lsgdTxtA = new JTextArea(20,40);
        lsgdTxtA.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(lsgdTxtA);
        scrollPane.setBorder(null);
        scrollPane.setBackground(new Color(255, 255, 255));
        scrollPane.setBounds(170, 239, 496, 264);
        contentPane.add(scrollPane);

        //TODO:Ghi Thông tin giao dịch ở đây
        StringBuilder lsgdStr = new StringBuilder();
        List lsgd = home.currentAccount.GetTransactionHistory();
        for(Object obj : lsgd) {
            lsgdStr.append(obj.toString()+"\n");
        }

        lsgdTxtA.setText(lsgdStr.toString());

//        JScrollBar scrollBar = new JScrollBar();
//        scrollPane.setRowHeaderView(scrollBar);

//        Panel panel_3 = new Panel();
////        panel_3.setBounds(new Rectangle(0, 0, 11, 0));
////        scrollPane.setViewportView(panel_3);
//        panel_3.setLayout(new FlowLayout());
//        panel_3.add(lsgdTxtA);

//        JLabel label_1 = new JLabel("26/01/2022 20:57:26");
//        label_1.setBounds(10, 11, 143, 14);
//        panel_3.add(label_1);
//
//        JLabel lblSTin = new JLabel("Số tiền");
//        lblSTin.setForeground(new Color(128, 128, 128));
//        lblSTin.setBounds(10, 36, 70, 14);
//        panel_3.add(lblSTin);
//
//        JLabel lblSD = new JLabel("Số dư");
//        lblSD.setForeground(new Color(128, 128, 128));
//        lblSD.setBounds(10, 61, 46, 14);
//        panel_3.add(lblSD);
//
//        JLabel label_1_1 = new JLabel("CT DEN:1981651304");
//        label_1_1.setForeground(new Color(128, 128, 128));
//        label_1_1.setBounds(276, 11, 143, 14);
//        panel_3.add(label_1_1);
//
//        JLabel lblVnd_1 = new JLabel("+300,000 VND");
//        lblVnd_1.setFont(new Font("Tahoma", Font.BOLD, 11));
//        lblVnd_1.setForeground(new Color(0, 128, 128));
//        lblVnd_1.setBounds(276, 36, 166, 14);
//        panel_3.add(lblVnd_1);
//
//        JLabel lblVnd_3 = new JLabel("6,900,000 VND");
//        lblVnd_3.setForeground(new Color(128, 128, 128));
//        lblVnd_3.setBounds(276, 61, 96, 14);
//        panel_3.add(lblVnd_3);

        buildListener();
        updateTT();
        setVisible(true);

    }
    //update
    public void updateTT() {
        updateTen();
        updateSodu();
        updateSoduKhaDung();
        updateSoTk();
    }
    public void updateTen() {
//        String ten = TODO: Nhận vào tên người dùng
        lbTen.setText(home.currentAccount.userName);

    }

    public void updateSodu() {
//        int soDu = TODO: Nhận vào số dư ở đây Vd: obj.balance hay bất cứ hàm get quần què gì đấy!
        String soduTxt = String.format("%,.0f VND",home.currentAccount.GetBalance());
        lblVnd_2.setText(soduTxt);

    }

    public void updateSoduKhaDung() {
//        int soDu = TODO: Nhận vào số dư ở đây Vd: obj.balance hay bất cứ hàm get quần què gì đấy!
//        int soDuKD = sodu - 50000;
        String soDuKDTxT = String.format("%,.0f VND",home.currentAccount.GetBalance()-50000);
        lblVnd.setText(soDuKDTxT);
    }

    public void updateSoTk() {
//        int soTK = TODO: Nhận vào số tk ở đây, String hay int tuỳ thuộc
        lbSotk.setText(String.valueOf(home.currentAccount.accountNumber));
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
            history.dispose();
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
            history.dispose();
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
            history.dispose();
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
            history.dispose();
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
            history.dispose();
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
            history.dispose();
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
