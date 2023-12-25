package arkis.SweetsList.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Sweets implements Serializable {
    @Id
    @Column(name = "sweets_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer sweetsId;

    @Column(unique = true)
    private String name;

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    private Integer calorie;

    @Column(nullable = true)
    @Lob
    @Convert(attributeName = "org.hibernate.type.ImageType")
    private byte[] img;

    @OneToMany(mappedBy = "sweets", cascade = CascadeType.ALL)
//    @OneToMany(mappedBy = "sweets", cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(nullable = true)
    private List<Review> reviews;


}
