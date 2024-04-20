package View;
import java.util.ArrayList;
import javax.swing.JLabel;
import Controller.Controller;
import Model.Driver;
import Model.Order;
import Model.OrderStatusEnum;
import Model.Passanger;

public class DetailOrderAdmin extends DetailOrder {

    public DetailOrderAdmin(int id, int idOrder, int menu) {
        super(id, idOrder, menu);
        showDataScreenAdmin(id, idOrder, menu);
    }

    private void showDataScreenAdmin(int id, int idOrder, int menu) {

        ArrayList<Order> listOrder = Controller.getInstance().getDetailOrder(idOrder);

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

        String driver = Controller.getInstance().getUsername(listOrder.get(listOrder.size() - 1).getDriver_id());

        JLabel driverInfo = new JLabel("Info Driver:");
        driverInfo.setFont(font4);
        driverInfo.setBounds(30, 190, 300, 30);

        JLabel driverName = new JLabel(driver);
        driverName.setFont(font4);
        driverName.setBounds(30, 220, 300, 30);

        ArrayList<Driver> driverCont = Controller.getInstance()
                .getDriverByID(listOrder.get(listOrder.size() - 1).getDriver_id());

        JLabel driverPhon = new JLabel(driverCont.get(driverCont.size() - 1).getDriver_phonNum());
        driverPhon.setFont(font2);
        driverPhon.setBounds(370, 220, 300, 30);

        JLabel driverVType = new JLabel(driverCont.get(driverCont.size() - 1).getVehicle_type());
        driverVType.setFont(font2);
        driverVType.setBounds(30, 245, 300, 30);

        JLabel driverVPlate = new JLabel(driverCont.get(driverCont.size() - 1).getVehicle_plate());
        driverVPlate.setFont(font2);
        driverVPlate.setBounds(390, 255, 300, 30);

        JLabel driverVName = new JLabel(driverCont.get(driverCont.size() - 1).getVehicle_name());
        driverVName.setFont(font2);
        driverVName.setBounds(30, 265, 300, 30);

        f.add(driverInfo);
        f.add(driverName);
        f.add(driverPhon);
        f.add(driverVType);
        f.add(driverVName);
        f.add(driverVPlate);

        String passName = Controller.getInstance().getUsername(listOrder.get(listOrder.size() - 1).getCust_id());

        JLabel passInfo = new JLabel("Info Passanger:");
        passInfo.setFont(font4);
        passInfo.setBounds(30, 290, 300, 30);

        JLabel passNameCont = new JLabel(passName);
        passNameCont.setFont(font4);
        passNameCont.setBounds(30, 318, 300, 30);

        ArrayList<Passanger> passCont = Controller.getInstance()
                .getPassangerByID(listOrder.get(listOrder.size() - 1).getCust_id());

        JLabel passPhon = new JLabel(passCont.get(passCont.size() - 1).getPhone_number());
        passPhon.setFont(font2);
        passPhon.setBounds(370, 318, 300, 30);

        f.add(passInfo);
        f.add(passNameCont);
        f.add(passPhon);

        f.add(time);
        f.add(idForShow);

        f.add(lineDiv);

        f.setSize(500, 600);
        f.setLayout(null);
        f.setVisible(true);
    }

}
