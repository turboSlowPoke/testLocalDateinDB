package entitys;

import javax.persistence.*;
import java.util.Currency;
@Entity
public class Transaction {
    @Id @GeneratedValue
    private long id;
    private float merchantAmount; //ac_merchant_amount

     Transaction() {
    }

    public Transaction(float merchantAmount) {
        this.merchantAmount = merchantAmount;
    }

    public float getMerchantAmount() {
        return merchantAmount;
    }

    public void setMerchantAmount(float merchantAmount) {
        this.merchantAmount = merchantAmount;
    }
}
