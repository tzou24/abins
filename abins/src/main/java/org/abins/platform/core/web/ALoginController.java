package org.abins.platform.core.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.abins.platform.core.entity.ABaseUser;
import org.abins.platform.core.exception.AUserLoginException;
import org.abins.platform.core.service.ABaseUserService;
import org.abins.platform.utils.MD5Util;
import org.abins.platform.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 功能描述：登录控制器
 * 
 * @author : yaobin 2016-9-28
 * @modify : yaobin 2016-9-28 <描述修改内容>
 */
@RequestMapping("/platform/main")
@Controller
public class ALoginController {
    
    /**
     * logger 日志
     */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    public static final String LOGIN_TOKEN_ID = "tokenId";
    
    /**
     * baseUserService
     */
    @Autowired
    private ABaseUserService baseUserService;
    
    /**
     * <一句话功能简述> 进入登录页面
     * 
     * @modefy : yaobin 2016-9-28
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/toLogin", method = RequestMethod.GET)
    public String platToLogin(HttpServletRequest request, Model model) {
        String tokenId = MD5Util.getInstance().getMD5ofStr(String.valueOf(System.currentTimeMillis()));
        request.getSession().setAttribute(LOGIN_TOKEN_ID, tokenId);
        model.addAttribute(LOGIN_TOKEN_ID, tokenId);
        System.out.println("method: platToLogin");
        return "platform/login";
    }
    
    /**
     * <一句话功能简述> 登录验证
     * 
     * @modefy : yaobin 2016-9-28
     * @param request
     * @param model
     * @return 
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String platLogin(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        Object sessionTokenId = session.getAttribute(LOGIN_TOKEN_ID);
        String tokenId = request.getParameter(LOGIN_TOKEN_ID);
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if(StringUtil.isEmpty(tokenId) 
            || !sessionTokenId.equals(tokenId)
            || StringUtil.isEmpty(email)
            || StringUtil.isEmpty(password)){
            model.addAttribute("message", "参数错误请重新输入");
           return "redirect:/platform/main/toLogin"; 
        } else{
            session.removeAttribute(LOGIN_TOKEN_ID);
            ABaseUser baseUser;
            try {
                baseUser = baseUserService.login(email, password);
                model.addAttribute("baseUser", baseUser);
                logger.info("baseUser={}",baseUser);
                //TODO 添加登录日志
            } catch (AUserLoginException e) {
                model.addAttribute("message", e.getMessage());
                e.printStackTrace();
                return "redirect:/platform/main//toLogin";
            } catch (Exception e) {
                model.addAttribute("message", "error");
                e.printStackTrace();
                return "redirect:/platform/main/toLogin";
            }
            return "platform/home";
        }
    }
    
}
