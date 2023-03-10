package Goat.CouponCheck.controller;

import Goat.CouponCheck.domain.Coupon;
import Goat.CouponCheck.domain.Member;
import Goat.CouponCheck.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/")
    public String check(Model model) {
        Coupon coupon = new Coupon();
        model.addAttribute("data", coupon.getNum());
        return "coupon";
    }

    @GetMapping("/new")
    public String createForm(){
        return "newMembers";
    }

    @PostMapping("/new")
    public String create(MemberForm form, Model model){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);
        Coupon coupon = new Coupon();
        model.addAttribute("data", coupon.getNum());
        model.addAttribute("memberName",member.getName()); //이름까지 전송해서 login창에서 회원정보를 받을 수 있게
        return"coupon-login";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "memberList";
    }

    @GetMapping("/coupon-update")
    public String memberCoupon(Model model, Coupon coupon){
        coupon.setNum();
        model.addAttribute("data",coupon.getNum());
        return "coupon-login";
    }
}
