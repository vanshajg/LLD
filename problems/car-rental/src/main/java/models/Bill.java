package models;

import lombok.Data;

@Data
public class Bill {

    private final String billId;
    private Boolean isPaid;
    private final Double amount;
    private Payment payment;


    public Bill(Double amount) {
        this.billId = "billId";
        this.isPaid = false;
        this.amount = amount;
        this.payment = null;
    }

    public void payBill(String paymentId, String paymentMode) {
        isPaid = true;
        payment = Payment.builder()
                .paymentId(paymentId)
                .paymentMode(paymentMode)
                .build();
        System.out.println("Bill paid successfully via " + paymentMode + " with paymentId " + paymentId);
    }

}
