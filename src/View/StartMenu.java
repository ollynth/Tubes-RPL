package View;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class StartMenu {
    public StartMenu(){
        pilihOpsi();
    }

    private void pilihOpsi() {
        JFrame mainMenu = new JFrame("Selamat Datang Di Josen");
        mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ImageIcon originalFotoIcon = new ImageIcon("Picture Source\\Logo\\gojek-icon-512x512-dyy6mlv4.png");
        Image originalFoto = originalFotoIcon.getImage();
        Image resizedFoto = originalFoto.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        ImageIcon resizedFotoIcon = new ImageIcon(resizedFoto);
        JLabel logoGojek = new JLabel(resizedFotoIcon);
        logoGojek.setBounds(40, -60, 300, 300);
        
        JLabel hello = new JLabel("Selamat Datang di Josen!");
        Font font = new Font("Courier", Font.BOLD,20);
        hello.setFont(font);
        hello.setBounds(70, 140, 300, 80);
        
        JLabel intro = new JLabel("Mau kemana sayang? ");
        JLabel intro2 = new JLabel("Sini abang Josen yang anter");
        Font font2 = new Font("Courier", Font.PLAIN,14);
        intro.setFont(font2);
        intro2.setFont(font2);
        intro.setBounds(118, 200, 250, 30);
        intro2.setBounds(98, 220, 250, 30);
        
        Font fontButton = new Font("Courier", Font.BOLD,12);
        
        JButton buttonLogin = new JButton("Masuk");
        buttonLogin.setFont(fontButton);
        buttonLogin.setBounds(90, 320, 200, 30);
        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenu.dispose();
                new LogIn();
            }
        });
        
        JButton buttonRegis = new JButton("Belum ada akun? Daftar dulu");
        buttonRegis.setFont(fontButton);
        buttonRegis.setBounds(90, 360, 200, 30);
        buttonRegis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Registrasi();
                mainMenu.dispose();
            }
        });
        
        JButton buttonExit = new JButton("Exit");
        buttonExit.setFont(fontButton);
        buttonExit.setBounds(140, 480, 100, 30); 
        buttonExit.addActionListener((event) -> System.exit(0));

        mainMenu.add(logoGojek);
        mainMenu.add(hello);
        mainMenu.add(intro);
        mainMenu.add(intro2);
        
        mainMenu.add(buttonLogin);
        mainMenu.add(buttonRegis);
        mainMenu.add(buttonExit);

        mainMenu.setSize(400, 600);
        mainMenu.setLayout(null);
        mainMenu.setLocationRelativeTo(null);
        mainMenu.setVisible(true);
    }

}
