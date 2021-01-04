package com.ldap.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ControllerOne {

    @Autowired
    ApacheDSRepository apacheDSRepository;

    @GetMapping("/")
    @ResponseBody
    public String bonsoir(@RequestParam(name = "id",required = false) String id, HttpServletRequest request){
        if(id != null){
            return "Bonsoir " +id +" !";
        }else {
            return "Bonsoir!";
        }
    }

    @ResponseBody
    @GetMapping("/error")
    public String errorMessage(HttpServletRequest request){
        return "Error occurred, Please see the server logs.";
    }

    @ResponseBody
    @GetMapping("/users")
    public Iterable<Person> getAllUsers() {

        return apacheDSRepository.findAll();
    }


    @ResponseBody
    @GetMapping("/addusers")
    public Person addUsers() {
        Person person = new Person();
        person.setLastName("shen");
        person.setUid("uid:1");
        person.setFirstName("shen");

        return apacheDSRepository.save(person);
    }


}
