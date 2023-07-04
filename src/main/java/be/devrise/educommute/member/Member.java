package be.devrise.educommute.member;

import be.devrise.educommute.school.School;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "member")
@Getter @Setter @NoArgsConstructor
@ToString
public class Member {

    @Id
    @Column(name = "id")
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private UUID id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email_adress")
    private String emailAdress;

    @Column(name = "postal_adress")
    private String postalAdress;

    @Column(name = "fwb_member_id")
    private String fwbMemberId;

    @Column(name = "password")
    private String password;

    @Column(name = "account_status", nullable = false)
    private Boolean accountStatus;

    @Column(name = "role_id",nullable = false)
    private int roleId;

    @ManyToOne
    @JoinColumn(name="school_id", nullable = false)
    private School school;
}
