package com.khanh.basis.crud;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login";
    }
    @PostMapping("/do-login")
    public String loginacc(Model model, RedirectAttributes ra, @RequestParam("username") String username, HttpSession session){
        if(username.equalsIgnoreCase("admin")){
            session.setAttribute("role",1);
        }else{
            session.setAttribute("role",2);
        }
        return "redirect:/product";
    }

    @GetMapping("product")
    public String showProduct(Model model,HttpSession session,@RequestParam(value = "key",required = false) String key ){

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
