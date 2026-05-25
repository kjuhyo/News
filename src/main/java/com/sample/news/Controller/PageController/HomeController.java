package com.sample.news.Controller.PageController;

import com.sample.news.Service.CategoriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequiredArgsConstructor
public class HomeController {

    private final CategoriesService categoriesService;

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/news")
    public String news(@RequestParam("categoryId") String categoryId, Model model) throws Exception {
        model.addAttribute("categoryId", categoryId);
        model.addAttribute("categoryName", categoriesService.get(Integer.parseInt(categoryId)).getName());
        return "news";
    }

}
