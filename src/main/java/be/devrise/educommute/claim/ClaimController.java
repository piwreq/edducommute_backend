package be.devrise.educommute.claim;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/claim")
@CrossOrigin(origins = "http://localhost:3000")
public class ClaimController {

    private final ClaimService claimService;

    @Autowired
    public ClaimController(ClaimService claimService){
        this.claimService = claimService;
    }

    @GetMapping
    public List<Claim> getClaims() {
        return claimService.getAllClaims();
    }

    @PostMapping
    public void addClaim(@RequestBody Claim claim) {claimService.addNewClaim(claim);}
}
