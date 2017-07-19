package main;

import database_service.DbService;
import entitys.User;

import java.time.LocalDate;

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
        dbService.addUserInDb(user1);
        User user2 = new User("user02");
        dbService.addChildrenUser(user1,user2);
    }
}
