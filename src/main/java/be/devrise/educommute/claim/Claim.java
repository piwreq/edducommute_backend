package be.devrise.educommute.claim;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="refund_request", uniqueConstraints = { @UniqueConstraint(columnNames = { "year", "number" }) })
@Getter
@Setter
@NoArgsConstructor
@IdClass(ClaimID.class)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Claim {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id = UUID.randomUUID();;

    @Id
    @Column(name = "year", nullable = false)
    @GeneratedValue(generator="claim_year_id")
    @GenericGenerator(name = "claim_year_id", strategy = "be.devrise.educommute.claim.YearClaimIdGenerator")
    @EqualsAndHashCode.Include
    private int year;
    @Id
    @Column(name = "number", nullable = false)
    @GeneratedValue(generator="claim_number_id")
    @GenericGenerator(name = "claim_number_id", strategy = "be.devrise.educommute.claim.NumberClaimIdGenerator")
    @EqualsAndHashCode.Include
    private int number;
    @Column(name = "member_id", nullable = false)
    private UUID memberId;
    @Column(name = "start_date", nullable = false)
    private Date startDate;
    @Column(name = "end_date", nullable = false)
    private Date endDate;
    @Column(name = "transport_type_id", nullable = false)
    private int transportTypeId;
    @Column(name = "amount_paid")
    private BigDecimal amountPaid;
    @Column(name = "amount_to_refund", nullable = false)
    private BigDecimal amountToRefund;
    @Column(name = "amount_refunded")
    private BigDecimal amountRefunded;
    @Column(name = "amount_received_fwb")
    private BigDecimal amountReceivedFWB;
    @Column(name = "declaration_id")
    private UUID declarationId;

    public String getPhysicalId(){
        return String.valueOf(getYear()) + String.format("%03d", getNumber());
    }
}
