package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    private String paymentId;
    private String billId;
    private String userId;
    private String paymentMode;
    private Double amount;
    private String paymentDate;
    private String paymentTime;
    private String paymentStatus;
    private String paymentRemarks;

}
