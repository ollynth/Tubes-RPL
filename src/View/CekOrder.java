package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Controller.Controller;

public class CekOrder {

    public CekOrder(int id) {
        showDataScreen(id);
    }

    private void showDataScreen(int id) {
        JFrame f = new JFrame();

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Font font = new Font("Courier", Font.BOLD, 20);
        Font font2 = new Font("Courier", Font.PLAIN, 16);
        
        JLabel intro = new JLabel("Pesanan.");
        intro.setFont(font);
        intro.setBounds(30, 70, 400, 30);
        JLabel intro2 = new JLabel("Yang kamu order ada disini kok");
        intro2.setFont(font2);
        intro2.setBounds(30, 95, 300, 30);


        Font fontButton = new Font("Courier", Font.BOLD, 14);
        Font fontBack = new Font("Courier", Font.BOLD, 12);


        JLabel lineDiv = new JLabel("_______________________________"
                + "__________________________________________");
        lineDiv.setBounds(10, 120, 500, 20);

        JButton berjalan = new JButton("Dalam Proses");
        berjalan.setFont(fontButton);
        berjalan.setBounds(60, 280, 350, 30);
        berjalan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new OrderBerjalan(id);
            }
        });

        JButton riwayat = new JButton("Riwayat");
        riwayat.setFont(fontButton);
        riwayat.setBounds(60, 330, 350, 30);
        riwayat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new OrderRiwayat(id);
            }
        });

        JButton backButton = new JButton("Kembali");
        backButton.setFont(fontBack);
        backButton.setBounds(10, 10, 85, 30);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                String role = Controller.getInstance().getRolesUser(id);
                if(role.equalsIgnoreCase("Passanger")){
                    new MainMenuPassanger(id);
                } else if (role.equalsIgnoreCase("Driver")){
                    new MainMenuDriver(id);
                }
                
            }
        });

        f.add((backButton));

        f.add((intro));
        f.add((intro2));
        f.add(lineDiv);

        f.add(berjalan);
        f.add(riwayat);

        f.setSize(500, 600);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
    

}
