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

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static controller.Login.isDigit;
import static controller.Login.isNull;

public class SendMoney extends JFrame {
    private JPanel contentPane;
    private Image image_logo = new ImageIcon(SendMoney.class.getResource("../image/logo.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
    private JTextField textField_2; //Nội dung chuyển
    private JTextField textField; //số tiền chuyển
    private JTextField textField_1; //Chuyển đến tài khoản
    private JLabel lblHome; //Trang chu
    private JLabel lblChuynKhon; //Chuyển khoản
    private JLabel lblLsGiaoDch; //Lịch sử giao dịch
    private JLabel lblngXut; //Gửi tiết kiệm
    private JLabel lblNpTin; //Nạp tiền
    private JLabel lblngXut_1_1; //Đăng xuất
    private JLabel lbVayTien;//Vay tiền
    private JLabel lbsoTk;
    private JLabel lblVnd;
    private Home home;
    private SendMoney sendMoney;


    /**
     * Launch the application.
     */

    /**
     * Create the frame.
     */
    public SendMoney(Home home) {
        this.home = home;
        sendMoney = this;
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
        lblChuynKhon.setForeground(new Color(255, 255, 0));
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

        JLabel lblChuynTrongNgn = new JLabel("Chuyển tiền");
        lblChuynTrongNgn.setBounds(177, 11, 177, 14);
        contentPane.add(lblChuynTrongNgn);

        JLabel lblTTiKhon = new JLabel("Từ tài khoản");
        lblTTiKhon.setBounds(177, 36, 89, 14);
        contentPane.add(lblTTiKhon);

        lbsoTk = new JLabel("102967951345");
        lbsoTk.setBounds(177, 66, 89, 14);
        contentPane.add(lbsoTk);

        lblVnd = new JLabel("6,850,000 VND");
        lblVnd.setBounds(177, 91, 112, 14);
        contentPane.add(lblVnd);

        JSeparator separator = new JSeparator();
        separator.setBounds(177, 126, 420, 2);
        contentPane.add(separator);

        JLabel lblnTiKhon = new JLabel("Đến số điện thoại");
        lblnTiKhon.setBounds(177, 139, 102, 14);
        contentPane.add(lblnTiKhon);

        JLabel lblSTin = new JLabel("Số tiền (VND)");
        lblSTin.setBounds(177, 216, 106, 14);
        contentPane.add(lblSTin);

        textField_2 = new JTextField();
        textField_2.setBorder(null);
        textField_2.setBounds(177, 315, 404, 20);
        contentPane.add(textField_2);
        textField_2.setColumns(10);

        JLabel lblNiDungChuyn = new JLabel("Nội dung chuyển");
        lblNiDungChuyn.setBounds(177, 290, 112, 14);
        contentPane.add(lblNiDungChuyn);

        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(177, 335, 420, 14);
        contentPane.add(separator_1);

        textField = new JTextField();
        textField.setColumns(10);
        textField.setBorder(null);
        textField.setBounds(177, 241, 404, 20);
        contentPane.add(textField);

        JSeparator separator_1_1 = new JSeparator();
        separator_1_1.setBounds(177, 265, 420, 14);
        contentPane.add(separator_1_1);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBorder(null);
        textField_1.setBounds(177, 164, 404, 20);
        contentPane.add(textField_1);

        JSeparator separator_1_2 = new JSeparator();
        separator_1_2.setBounds(177, 184, 420, 14);
        contentPane.add(separator_1_2);

        JButton btnNewButton = new JButton("Chuyển tiền");
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBackground(new Color(0, 128, 128));
        //TODO:Thực hiện chuyển tiền ở đây
        btnNewButton.addActionListener(e -> {
            boolean isContinue = true;
            try{
                isError();
            } catch (BankException err){
                String message = err.errMessage;
                JOptionPane.showMessageDialog(null,message);
                isContinue = false;
            }

            if (isContinue) {
                System.out.println("Chạy đc rồi!");
                //TODO: Thực hiện giao dịch chuyển tiền ở đây với soTK và soTien đã
                try {
                    if(home.accountList.PasswordCheck(getSoTK())){
                        JOptionPane.showMessageDialog(null,
                                home.currentAccount.transfer(getSoTienInt(), home.currentAccount, home.accountList.GetAccount(home.accountList.GetCurrentIndex())));
                    } else  JOptionPane.showMessageDialog(null,"Không có tài khoản trong cơ sở dữ liệu");

                    //TODO: Không rõ cách lấy Account đến kiểu gì dựa trên số tk nhập vào (lấy bằng getSoTK),
                     //TODO: Get Account dựa trên index hình như là stt trên Accountlist không phải số tài khoản
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }

                updateTT();
            }
        });
        btnNewButton.setBounds(177, 391, 420, 23);
        contentPane.add(btnNewButton);
        buildListener();
        updateTT();
        setVisible(true);

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
        lbsoTk.setText(String.valueOf(home.currentAccount.accountNumber));
    }

    //isError
    public void isError() throws BankException{
        soTkError();
        soTienError();
    }
    public void soTkError() throws BankException{
        String sotk = textField_1.getText().trim();
        if(!isDigit(sotk)) throw new BankException("Số tài khoản có kí tự không hợp lệ!");
        if(isNull(sotk)) throw new BankException("Không được để trống số tài khoản!");
    }
    public void soTienError() throws BankException{
        String sotien = textField.getText().trim();
        if(isNull(sotien)) throw new BankException("Không được để trống số tiền!");
        if(!isDigit(sotien)) throw new BankException("Số tiền có kí tự không hợp lệ!");
        //TODO: so sánh số dư hiện tại với số tiền muốn chuyển, nếu bé hơn thì báo lỗi ở dưới
//        if(getSoTienInt()>balance) {
//            throw new BankException("Số tiền hiện có không đủ để thực hiện giao dịch!");
//        }
    }

    //getter
    public int getSoTienInt() {
        return Integer.parseInt(textField.getText().trim());
    }

    public String getSoTK() {
        return textField_1.getText().trim();
    }

    public String getND() {
        return textField_2.getText().trim();
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
            sendMoney.dispose();
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
            sendMoney.dispose();
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
            sendMoney.dispose();
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
            sendMoney.dispose();
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
            sendMoney.dispose();
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
            sendMoney.dispose();
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
