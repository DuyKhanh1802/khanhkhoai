package controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class AdminSceen {
    @GetMapping("product")
    public String showProduct(Model model, HttpSession session, @RequestParam(value = "key",required = false) String key ){

        Integer role = (Integer)session.getAttribute("role");
        if(role == null){
            return "redirect:login";
        }
        model.addAttribute("role",session.getAttribute("role"));
        if(key != null && !key.isEmpty()){
            model.addAttribute("key",key + "| success");
        }else{
            model.addAttribute("key","Full ko che");
        }
        return "product";
    }
}
