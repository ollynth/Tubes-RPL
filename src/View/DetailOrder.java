package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import Controller.Controller;
import Model.Order;
import Model.OrderStatusEnum;

public class DetailOrder {

    protected JFrame f = new JFrame();
    protected Font font = new Font("Courier", Font.BOLD, 20);
    protected Font font2 = new Font("Courier", Font.PLAIN, 14);
    protected Font font3 = new Font("Courier", Font.PLAIN, 16);
    protected Font font4 = new Font("Courier", Font.BOLD, 16);
    protected Font fontButton = new Font("Courier", Font.BOLD, 13);
    protected ArrayList<Order> listOrder;

    public DetailOrder(int id, int idOrder, int menu) {
        showDataScreen(id, idOrder, menu);
    }

    private void showDataScreen(int id, int idOrder, int menu) {

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        listOrder = Controller.getInstance().getDetailOrder(idOrder);

        JLabel intro = new JLabel("Detail Pesanan.");
        intro.setFont(font);
        intro.setBounds(30, 70, 400, 30);

        String message = "";
        if (listOrder.get(listOrder.size() - 1).getOrder_status() == OrderStatusEnum.FINISHED) {
            message = "Sudah sampai tujuan.";
        } else if (listOrder.get(0).getOrder_status() == OrderStatusEnum.CANCEL) {
            message = "Sudah di cancel.";
        } else if (listOrder.get(0).getOrder_status() == OrderStatusEnum.NOW) {
            message = "Sedang dalam perjalanan";
        }

        JLabel intro2 = new JLabel(message);
        intro2.setFont(font3);
        intro2.setBounds(30, 95, 400, 30);

        JLabel lineDiv = new JLabel("__________________________________"
                + "__________________________________________________"
                + "__________________________________________________"
                + "___________________________");
        lineDiv.setBounds(10, 120, 465, 20);

        JLabel time = new JLabel("" + Controller.getInstance().getTimeOrder(idOrder));
        time.setFont(font2);
        time.setBounds(30, 150, 300, 30);

        JLabel idForShow = new JLabel("#" + idOrder);
        idForShow.setFont(font4);
        idForShow.setBounds(420, 150, 300, 30);

        JLabel asal = new JLabel(listOrder.get(listOrder.size() - 1).getOrder_pickup() + " menuju");
        asal.setFont(font4);
        asal.setBounds(340, 95, 100, 30);

        JLabel destination = new JLabel(listOrder.get(listOrder.size() - 1).getOrder_destination());
        destination.setFont(font4);
        destination.setBounds(420, 95, 40, 30);

        JLabel payDetail = new JLabel("Detail Pembayaran:");
        payDetail.setFont(font4);
        payDetail.setBounds(30, 385, 300, 30);

        JLabel payRaw = new JLabel("Biaya Perjalanan:");
        payRaw.setFont(font2);
        payRaw.setBounds(30, 410, 300, 30);

        JLabel payTax = new JLabel("Biaya  jasa aplikasi:");
        payTax.setFont(font2);
        payTax.setBounds(30, 435, 300, 30);

        JLabel payVoucher = new JLabel("Diskon Voucher:");
        payVoucher.setFont(font2);
        payVoucher.setBounds(30, 460, 300, 30);

        JLabel total = new JLabel("Total:");
        total.setFont(font4);
        total.setBounds(30, 490, 300, 30);

        JLabel payRawVal = new JLabel("Rp. " + listOrder.get(listOrder.size() - 1).getOrder_price());
        payRawVal.setFont(font2);
        payRawVal.setBounds(370, 410, 300, 30);

        JLabel payTaxVal = new JLabel("Rp. 2000");
        payTaxVal.setFont(font2);
        payTaxVal.setBounds(370, 435, 300, 30);

        float disc = Controller.getInstance().getPromoValByID(listOrder.get(listOrder.size() - 1).getPromo_id());
        float result = (listOrder.get(listOrder.size() - 1).getOrder_price() + 2000) * disc;

        JLabel payVoucherVal = new JLabel("Rp. " + result);
        payVoucherVal.setFont(font2);
        payVoucherVal.setBounds(370, 460, 300, 30);

        JLabel totalVal = new JLabel("Rp. " + listOrder.get(listOrder.size() - 1).getOrder_final_price());
        totalVal.setFont(font4);
        totalVal.setBounds(360, 490, 300, 30);

        JButton backButton = new JButton("Kembali");
        backButton.setFont(fontButton);
        backButton.setBounds(10, 10, 85, 30);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                switch (menu) {
                    case 1:
                        new OrderBerjalan(id);
                        break;
                    case 2:
                        new OrderRiwayat(id);
                        break;
                    default:
                        new MainMenuAdmin();
                        break;
                }
            }
        });

        f.add((intro));
        f.add(intro2);

        f.add(time);
        f.add(idForShow);

        f.add(asal);
        f.add(destination);

        f.add(payDetail);
        f.add(payRaw);
        f.add(payRawVal);
        f.add(payTax);
        f.add(payVoucher);
        f.add(total);
        f.add(payTaxVal);
        f.add(payVoucherVal);
        f.add(totalVal);

        f.add(backButton);
        f.add(lineDiv);

        f.setSize(500, 600);
        f.setLayout(null);
        f.setVisible(true);
    }

}
