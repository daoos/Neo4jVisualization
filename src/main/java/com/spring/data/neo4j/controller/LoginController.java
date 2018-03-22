package com.spring.data.neo4j.controller;

import com.spring.data.neo4j.dto.Login;
import com.spring.data.neo4j.service.LoginService;
import com.spring.data.neo4j.unitl.ClientsInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/3/17.
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    /*@RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public List<Login> create(@RequestParam String user,
                              @RequestParam Date time,
                              @RequestParam String proto,
                              @RequestParam String dip,
                              @RequestParam Integer dport,
                              @RequestParam String sip,
                              @RequestParam Integer sport,
                              @RequestParam String state, HttpServletRequest request){

        System.out.println("--------->"+user);
        Login login=new Login(user,time,proto,dip,dport,sip,sport,state);

        return loginService.createLogin(login);
    }*/

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public List<Login> create(Login login, HttpServletRequest request){
        if (login.getTime()==null){
            login.setTime(new Date());
        }
        if ("".equals(login.getSip())|| login.getSip().length() == 0 || "unknown".equalsIgnoreCase(login.getSip())){
            login.setSip(ClientsInfo.getIpAddress(request));
        }
        if (login.getSport()<=0){
            login.setSport(22);
        }
        System.out.println("--------->"+login.getUser());
        return loginService.createLogin(login);
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public List<Login> findAll(){
        return loginService.findAllLogin();
    }

    @RequestMapping("/findBy/{type}/{value}")
    @ResponseBody
    public List<Login> findBy(@PathVariable String type,@PathVariable String value){
        Integer port;
        Long id;;
        if ("sport".equalsIgnoreCase(type)||"dport".equalsIgnoreCase(type)){
            try {
                port=Integer.parseInt(value);
            }catch (Exception e){
                System.out.println(e.getMessage());
                return null;
            }
        }
        if ("id".equalsIgnoreCase(type)){
            try {
                id=Long.parseLong(value);
            }catch (Exception e){
                System.out.println(e.getMessage());
                return null;
            }
        }
        return loginService.findByUser("root");
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Boolean delete(@RequestParam Long id){
        return loginService.delete(id);
    }
}
