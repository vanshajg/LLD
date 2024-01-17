package models;

import lombok.Builder;

@Builder
public class Payment {
    private String id;
    private String bookingId;
    private String userId;
    private String paymentTime;
    private String amount;
    private String status;
}
