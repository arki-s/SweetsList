package arkis.SweetsList.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Review implements Serializable {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(name= "review_id")
    private Integer reviewId;

    @Column
    private LocalDate date;

    @Column(length = 5)
    private Integer rating;

    @Column(length = 150)
    private String comment;

    @ManyToOne
    @JoinColumn(name="sweets_id")
    private Sweets sweets;

}
