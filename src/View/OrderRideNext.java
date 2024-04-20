package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import Controller.Controller;
import Model.Driver;
import Model.Passanger;

public class OrderRideNext {

    public OrderRideNext(String asal, String tujuan, int id, String promo) {
        showDataScreen(asal, tujuan, id, promo);
    }

    private JLabel admin, labelPilihVehicle, hasilPromo, labelResult, totalHarga;
    //detail pembayaran
    private JLabel detail, biayaA, biayaB, biayaC, biayaD;
    private JComboBox<String> boxPilihVehicle;
    private float promoVal = 0.0f;
    private float totalHargaValue = 0.0f;
    private float finalCost = 0.0f;

    private void showDataScreen(String asal, String tujuan, int id, String promo) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ArrayList<Passanger> pass = Controller.getInstance().getPassangerByID(id);

        JLabel intro = new JLabel("Halo, " + pass.get(pass.size() - 1).getUser_name() + "!");
        Font font = new Font("Courier", Font.BOLD, 20);
        JLabel intro2 = new JLabel("Mau kemana kali ini sayy?");
        Font font2 = new Font("Courier", Font.PLAIN, 16);
        intro.setFont(font);
        intro2.setFont(font2);
        intro.setBounds(30, 70, 400, 30);
        intro2.setBounds(30, 90, 300, 30);

        Font fontButton = new Font("Courier", Font.BOLD, 13);

        JLabel lineDiv = new JLabel("_______________________________"
                + "__________________________________________");
        lineDiv.setBounds(10, 110, 460, 20);

        Font fontLabel = new Font("Courier", Font.BOLD, 16);

        JLabel asalLabel = new JLabel("Asal: ");
        asalLabel.setFont(font2);
        asalLabel.setBounds(30, 160, 200, 30);
        JLabel tujuanLabel = new JLabel("Tujuan: ");
        tujuanLabel.setFont(font2);
        tujuanLabel.setBounds(30, 190, 200, 30);
        JLabel promoLabel = new JLabel("Kode Promo: ");
        promoLabel.setFont(font2);
        promoLabel.setBounds(30, 220, 200, 30);

        // recap harga
        // Label to display the result -- harga awal
        JLabel asalGet = new JLabel(asal);
        asalGet.setFont(font2);
        asalGet.setHorizontalAlignment(SwingConstants.RIGHT);
        asalGet.setBounds(250, 160, 200, 30);
        JLabel tujuanGet = new JLabel(tujuan);
        tujuanGet.setFont(font2);
        tujuanGet.setHorizontalAlignment(SwingConstants.RIGHT);
        tujuanGet.setBounds(250, 190, 200, 30);
        String promoField = "";
        if(promo.isEmpty()){
            promoField = "-";
        } else {
            promoField = promo;
        }
        JLabel promoGet = new JLabel(promoField);
        promoGet.setFont(font2);
        promoGet.setHorizontalAlignment(SwingConstants.RIGHT);
        promoGet.setBounds(250, 220, 200, 30);

        f.add(asalLabel);
        f.add(tujuanLabel);
        f.add(promoLabel);
        f.add(asalGet);
        f.add(tujuanGet);
        f.add(promoGet);

        // jenis kendaraan
        labelPilihVehicle = new JLabel("Pilih Kendaraan ");
        String listKendaraan[] = {"Mobil", "Motor"};
        boxPilihVehicle = new JComboBox(listKendaraan);
        boxPilihVehicle.setSelectedItem(null);
        labelPilihVehicle.setFont(fontLabel);
        labelPilihVehicle.setBounds(30, 280, 200, 30);
        boxPilihVehicle.setBounds(250, 280, 200, 30);

