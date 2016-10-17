package org.abins.platform.core.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/platform/admin")
public class AMyHomeController {
    
    /**
     * 跳转到my页面
     * 
     * @return
     */
    @RequestMapping(value = "/home")
    public String home() {
        Subject currentUser = SecurityUtils.getSubject();
        if(currentUser.isPermitted("user.do?myjsp")){
            return "my";
        }else{
            return "error/noperms";
        }
    }
    @RequestMapping(value = "/noperms")
    public String nopermission() {
        Subject currentUser = SecurityUtils.getSubject();
        if(currentUser.isPermitted("user.do?notmyjsp")){
            return "notmyjsp";
        }else{
            return "error/noperms";
        }
    }
}
