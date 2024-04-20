package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Controller.Controller;
import Model.Driver;

public class ListVerifikasiDriver {

    public ListVerifikasiDriver() {
        showResult();
    }

    private void showResult() {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // list of promo yang di get pakai controller
        ArrayList<Driver> waitingList = Controller.getInstance().getWaitingDriver(0);

        Font font = new Font("Courier", Font.BOLD, 20);
        Font font2 = new Font("Courier", Font.PLAIN, 14);
        Font font3 = new Font("Courier", Font.PLAIN, 18);
        Font font4 = new Font("Courier", Font.BOLD, 14);

        JLabel intro = new JLabel("Daftar List Driver.");
        intro.setFont(font);
        intro.setBounds(30, 70, 400, 30);

        Font fontButton = new Font("Courier", Font.BOLD, 13);

        JLabel lineDiv = new JLabel("__________________________________"
                + "__________________________________________________"
                + "__________________________________________________"
                + "___________________________");

        lineDiv.setBounds(10, 100, 460, 20);

        if (waitingList.isEmpty()) {
            JLabel ingpo = new JLabel("Yah... belum ada yang daftar :'(");
            ingpo.setFont(font3);
            ingpo.setBounds(110, 300, 400, 30);
            f.add(ingpo);
        }

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(20, 130, 445, 420);
        f.getContentPane().add(scrollPane);

        JPanel containerOrder = new JPanel();
        scrollPane.setViewportView(containerOrder);
        containerOrder.setLayout(new BorderLayout(0, 0));

        JPanel promoContainer = new JPanel();
        containerOrder.add(promoContainer, BorderLayout.NORTH);
        promoContainer.setLayout(new GridLayout(0, 1, 0, 1));
        promoContainer.setBackground(Color.gray);

        for (Driver wait : waitingList) {
            JPanel promoPanel = new JPanel();
            promoPanel.setFont(font2);
            promoPanel.setPreferredSize(new Dimension(300, 60));
            promoContainer.add(promoPanel);
            promoPanel.setLayout(null);

            promoPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));

            JLabel username = new JLabel("Username: " + wait.getName());
            username.setFont(font4);
            username.setBounds(10, 5, 200, 25);
            username.setBorder(null);
            promoPanel.add(username);

            JLabel phonNum = new JLabel(wait.getPhonNum());
            phonNum.setBounds(343, 5, 70, 20);
            phonNum.setBorder(null);
            promoPanel.add(phonNum);

            JLabel vehicle = new JLabel("Kendaraan: " + wait.getVehicle_name());
            vehicle.setBounds(10, 30, 155, 25);
            vehicle.setBorder(null);
            promoPanel.add(vehicle);

            JLabel plate = new JLabel(wait.getVehicle_plate());
            plate.setBounds(170, 30, 150, 25);
            plate.setBorder(null);
            promoPanel.add(plate);

            JLabel type = new JLabel(wait.getVehicle_type());
            type.setBounds(270, 30, 80, 25);
            type.setBorder(null);
            promoPanel.add(type);

            JButton deleteBtn = new JButton("Veriffikasi");
            deleteBtn.setBounds(330, 28, 90, 25);
            deleteBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int choice = JOptionPane.showConfirmDialog(null, "Verifikasi?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                    if (choice == JOptionPane.YES_OPTION) {
                        boolean succeed = Controller.getInstance().inputUserDataToDB(wait.getName(), wait.getPassword(), "Driver");
                        if (succeed) {
                            int id = Controller.getInstance().getIDUser(wait.getName());
                            boolean succeedDriver = Controller.getInstance().inputDriverDataToDB(id, wait.getPhonNum(), wait.getVehicle_name(), wait.getVehicle_type(), wait.getVehicle_plate());
                            boolean succeedDelete = Controller.getInstance().deleteWaitingDriver(wait.getName());
                            if (succeedDriver && succeedDelete) {
                                JOptionPane.showMessageDialog(f, "Data berhasil diverify");
                                new ListVerifikasiDriver();
                                f.dispose();
                            } else {
                                JOptionPane.showMessageDialog(f, "Data gagal Disimpan", "", JOptionPane.WARNING_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(f, "Data gagal Disimpan", "", JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Batal di verifikasi.", "", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            });
            promoPanel.add(deleteBtn);
        }

        JButton backButton = new JButton("Kembali");
        backButton.setFont(fontButton);
        backButton.setBounds(10, 10, 85, 30);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new MainMenuAdmin();
            }
        });

        f.add((intro));

        f.add(backButton);
        f.add(lineDiv);

        f.setSize(500, 600);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

}
