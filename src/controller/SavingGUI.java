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

import java.awt.Choice;
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

import Account.Save;
import javax.swing.*;

import static controller.Login.isDigit;
import static controller.Login.isNull;

public class SavingGUI extends JFrame {
    public AccountList accountList;
    public void SetAccountList(AccountList setAccountList){
        accountList = setAccountList;
    }
    public Account currentAccount;

    private JPanel contentPane;
    private Image image_logo = new ImageIcon(Login.class.getResource("../image/logo.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
    private JTextField textField;
    private JLabel lblChuynKhon; //Chuyển khoản
    private JLabel lblLsGiaoDch; //Lịch sử giao dịch
    private JLabel lblngXut; //Gửi tiết kiệm
    private JLabel lblNpTin; //Nạp tiền
    private JLabel lblngXut_1_1; //Đăng xuất
    private JLabel lbVayTien;//Vay tiền
    private JLabel lblHome; //TRang chu
    private JLabel lblTiKhonThanh;
    private JLabel lblVnd;
    private JLabel lblNm;
    private JLabel lblNm_1;
    private Home home;
    private SavingGUI savingGUI;
    public Login login;
    public Save saving;

    /**
     * Launch the application.
     */


    /**
     * Create the frame.
     */
    public SavingGUI(Home home) {
        this.home = home;
        savingGUI = this;
        this.currentAccount = home.currentAccount;
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
        contentPane.setBorder(null);
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
        lblngXut.setForeground(new Color(255, 255, 0));
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
        panel_1.setBounds(171, 0, 495, 74);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblGiTitKim = new JLabel("Gửi tiết kiệm trực tuyến");
        lblGiTitKim.setBounds(70, 22, 377, 29);
        lblGiTitKim.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblGiTitKim.setForeground(new Color(255, 255, 255));
        panel_1.add(lblGiTitKim);

        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setBackground(new Color(255, 255, 255));
        comboBox.setBounds(182, 125, 475, 20);
        contentPane.add(comboBox);

        //TODO: Thêm lựa chọn kì hạn ở đây
        comboBox.addItem("3 tháng"); //thử
        comboBox.addItem("6 Tháng"); //thử
        comboBox.addItem("1 năm"); //thử
        comboBox.addItemListener(e -> {
            if(comboBox.getSelectedIndex()==0){
                lblNm.setText("0.3%/3 tháng");
                lblNm_1.setText("0.3%/3 tháng");
            } else if (comboBox.getSelectedIndex()==1) {
                lblNm.setText("0.6%/6 tháng");
                lblNm_1.setText("0.3%/6 tháng");
            } else if (comboBox.getSelectedIndex()==2) {
                lblNm.setText("1%/1 năm");
                lblNm_1.setText("1%/1 năm");
            }
        });

        JSeparator separator = new JSeparator();
        separator.setBounds(171, 161, 496, 2);
        contentPane.add(separator);

        JLabel lblChnKHn = new JLabel("Chọn kì hạn");
        lblChnKHn.setBounds(183, 99, 75, 20);
        contentPane.add(lblChnKHn);

        JLabel lblLiSut = new JLabel("Lãi suất");
        lblLiSut.setBounds(185, 174, 46, 14);
        contentPane.add(lblLiSut);

        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(170, 199, 496, 2);
        contentPane.add(separator_1);

        lblNm = new JLabel("0.3%/3 tháng");
        lblNm.setBounds(570, 174, 75, 14);
        contentPane.add(lblNm);

        JLabel lblLiSut_1 = new JLabel("Lãi suất");
        lblLiSut_1.setBounds(185, 214, 46, 14);
        contentPane.add(lblLiSut_1);

         lblNm_1 = new JLabel("0.3%/3 tháng");
        lblNm_1.setBounds(570, 214, 75, 14);
        contentPane.add(lblNm_1);

        JSeparator separator_1_1 = new JSeparator();
        separator_1_1.setBounds(171, 239, 496, 2);
        contentPane.add(separator_1_1);

        JSeparator separator_1_2 = new JSeparator();
        separator_1_2.setBounds(170, 279, 496, 2);
        contentPane.add(separator_1_2);

        JLabel lblPhngThcTr = new JLabel("Phương thức trả lãi");
        lblPhngThcTr.setBounds(185, 254, 131, 14);
        contentPane.add(lblPhngThcTr);

        JLabel lblLiNhpGc = new JLabel("Lãi nhập gốc");
        lblLiNhpGc.setBounds(570, 254, 75, 14);
        contentPane.add(lblLiNhpGc);

        Panel panel_2 = new Panel();
        panel_2.setBackground(UIManager.getColor("Button.darkShadow"));
        panel_2.setBounds(171, 279, 495, 20);
        contentPane.add(panel_2);
        panel_2.setLayout(null);

        JLabel lblTTiKhon = new JLabel("Từ tài khoản");
        lblTTiKhon.setBounds(185, 305, 113, 14);
        contentPane.add(lblTTiKhon);

        lblTiKhonThanh = new JLabel("Tài khoản thanh toán: 102968791345");
        lblTiKhonThanh.setForeground(new Color(0, 128, 128));
        lblTiKhonThanh.setBounds(185, 334, 247, 14);
        contentPane.add(lblTiKhonThanh);

        lblVnd = new JLabel("8,950,000 VND");
        lblVnd.setBounds(185, 360, 131, 14);
        contentPane.add(lblVnd);

        Panel panel_2_1 = new Panel();
        panel_2_1.setLayout(null);
        panel_2_1.setBackground(UIManager.getColor("Button.darkShadow"));
        panel_2_1.setBounds(171, 380, 495, 20);
        contentPane.add(panel_2_1);

        textField = new JTextField();
        textField.setBorder(null);
        textField.setBounds(177, 432, 479, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblSTin = new JLabel("Số tiền (VND)");
        lblSTin.setBounds(177, 407, 106, 14);
        contentPane.add(lblSTin);

        JSeparator separator_2 = new JSeparator();
        separator_2.setBounds(177, 454, 479, 2);
        contentPane.add(separator_2);

        JButton btnNpTin = new JButton("Nộp tiền");
        btnNpTin.setForeground(new Color(255, 255, 255));
        btnNpTin.setBackground(new Color(0, 128, 128));
        btnNpTin.setBounds(362, 463, 89, 23);
        contentPane.add(btnNpTin);
        //TODO:Thực hiện gửi tiết kiệm ở đây
        btnNpTin.addActionListener(e -> {
            boolean isContinue = true;
            try{
                isError();
                if(getSoTienInt()>home.currentAccount.balance) throw new BankException("Số tiển muốn gửi vượt quá số dư hiện tại");
            } catch (BankException err){
                String message = err.errMessage;
                JOptionPane.showMessageDialog(null,message);
                isContinue = false;
            }

            if (isContinue) {
                int thang = 3;
                double laisuat = 0.003;
                //TODO lôi dữ liệu balance rồi trừ đi số tiền muốn nạp, check nếu tiết kiệm nhiều hơn có trong balance
                System.out.println("Chạy đc rồi!");
                //TODO: Thực hiện gửi tiết kiệm dựa trên số tiền soTienTK
                if(comboBox.getSelectedIndex()==0){
                    thang =3;
                    laisuat = 0.003;
                } else if (comboBox.getSelectedIndex()==1) {
                    thang =6;
                    laisuat = 0.006;
                } else if (comboBox.getSelectedIndex()==2) {
                    thang =12;
                    laisuat = 0.01;
                }

                Save saving = new Save(1,thang,laisuat,getSoTienInt());
                try {
                    home.currentAccount.saveMoney(saving);
                    JOptionPane.showMessageDialog(null,"Giao dịch thành công");
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }

                updateTT();


            }
        });

        buildListener();
        updateTT();
        setVisible(true);

    }

    //getter
    public int getSoTienInt() {
        return Integer.parseInt(textField.getText().trim());
    }

    //isError
    public void isError() throws BankException{
        isSoTienError();
    }

    public void isSoTienError() throws  BankException{
        textField.getText().trim();
        String sotien = textField.getText().trim();
        if(isNull(sotien)) throw new BankException("Không được để trống số tiền!");
        if(!isDigit(sotien)) throw new BankException("Số tiền có kí tự không hợp lệ!");
    }

    //update
    public void updateTT() {
        updateSodu();
        updateSoTk();
    }
    public void updateSodu() {
//        int soDu = TODO: Nhận vào số dư ở đây Vd: obj.balance hay bất cứ hàm get quần què gì đấy!
        String soduTxt = String.format("%,.0f VND",home.currentAccount.GetBalance());
        lblVnd.setText(soduTxt);

    }

    public void updateSoTk() {
//        int soTK = TODO: Nhận vào số tk ở đây, String hay int tuỳ thuộc
        lblTiKhonThanh.setText(String.valueOf(home.currentAccount.accountNumber));
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
            savingGUI.dispose();
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
            savingGUI.dispose();
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
            savingGUI.dispose();
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
            savingGUI.dispose();
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
            savingGUI.dispose();
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
            savingGUI.dispose();
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
