package com.example.appdemo.User;

import javax.ws.rs.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.appdemo.utilities.UserUtilities;

@Controller
public class ProfilController {

    @Autowired
    private UserService userService;

    @GET
    @RequestMapping(value = "/profil")
    public String showUserProfile (Model model) {
        String username = UserUtilities.getLoggedUser();

        User user = userService.findUserByEmail(username);

        int roleNr = user.getRoles().iterator().next().getId();

        user.setRoleNr(roleNr);
        model.addAttribute("user", user);

        return "profil";
    }

}
