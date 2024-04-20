package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Controller.Controller;
import Model.Driver;

public class MainMenuDriver {

    public MainMenuDriver(int id) {
        showDataScreen(id);
    }
    protected Driver drv;
    
    private void showDataScreen(int id) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        drv = Controller.getInstance().getDriverByID(id).get(0);

        String nameDisplay = Controller.getInstance().getUsername(id);

        JLabel intro = new JLabel("Selamat Datang di Josen " + nameDisplay + "!");
        Font font = new Font("Courier", Font.BOLD, 20);
        JLabel intro2 = new JLabel("Mau antar penumpang kemana hari ini ges?");
        Font font2 = new Font("Courier", Font.PLAIN, 16);
        intro.setFont(font);
        intro2.setFont(font2);
        intro.setBounds(10, 10, 400, 30);
        intro2.setBounds(10, 30, 470, 30);

        Font fontButton = new Font("Courier", Font.BOLD, 12);

        JLabel lineDiv = new JLabel("_______________________________"
                + "__________________________________________");
        lineDiv.setBounds(10, 50, 500, 20);

        JButton profileButton = new JButton("Check Profil");
        profileButton.setFont(fontButton);
        profileButton.setBounds(10, 80, 470, 30);
        profileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new DriverProfile(drv);
            }
        });

        JLabel border = new JLabel();
        border.setBorder(BorderFactory.createLineBorder(Color.black));
        border.setBounds(30, 135, 425, 60);

        String strSaldo = String.valueOf(Controller.getInstance().getWallet(id));
        if (Controller.getInstance().getWallet(id) > 9999999) {
            strSaldo = "9999999+";
        }

        JLabel wallet = new JLabel("JOPAY: Rp. " + strSaldo);
        wallet.setFont(font2);
        wallet.setBounds(50, 150, 800, 30);
        wallet.setBackground(null);

        JButton topUp = new JButton("Top Up");
        topUp.setFont(fontButton);
        topUp.setBounds(340, 150, 100, 30);
        topUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new MenuTopUp(id);
                f.dispose();
            }
        });
      
        JButton inbox = new JButton("Inbox");
        inbox.setFont(fontButton);
        inbox.setBounds(70, 230, 140, 30);
        inbox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new InboxDriver(id);
            }
        });

        // button buat liat history
        JButton historyOrder = new JButton("Lihat Pesanan");
        historyOrder.setFont(fontButton);
        historyOrder.setBounds(250, 230, 170, 30);
        historyOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new CekOrder(id);
            }
        });

        //button buat tarik dana
        JButton tarikDanaButton = new JButton("Tarik Dana");
        tarikDanaButton.setFont(fontButton);
        tarikDanaButton.setBounds(70, 320, 350, 30);
        tarikDanaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new TarikDana(drv);
            }
        });

        // button buat cek pendapatan
        JButton cekPendapatanBtn =  new JButton("Cek Pendapatan Driver");
        cekPendapatanBtn.setFont(fontButton);
        cekPendapatanBtn.setBounds(70, 360, 350, 30);
        cekPendapatanBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new CekPendapatanDriver(id);
            }
        });

        //button for swithcing status
        JButton switchStatus = new JButton(Controller.getInstance().getSwitchStatusText(id));
        switchStatus.setFont(fontButton);
        switchStatus.setBounds(70, 410, 350, 30);
        switchStatus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String state = Controller.getInstance().getDriverStat(drv.getDriver_id());
                drv.setStateDriver(state);
                state = drv.updateState(state);
                boolean success = Controller.getInstance().updateDriverStatus(id, state);
                if (success == true) {
                    JOptionPane.showMessageDialog(null, "Status Berhasil Diubah!", "Yeay", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Status Gagal Diubah!", "Upss", JOptionPane.ERROR_MESSAGE);
                }
                f.dispose();
                    new MainMenuDriver(id);
            }
        });

        String statDrv =  Controller.getInstance().getDriverStat(id);
        if (statDrv.equals("BOOKED")) {
            switchStatus.setEnabled(false); // Disable the button
        } else {
            switchStatus.setEnabled(true); // Enable the button
        }

        // back button
        JButton backButton = new JButton("Back to Main Menu");
        backButton.setBounds(170, 350, 150, 30);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                f.dispose();
            }
        });
        
        // logout button
        JButton logOut = new JButton("Log out");
        logOut.setFont(fontButton);
        logOut.setBounds(340, 500, 100, 30);
        logOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new StartMenu();
            }
        });

        f.add((intro));
        f.add((intro2));
        f.add(border);
        f.add(wallet);
        f.add(topUp);
        f.add(profileButton);
        f.add(cekPendapatanBtn);
        f.add(lineDiv);

        f.add(inbox);
        f.add(historyOrder);
        f.add(tarikDanaButton);
        f.add(switchStatus);
        f.add(logOut);

        f.setSize(500, 600);
        f.setLayout(null);

        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
 
    public static void main(String[] args) {
        new MainMenuDriver(6);
    }
}
