package de.gothaer.smartbank24kreditantragstore.adapter.repositories.entities;

import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.Hibernate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "tbl_kreditantraege")
public class KreditantragEntity {
    private static final long serialVersionUID = 8144682724082102640L;


    @Id
    @Column(length = 36)
    private String creditApplicationId ;

    @Column(length = 51)
    private String firstName;

    @Column(length = 51)
    private String lastName;

    @Column(length = 51)
    private String city;


    private LocalDateTime applicationDate ;


    private double monthlyIncome;

    private double monthlyExpenditure;

    private double creditSum;

    @Column(length = 30)
    private String scoringState;

    @Column(length = 30)
    private String cityScoringState;

    @Column(length = 30)
    private String applicationState;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        KreditantragEntity that = (KreditantragEntity) o;
        return creditApplicationId != null && Objects.equals(creditApplicationId, that.creditApplicationId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
