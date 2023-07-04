package be.devrise.educommute.claim;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClaimService {

    private final ClaimRepository claimRepo;

    @Autowired
    public ClaimService (ClaimRepository claimRepo){
        this.claimRepo = claimRepo;
    }

    public List<Claim> getAllClaims(){
        return claimRepo.findAll();
    }

    public void addNewClaim (Claim claim){
        claimRepo.save(claim);
    }
}
