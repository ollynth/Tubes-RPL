package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Controller.Controller;

public class CekPendapatanDriver {
    public CekPendapatanDriver(int id) {
        showDataScreen(id);
    }

    private void showDataScreen(int id) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font = new Font("Courier", Font.BOLD, 20);
        Font font2 = new Font("Courier", Font.PLAIN, 16);
        Font font3 = new Font("Courier", Font.BOLD, 72);
        Font fontButton = new Font("Courier", Font.BOLD, 13);


        JLabel intro = new JLabel("Total Pendapatan.");
        intro.setFont(font);
        intro.setBounds(30, 70, 400, 30);

        JLabel intro2 = new JLabel("Selalu bersyukur ya!");
        intro2.setFont(font2);
        intro2.setBounds(30, 95, 400, 30);

        JLabel lineDiv = new JLabel("__________________________________"
                + "__________________________________________________"
                + "__________________________________________________"
                + "___________________________");
        lineDiv.setBounds(10, 120, 465, 20);

        JLabel time = new JLabel("Total Order " + Controller.getInstance().getUsername(id)+ ": ");
        time.setFont(font2);
        time.setBounds(30, 150, 300, 30);

        JLabel idForShow = new JLabel(Controller.getInstance().getOrderCountDriver(id) + "");
        idForShow.setFont(font3);
        idForShow.setBounds(30, 180, 300, 90);

        JLabel payDetail = new JLabel("Dengan total pendapatan sebanyak:");
        payDetail.setFont(font2);
        payDetail.setBounds(30, 270, 330, 30);

        JLabel payRaw = new JLabel("Rp. " + Controller.getInstance().totalSalary(id));
        payRaw.setFont(font);
        payRaw.setBounds(30, 300, 300, 30);

        JButton backButton = new JButton("Kembali");
        backButton.setFont(fontButton);
        backButton.setBounds(10, 10, 90, 30);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new MainMenuDriver(id);
            }
        });

        f.add((intro));
        f.add(intro2);

        f.add(time);
        f.add(idForShow);

        f.add(payDetail);
        f.add(payRaw);

        f.add(backButton);
        f.add(lineDiv);

        f.setSize(500, 600);
        f.setLayout(null);
        f.setVisible(true);
    }
    
}
