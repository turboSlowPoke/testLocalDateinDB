package entitys;

import javax.persistence.*;
import java.util.Currency;
import java.util.List;

@Entity
public class Transaction {
    @Id @GeneratedValue
    private long id;
    private float merchantAmount; //ac_merchant_amount
    @ManyToMany(mappedBy = "transactions",cascade = CascadeType.PERSIST)
    private List<User> users;

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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
