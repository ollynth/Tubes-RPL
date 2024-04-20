package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import Controller.Controller;

public class GantiPassword {

    public GantiPassword(int id, String password) {
        showDataScreen(id, password);
    }

    private void showDataScreen(int id, String passwordCheck) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel intro = new JLabel("Mengubah Kata Sandi.");
        Font font = new Font("Courier", Font.BOLD, 20);
        intro.setFont(font);
        intro.setBounds(30, 70, 400, 30);

        Font fontButton = new Font("Courier", Font.BOLD, 13);

        JLabel lineDiv = new JLabel("_______________________________"
                + "__________________________________________");
        lineDiv.setBounds(10, 100, 500, 20);

        Font fontLabel = new Font("Courier", Font.BOLD, 16);

        JLabel password = new JLabel("Password Lama");
        password.setFont(fontLabel);
        password.setBounds(30, 130, 200, 30);
        JPasswordField inputPassword = new JPasswordField();
        inputPassword.setBounds(260, 130, 200, 30);

        JLabel passwordBaru = new JLabel("Password Baru");
        passwordBaru.setFont(fontLabel);
        passwordBaru.setBounds(30, 170, 200, 30);
        JPasswordField inputPasswordBaru = new JPasswordField();
        inputPasswordBaru.setBounds(260, 170, 200, 30);

        JButton buttonSimpan = new JButton("Ubah Password");
        buttonSimpan.setBounds(40, 515, 400, 30);
        buttonSimpan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String password = String.valueOf(inputPassword.getPassword());
                String passwordBaru = String.valueOf(inputPasswordBaru.getPassword());
                if (passwordCheck.equals(password)) {
                    boolean succeed = Controller.getInstance().updatePasswordDataPassangerToDB(id, passwordBaru);
                    if (succeed) {
                        JOptionPane.showMessageDialog(f, "Password Berhasil diubah");
                        f.dispose();
                        String find = Controller.getInstance().getRolesUser(id);
                        if (find.equalsIgnoreCase("Passanger")) {
                            new MainMenuPassanger(id);
                        } else if (find.equalsIgnoreCase("Driver")) {
                            new MainMenuDriver(id);
                        }
                        
                    }
                } else {
                    JOptionPane.showMessageDialog(f, "Password Lama Tidak Sama!", "", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        JButton backButton = new JButton("Kembali");
        backButton.setFont(fontButton);
        backButton.setBounds(10, 10, 85, 30);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                String role = Controller.getInstance().getRolesUser(id);
                if (role.equalsIgnoreCase("Passanger")) {
                    new MainMenuPassanger(id);
                } else if (role.equalsIgnoreCase("Driver")) {
                    new MainMenuDriver(id);
                }
            }
        });

        f.add(buttonSimpan);
        f.add((intro));
        f.add((password));
        f.add(inputPassword);
        f.add(passwordBaru);
        f.add(inputPasswordBaru);
        f.add(backButton);
        f.add(lineDiv);

        f.setSize(500, 600);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

}
