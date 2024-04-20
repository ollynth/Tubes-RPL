package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controller.Controller;

public class RegistrasiDriver {

    public RegistrasiDriver(String username, String password, String roles) {
        form(username, password, roles);
    }

    private void form(String username, String password, String roles) {
        JFrame f = new JFrame("Form Registrasi Driver");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel intro = new JLabel("Selamat Datang di Josen!");
        Font font = new Font("Courier", Font.BOLD, 20);
        JLabel intro2 = new JLabel("Silahkan nomor telepon dan data kendaraan");
        Font font2 = new Font("Courier", Font.PLAIN, 16);
        intro.setFont(font);
        intro2.setFont(font2);
        intro.setBounds(10, 10, 300, 30);
        intro2.setBounds(10, 30, 350, 30);

        Font fontLabel = new Font("Courier", Font.BOLD, 16);

        JLabel labelTelepon = new JLabel("Nomor  Telepon ");
        JTextField textTelepon = new JTextField();
        labelTelepon.setFont(fontLabel);
        labelTelepon.setBounds(10, 80, 200, 30);
        textTelepon.setBounds(200, 80, 250, 30);

        JLabel labelNama = new JLabel("Nama Kendaraan ");
        JTextField textNama = new JTextField();
        labelNama.setFont(fontLabel);
        labelNama.setBounds(10, 110, 200, 30);
        textNama.setBounds(200, 110, 250, 30);

        JLabel labelPlat = new JLabel("Plat Nomor Kendaraan ");
        JTextField textPlat = new JTextField();
        labelPlat.setFont(fontLabel);
        labelPlat.setBounds(10, 140, 200, 30);
        textPlat.setBounds(200, 140, 250, 30);

        JLabel labelJenis = new JLabel("Category: ");
        String listCategory[] = {"Mobil", "Motor"};
        JComboBox boxJenis = new JComboBox(listCategory);
        boxJenis.setSelectedItem(null);
        labelJenis.setFont(fontLabel);
        labelJenis.setBounds(10, 170, 200, 30);
        boxJenis.setBounds(200, 170, 250, 30);

        //tombol submit
        JButton insertData = new JButton("Submit");
        insertData.setBounds(260, 300, 150, 30);
        insertData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String telepon = textTelepon.getText();
                String namaKendaraan = textNama.getText();
                String plat = textPlat.getText();
                String jenis = boxJenis.getSelectedItem().toString();

                if (telepon.isEmpty() || namaKendaraan.isEmpty() || plat.isEmpty() || jenis.isEmpty()) {
                    JOptionPane.showMessageDialog(f, "Data belum lengkap nih", "", JOptionPane.WARNING_MESSAGE);
                } else {

                    boolean succeedDriver = Controller.getInstance().inputDriverDataToWaitingList(username, password, telepon, namaKendaraan, jenis, plat);
                    if (succeedDriver) {
                        JOptionPane.showMessageDialog(f, "Data berhasil ditambahkan. Silahkan kembali ke menu utama.");
                        new StartMenu();
                        f.dispose();
                    } else {
                        JOptionPane.showMessageDialog(f, "Data gagal Disimpan", "", JOptionPane.WARNING_MESSAGE);
                    }

                }

            }
        });
        f.add(insertData);

        JButton backButton = new JButton("Back");

        backButton.setBounds(60, 300, 150, 30);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new Registrasi();
            }
        }
        );

        f.add(intro);
        f.add(intro2);

        f.add(labelTelepon);
        f.add(textTelepon);
        f.add(labelNama);
        f.add(textNama);
        f.add(labelPlat);
        f.add(textPlat);
        f.add(labelJenis);
        f.add(boxJenis);

        f.setLocationRelativeTo(null);
        f.setSize(500, 400);
        f.setLayout(null);
        f.setVisible(true);
        f.add(backButton);
    }

}
