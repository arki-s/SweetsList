package arkis.SweetsList.domain.model;

import jakarta.persistence.*;

@Entity
public class Sweets {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sweetsId;

    @Column(nullable = false)
    private int calorie;

    @Column
    @Lob
    @Convert(attributeName = "org.hibernate.type.ImageType")
    private byte[] img;

    @ManyToOne
    private User user;

    public int getSweetsId() {
        return sweetsId;
    }

    public void setSweetsId(int sweetsId) {
        this.sweetsId = sweetsId;
    }

    public int getCalorie() {
        return calorie;
    }

    public void setCalorie(int calorie) {
        this.calorie = calorie;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
