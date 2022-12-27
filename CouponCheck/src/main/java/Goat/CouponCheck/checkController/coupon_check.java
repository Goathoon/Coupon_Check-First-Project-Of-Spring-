package Goat.CouponCheck.checkController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class coupon_check {

    @GetMapping("many")
    public String check(Model model) {
        model.addAttribute("data", "how many");
        return "coupon";
    }

    @GetMapping("howmany")
    public String howmany(@RequestParam(value = "data") String string, Model model) {
        model.addAttribute("data", string);
        return "coupon-param";
    }

    @GetMapping("check-resp")
    @ResponseBody
    public String doApi(@RequestParam(value = "data") String string) {
        return "hello " + string;
    }

    @GetMapping("check-api")
    @ResponseBody
    public checkAPI api(@RequestParam("data") String string){
        checkAPI api = new checkAPI();
        api.setName(string);
        return api;
    }

    static class checkAPI{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
