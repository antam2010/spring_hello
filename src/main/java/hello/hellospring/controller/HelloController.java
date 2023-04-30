package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("hello")
public class HelloController     {

    @GetMapping("")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!!");
        return "hello/index";
    }
    @GetMapping("/mvc")
    public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "hello/mvc";
    }
    @GetMapping("/api/string")
    @ResponseBody
    public String helloApi(@RequestParam(value = "name", required = false) String name, Model model) {
        return "hello" + name;
    }

    @GetMapping("/api/json")
    @ResponseBody
    public Hello helloJsonApi(@RequestParam(value ="name", required = false) String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }

}
