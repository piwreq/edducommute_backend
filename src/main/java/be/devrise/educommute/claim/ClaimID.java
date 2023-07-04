package be.devrise.educommute.claim;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class ClaimID implements Serializable {

    private int year;
    private int number;
}
