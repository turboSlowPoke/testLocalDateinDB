package main;

import database_service.DbService;
import entitys.Transaction;
import entitys.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kuteynikov on 07.07.2017.
 */
public class Main {
    public static void main(String[] a){
        DbService dbService = new DbService();
        User user1 = new User("user01");
        user1.setLevel(0);
        user1.setLeftKey(1);
        user1.setRightKey(2);
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(1.00f));
        transactions.add(new Transaction(2.00f));
        user1.setTransaction(transactions);
        dbService.addUserInDb(user1);
        //User user2 = new User("user02");
        //dbService.addChildrenUser(user1,user2);
    }
}
