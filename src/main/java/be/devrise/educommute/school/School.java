package be.devrise.educommute.school;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="school")
@Getter
@Setter
@NoArgsConstructor
public class School {

    @Id
    @Column(name="id", columnDefinition = "serial")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_school"
    )
    @SequenceGenerator(
            name = "seq_school",
            initialValue = 1,
            allocationSize = 1
    )
    private int id;
    @Column(name="school_name")
    private String schoolName;
    @Column(name="school_adress")
    private String schoolAdress;
    @Column(name="network_type")
    private NetworkType networkType;
    @Column(name="level_type")
    private LevelType levelType;
}
