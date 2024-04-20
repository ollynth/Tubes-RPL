package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import Controller.Controller;
import Model.OrderStatusEnum;
import Model.Passanger;

public class DetailOrderDriver extends DetailOrder {

    public DetailOrderDriver(int id, int idOrder, int menu) {
        super(id, idOrder, menu);
        showDataScreenDriver(id, idOrder, menu);
    }

    private void showDataScreenDriver(int id, int idOrder, int menu) {
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String passName = Controller.getInstance().getUsername(listOrder.get(listOrder.size() - 1).getCust_id());

        JLabel passInfo = new JLabel("Info Passanger:");
        passInfo.setFont(font4);
        passInfo.setBounds(30, 190, 300, 30);

        JLabel passNameCont = new JLabel(passName);
        passNameCont.setFont(font4);
        passNameCont.setBounds(30, 220, 300, 30);

        ArrayList<Passanger> passCont = Controller.getInstance().getPassangerByID(listOrder.get(listOrder.size() - 1).getCust_id());

        JLabel passPhon = new JLabel(passCont.get(passCont.size() - 1).getPhone_number());
        passPhon.setFont(font2);
        passPhon.setBounds(370, 220, 300, 30);

        if (listOrder.get(listOrder.size() - 1).getOrder_status() == OrderStatusEnum.NOW) {
            JButton cancel = new JButton("Selesaikan Order");
            cancel.setBounds(30, 310, 420, 30);
            cancel.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int choice = JOptionPane.showConfirmDialog(null, "Selesaikan?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

                    if (choice == JOptionPane.YES_OPTION) {
                        if (Controller.getInstance().updateStatusOrder(idOrder, "FINISHED")) {
                            JOptionPane.showMessageDialog(null, "Berhasil diselesaikan", "Yeay", JOptionPane.INFORMATION_MESSAGE);
                            // get saldo user
                            float currSaldo = Controller.getInstance().getWallet(listOrder.get(listOrder.size() - 1).getCust_id());
                            // get saldo driver
                            float currSaldoDriver = Controller.getInstance().getWallet(listOrder.get(listOrder.size() - 1).getDriver_id());
                            float currSaldoAdmin = Controller.getInstance().getWallet(1);
                            Controller.getInstance().updateJoPay(1, currSaldoAdmin + 2000);
                            // nambah saldo driver
                            Controller.getInstance().updateJoPay(listOrder.get(listOrder.size() - 1).getDriver_id(), currSaldoDriver + listOrder.get(listOrder.size() - 1).getOrder_final_price() - 2000);
                            // kurangi saldo user
                            Controller.getInstance().updateJoPay(listOrder.get(listOrder.size() - 1).getCust_id(), currSaldo - listOrder.get(listOrder.size() - 1).getOrder_final_price());
                            // kembalikan status driver menjadi AVAILABLE
                            Controller.getInstance().changeToAvailable(id);
                            f.dispose();
                            new CekOrder(id);
                        } else {
                            JOptionPane.showMessageDialog(null, "Gagal di diselesaikan", "Yahhh", JOptionPane.ERROR_MESSAGE);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Batal diselesaikan", "", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            });
            f.add(cancel);
        }

        f.add(passInfo);
        f.add(passNameCont);
        f.add(passPhon);

        f.setSize(500, 600);
        f.setLayout(null);
        f.setVisible(true);
    }

}
