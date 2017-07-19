package entitys;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

/**
 * Created by kuteynikov on 07.07.2017.
 */
@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = "Users.addUserStep1",
                query = "UPDATE User u SET u.leftKey=u.leftKey+2, u.rightKey=u.rightKey+2 WHERE u.leftKey>:key"),
        @NamedQuery(name = "Users.addUserStep2",
                query = "UPDATE User u SET u.rightKey=u.rightKey+2 WHERE u.rightKey>=:key AND u.leftKey<:key")
})
public class User {
    @Id @NotNull
    private String id;
    private int level;
    private int leftKey;
    private int rightKey;

     User() {
    }

    public User(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLeftKey() {
        return leftKey;
    }

    public void setLeftKey(int leftKey) {
        this.leftKey = leftKey;
    }

    public int getRightKey() {
        return rightKey;
    }

    public void setRightKey(int rightKey) {
        this.rightKey = rightKey;
    }
}
