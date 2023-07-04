package be.devrise.educommute.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/member")
@CrossOrigin(origins = "http://localhost:3000")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public List<Member> getMembers(){
        return memberService.getAllMembers();
    }

    @PostMapping
    public Member addMember(@RequestBody Member member){
        System.out.println(member.toString());
        return memberService.addNewMember(member);
    }

}
