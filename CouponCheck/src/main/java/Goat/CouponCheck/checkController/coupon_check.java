package Goat.CouponCheck.checkController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class coupon_check {

    @GetMapping("many")
    public String check(Model model){
        model.addAttribute("data","how many");
        return "coupon";
    }

    @GetMapping("howmany")
    public String howmany(@RequestParam(value = "data") String string, Model model ){
        model.addAttribute("data",string);
        return "coupon-param";
    }
}
