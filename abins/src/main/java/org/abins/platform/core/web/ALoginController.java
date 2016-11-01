package org.abins.platform.core.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.abins.platform.core.dao.IAPermissionDao;
import org.abins.platform.core.entity.ADictType;
import org.abins.platform.core.entity.APermission;
import org.abins.platform.core.service.IADictService;
import org.abins.platform.core.service.IAPermissionService;
import org.abins.platform.utils.MD5Util;
import org.abins.platform.utils.StringUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    
    public static final String FAIL_STR = "fail";
    
    @Autowired
    private IAPermissionService permissionService;
    @Autowired
    private IADictService dictService;
    
    /**
     * <一句话功能简述> 进入登录页面
     * 
     * @modefy : yaobin 2016-9-28
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/toLogin", method = RequestMethod.GET)
    public String platToLogin(@ModelAttribute(FAIL_STR) String failMsg, HttpServletRequest request, Model model, RedirectAttributes attr) {
        String tokenId = MD5Util.getInstance().getMD5ofStr(String.valueOf(System.currentTimeMillis()));
        request.getSession().setAttribute(LOGIN_TOKEN_ID, tokenId);
        model.addAttribute(LOGIN_TOKEN_ID, tokenId);
        model.addAttribute(FAIL_STR, failMsg);
        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser.isAuthenticated()) {
            model.addAttribute("currentUsername", currentUser.getPrincipal());
            return "platform/home";
        } else {
            return "platform/login";
        }
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String platGetLogin() {
        return "redirect:/platform/main/toLogin";
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
    public String platLogin(HttpServletRequest request, Model model, RedirectAttributes attr) {
        HttpSession session = request.getSession();
        Object sessionTokenId = session.getAttribute(LOGIN_TOKEN_ID);
        String tokenId = request.getParameter(LOGIN_TOKEN_ID);
        if (sessionTokenId == null || StringUtil.isEmpty(tokenId)) {
            attr.addFlashAttribute(FAIL_STR, "请刷新页面,重新登录");
            return "redirect:/platform/main/toLogin";
        }
        String login_account = request.getParameter("login");
        String password = request.getParameter("password");
        if (StringUtil.isEmpty(login_account) || StringUtil.isEmpty(password)) {
            attr.addFlashAttribute(FAIL_STR, "账号或密码不能为空 ");
            return "redirect:/platform/main/toLogin";
        } else {
            session.removeAttribute(LOGIN_TOKEN_ID);
            // Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:config/shiro.ini");
            // // step2 解析shiro.ini 返回配置的 SecutiryManager 实例
            // SecurityManager securityManager = factory.getInstance();
            // // step3
            // SecurityUtils.setSecurityManager(securityManager);
            
            Subject currentUser = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(login_account, MD5Util.encryptMD5(password));
            token.setRememberMe(true);
            try {
                currentUser.login(token);
                logger.info("用户：[" + token.getUsername() + "]登录成功");
                model.addAttribute("currentUsername", currentUser.getPrincipal());
            } catch (UnknownAccountException uae) {
                attr.addFlashAttribute(FAIL_STR, "账号或密码不正确");
                return "redirect:/platform/main/toLogin";
            } catch (AuthenticationException e) {
                e.printStackTrace();
                attr.addFlashAttribute(FAIL_STR, "账号或密码不正确");
                return "redirect:/platform/main/toLogin";
            } catch (Exception e) {
                attr.addFlashAttribute(FAIL_STR, "系统异常，请重试");
                return "redirect:/platform/main/toLogin";
            }
            
//            APermission permission = permissionService.findById("4028b29557ad1da40157ad1da45d0000");
//            logger.info("permission={}", permission);
            List<ADictType> dictList = dictService.getAllType("cs");
            System.out.println(dictList);
            return "platform/home";
        }
    }
    
    /**
     * <一句话功能简述> 退出登录
     * 
     * @modefy : yaobin 2016-10-9
     * @return
     */
    @RequestMapping(value = "/logout")
    public String logout() {
        Subject currentUser = SecurityUtils.getSubject();
        try {
            currentUser.logout();
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        return "redirect:/platform/main/toLogin";
    }
    
}
