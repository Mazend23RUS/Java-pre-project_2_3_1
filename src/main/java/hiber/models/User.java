package hiber.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @SequenceGenerator(name = "user_id", sequenceName = "user_seq",initialValue = 1, allocationSize = 20)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id")
    @Column(nullable = false)
    private long id;
    private String userName;
    private String userSurname;
    private Integer age;



    public User(){}

    public User(String userName, String userSurname, Integer age){
        this.age = age;
        this.userSurname = userSurname;
        this.userName = userName;


    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && age == user.age && userName.equals(user.userName) && Objects.equals(userSurname, user.userSurname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, userSurname, age);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userSurname='" + userSurname + '\'' +
                ", age=" + age +
                ", sex='" + '\'' +
                '}';
    }
}
