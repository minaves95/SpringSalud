package com.salud.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FragmentsController {

    @GetMapping("/salud/navigation")
    public String getNav() {
        return "fragments/navigation.html";
    }

    @GetMapping("/salud/navigation_admin")
    public String getNavAdmin() {
        return "fragments/navigation_admin.html";
    }

    @GetMapping("/salud/news")
    public String getNews() {
        return "fragments/news.html";
    }

    @GetMapping("/salud/mis-citas")
    public String showCalendario() {
        return "miscitas.html";
    }
}