        // Add action listeners
        boxPilihVehicle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateCost(asal, tujuan, promo);
            }
        });

        //label buat detail
        detail = new JLabel();
        detail.setFont(font2);
        detail.setBounds(30, 330, 200, 30);
        detail.setFont(fontLabel);
        biayaA = new JLabel();
        biayaA.setFont(font2);
        biayaA.setBounds(30, 360, 200, 30);
        biayaB = new JLabel();
        biayaB.setFont(font2);
        biayaB.setBounds(30, 390, 200, 30);
        biayaC = new JLabel();
        biayaC.setFont(font2);
        biayaC.setBounds(30, 420, 200, 30);
        biayaD = new JLabel();
        biayaD.setFont(font2);
        biayaD.setBounds(30, 450, 200, 30);

        // recap harga
        // Label to display the result -- harga awal
        labelResult = new JLabel();
        labelResult.setFont(font2);
        labelResult.setHorizontalAlignment(SwingConstants.RIGHT);
        labelResult.setBounds(250, 360, 200, 30);
        admin = new JLabel();
        admin.setFont(font2);
        admin.setHorizontalAlignment(SwingConstants.RIGHT);
        admin.setBounds(250, 390, 200, 30);
        hasilPromo = new JLabel();
        hasilPromo.setFont(font2);
        hasilPromo.setHorizontalAlignment(SwingConstants.RIGHT);
        hasilPromo.setBounds(250, 420, 200, 30);
        totalHarga = new JLabel();
        totalHarga.setFont(font2);
        totalHarga.setHorizontalAlignment(SwingConstants.RIGHT);
        totalHarga.setBounds(250, 450, 200, 30);

        //back button
        JButton backButton = new JButton("Kembali");
        backButton.setFont(fontButton);
        backButton.setBounds(10, 10, 90, 30);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new MainMenuPassanger(id);
            }
        });

        // check user's wallet -- if user's wallet < harga akhir --> order button disable
        // order button
        JButton orderButton = new JButton("Pesan Sekarang");
        orderButton.setFont(fontButton);
        orderButton.setBounds(40, 500, 400, 30);
        orderButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (isAnyFieldEmpty()) {
                    JOptionPane.showMessageDialog(null, "Masih ada bagian yang kosong nih!", "Isi Dulu Datanya", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (Controller.getInstance().getWallet(id) < totalHargaValue) {
                        int choice = JOptionPane.showConfirmDialog(null, "Saldo kamu ga cukup loh, mau top up?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                        if (choice == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(null, "Ke menu top up!", "", JOptionPane.INFORMATION_MESSAGE);
                            f.dispose();
                            new MenuTopUp(id);
                        } else {
                            JOptionPane.showMessageDialog(null, "Ke menu utama!", "", JOptionPane.INFORMATION_MESSAGE);
                            f.dispose();
                            new MainMenuPassanger(id);
                        }
                    } else {
                        String jenisKendaraan = boxPilihVehicle.getSelectedItem().toString();
                        int idPromo = Controller.getInstance().getPromoIdByCode(promo);

                        Driver drv = Controller.getInstance().getDriverAvailable(jenisKendaraan);
                        if (drv == null) {
                            JOptionPane.showMessageDialog(null, "Tidak Dapat Menemukan Dirver!", "Yahh Maap Yahh", JOptionPane.ERROR_MESSAGE);
                        } else {
                            boolean status = Controller.getInstance().createUserOrder(id, idPromo, asal, tujuan, finalCost, totalHargaValue, drv);
                            if (status == true) {
                                JOptionPane.showMessageDialog(null, "Kamu Sudah Dalam Pesanan!", "Yeayy", JOptionPane.INFORMATION_MESSAGE);
                                f.dispose();
                                new OrderBerjalan(id);
                            } else {
                                JOptionPane.showMessageDialog(null, "Pesanan Kamu Gagal DiProses!", "Yahh Maap Yahh", JOptionPane.ERROR_MESSAGE);
                            }
                        }

                    }

                }
            }

            private boolean isAnyFieldEmpty() {
                return boxPilihVehicle.getSelectedItem() == null;
            }
        });

        f.add((intro));
        f.add((intro2));
        f.add(labelPilihVehicle); // add choose vehicle
        f.add(boxPilihVehicle);
        f.add(backButton); // add back button
        f.add(orderButton); // add order button
        f.add(lineDiv);
        f.add(orderButton); // add order button
        f.add(labelResult); // add harga
        f.add(admin);
        f.add(hasilPromo); // add show promo uses
        f.add(totalHarga); // add harga final
        f.add(detail);
        f.add(biayaA);
        f.add(biayaB);
        f.add(biayaC);
        f.add(biayaD);

        f.setSize(500, 600);
        f.setLayout(null);

        f.setVisible(true);
    }

    private void calculateCost(String asal, String tujuan, String kodePromo) {
        float disc = Controller.getInstance().getPromoVal(kodePromo);
        char source = asal.charAt(0);
        char destination = tujuan.charAt(0);

        int baseCost = Controller.getInstance().calculateCost(source, destination);
        String selectedVehicle = (String) boxPilihVehicle.getSelectedItem();

        if (baseCost != -1) {
            int hasil = Controller.getInstance().calculateFinalCost(baseCost, selectedVehicle);
            float afterDisc = (hasil + 2000) * disc;
            finalCost = hasil;
            totalHargaValue = (hasil + 2000) - afterDisc;
            hasilPromo.setText("Rp. " + afterDisc);
            labelResult.setText("Rp. " + finalCost);
            admin.setText("Rp. 2000");
        } else {
            labelResult.setText("Biaya tidak dapat dihitung.");
        }

        detail.setText("Detail Pembayaran");
        biayaA.setText("Biaya perjalanan");
        biayaB.setText("Biaya jasa aplikasi");
        biayaC.setText("Diskon Voucher");
        biayaD.setText("Total");
        totalHarga.setText("" + formatCost(totalHargaValue));
    }

    // format cost
    private String formatCost(float cost) {
        DecimalFormat rupiahFormat = new DecimalFormat("Rp #,###.##");
        return rupiahFormat.format(cost);
    }

    public float getPromoVal() {
        return promoVal;
    }

}
