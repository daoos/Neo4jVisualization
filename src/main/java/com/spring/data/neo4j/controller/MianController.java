package com.spring.data.neo4j.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2018/3/20.
 */
@Controller
@RequestMapping("/")
public class MianController {
    @RequestMapping("/")
    public String index(){
        return "main";
    }

    @RequestMapping("/goto/{{url1}/{url2}/{url3}")
    public String url(@PathVariable String url1,@PathVariable String url2,@PathVariable String url3){
        return url1+"/"+url2+"/"+url3;
    }

    @RequestMapping("/goto/{{url1}/{url2}")
    public String url(@PathVariable String url1,@PathVariable String url2){
        return url1+"/"+url2;
    }

    @RequestMapping("/goto/{url1}")
    public String url(@PathVariable String url1){
        return url1;
    }


}
