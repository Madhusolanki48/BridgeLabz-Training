package FutureLogistics;
import java.util.Scanner;

public class FutureLogisticsMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Utility utility = new Utility();

        System.out.println("Enter the Goods Transport details: ");
        //sample input
        //1. RTS120A:12/8/21:5:BrickTransport:6:800:40
        //2. RTS113A:12/8/21:4:TimberTransport:20:4:Premium:500
        //3. RTS113A:12/8/21:4:TimberTransport:13:4:NonPremium:200
        //4. rts1137:12/8/21:4:TimberTransport:13:4:NonPremium:200
        String input = sc.nextLine();

        String transportId = input.split(":")[0];

        if (!utility.validateTransportId(transportId)) {
            return;
        }

        GoodsTransport gt = utility.parseDetails(input);
        String type = utility.findObjectType(gt);

        System.out.println("\nTransporter id : " + gt.getTransportId());
        System.out.println("Date of transport : " + gt.getTransportDate());
        System.out.println("Rating of the transport : " + gt.getTransportRating());

        if (type.equals("BrickTransport")) {
            BrickTransport bt = (BrickTransport) gt;
            System.out.println("Quantity of bricks : " + bt.getBrickQuantity());
            System.out.println("Brick price : " + bt.getBrickPrice());
        } else {
            TimberTransport tt = (TimberTransport) gt;
            System.out.println("Type of the timber : " + tt.getTimberType());
            System.out.println("Timber price per kilo : " + tt.getTimberPrice());
        }

        System.out.println("Vehicle for transport : " + gt.vehicleSelection());
        System.out.println("Total charge : " + gt.calculateTotalCharge());
    }
}

