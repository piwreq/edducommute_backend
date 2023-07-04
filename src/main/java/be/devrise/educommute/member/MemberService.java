package be.devrise.educommute.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MemberService {

    private final MemberRepository memberRepo;

    @Autowired
    public MemberService(MemberRepository memberRepo) {
        this.memberRepo = memberRepo;
    }

    public List<Member> getAllMembers(){
        return memberRepo.findAll();
    }

    public Member addNewMember(Member member) {
        return memberRepo.save(member);
    }
}
