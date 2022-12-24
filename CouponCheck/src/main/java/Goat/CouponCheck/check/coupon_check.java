package Goat.CouponCheck.check;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class coupon_check {

    @GetMapping("many")
    public String check(Model model){
        model.addAttribute("data","how many");
        return "coupon";
    }
}
