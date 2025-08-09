package app.entities;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.List;




@Entity
@Table(name = "Users")
@UserDefinition
public class User extends PanacheEntity {
    private String email;
    private String name;

    @Username
    private String userName;

    @Password
    private String password;



    private int age;
    private int mass;

    @Roles
    private String role; //By default is an user.



    /**
     * Adds a new user in the database
     * @param username the user name
     * @param password the unencrypted password (it will be encrypted with bcrypt)
     * @param role the comma-separated roles
     */
    public static void add(String username, String password, String role, int age, int mass, String mail, String name) {
        User user = new User();
        user.userName = username;
        user.password = BcryptUtil.bcryptHash(password);
        user.role = role;
        user.age=age;
        user.mass=mass;
        user.name=name;
        user.email=mail;
        user.persist();

    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
