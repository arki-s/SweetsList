package arkis.SweetsList.domain.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int UserId;

    private String userName;

    private String email;

    private String password;

    private String role;

    @OneToMany(mappedBy = "User")
    @Column(nullable = true)
    private List<Sweets> sweets;

    @OneToMany(mappedBy = "User")
    @Column(nullable = true)
    private List<Review> reviews;

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Sweets> getSweets() {
        return sweets;
    }

    public void setSweets(List<Sweets> sweets) {
        this.sweets = sweets;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
