package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controller.Controller;

public class FindOrder {

    public FindOrder() {
        showDataScreen();
    }

    private void showDataScreen() {
        JFrame f = new JFrame();

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font = new Font("Courier", Font.BOLD, 20);
        Font font2 = new Font("Courier", Font.PLAIN, 16);
        
        JLabel intro = new JLabel("Cari Order.");
        intro.setFont(font);
        intro.setBounds(30, 70, 400, 30);
        JLabel intro2 = new JLabel("Cari semua orderan user");
        intro2.setFont(font2);
        intro2.setBounds(30, 95, 300, 30);


        Font fontButton = new Font("Courier", Font.BOLD, 14);
        Font fontBack = new Font("Courier", Font.BOLD, 12);


        JLabel lineDiv = new JLabel("_______________________________"
                + "__________________________________________");
        lineDiv.setBounds(10, 120, 500, 20);

        JLabel idOrder = new JLabel("Masukkan ID Order : ");
        idOrder.setBounds(30, 160, 200, 30);
        JTextField inputOrder = new JTextField();
        inputOrder.setBounds(255, 160, 200, 30);
        JButton buttonCari = new JButton("Cari");
        buttonCari.setFont(fontButton);
        buttonCari.setBounds(40, 515, 400, 30);
        buttonCari.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String thisID = inputOrder.getText();
                int getID = Integer.parseInt(thisID);
                boolean found = Controller.getInstance().getOrder(getID);
                if (found) {
                    f.dispose();
                    new DetailOrderAdmin(1, getID, 0);
                } else {
                    JOptionPane.showMessageDialog(f, "Order tidak ditemukan", "Huff", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        JButton backButton = new JButton("Kembali");
        backButton.setFont(fontBack);
        backButton.setBounds(10, 10, 85, 30);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new MainMenuAdmin();
            }
        });

        f.add((backButton));

        f.add((intro));
        f.add((intro2));
        f.add(lineDiv);

        f.add(idOrder);
        f.add(inputOrder);
        f.add(buttonCari);

        f.setSize(500, 600);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
