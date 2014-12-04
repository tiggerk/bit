package java63.web03.control.json;

import java.util.ArrayList;
import java.util.HashMap;

import java63.web03.dao.MemberDao;
import java63.web03.domain.Member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller("json.authControl")
@RequestMapping("/json/auth")
@SessionAttributes({"loginUser", "requestUrl"})
public class AuthControl {
  @Autowired MemberDao memberDao;

  @RequestMapping(value="/loginUser", method=RequestMethod.GET)
  public Object loginUser(HttpSession session) throws Exception{
    HashMap<String, Object> resultMap = new HashMap<>();
    
    if (session.getAttribute("loginUser") != null) {
      resultMap.put("status", "success");
      resultMap.put("loginUser", session.getAttribute("loginUser"));
    } else {
      resultMap.put("stauts", "fail");
    }
    return resultMap;
  }
  
  @RequestMapping(value="/login.do", method=RequestMethod.GET)
  public String form (
      @CookieValue(/*required=false)*/defaultValue="") String uid,
      Model model) throws Exception{
    model.addAttribute("uid", uid);
    return "auth/LoginForm";
  }

  @RequestMapping(value="/login", method=RequestMethod.POST)
  public String login(
      String uid,
      String pwd,
      String save,
      String requestUrl, /* 세션에 저장된 값을 달라고 하려면? */
      HttpServletResponse response,
      Model model,
      SessionStatus status) throws Exception{

    ArrayList<Cookie> cookieList = new ArrayList<>();

    if (save != null) { // 쿠키로 사용자 아이디 저장
      Cookie cookie = new Cookie("uid", uid);
      cookie.setMaxAge(60 * 60 * 24 * 15);
      response.addCookie(cookie);
    } else {
      Cookie cookie = new Cookie("uid", "");
      cookie.setMaxAge(0);  // 무효화시킴
      cookieList.add(cookie);
    }

    HashMap<String,String> params = new HashMap<>();
    params.put("userId", uid);
    params.put("password", pwd);
    Member member = memberDao.existUser(params);

    if (member != null) {
      model.addAttribute("loginUser", member);
      if (requestUrl != null) {
        return "redirect:" + requestUrl;
      } else {
        return "redirect:../product/list.do";
      }

    } else {
      // @SessionAttributes로 지정된 값을 무효화 시킨다.
      // => 주의!!!! 세션 전체를 무효화시키지 않는다.
      status.setComplete(); // 세션을 제거하고 새로 만든다.
      return "redirect:login.do";  // 로그인 폼으로 보낸다.
    }
  }


  @RequestMapping("/logout")
  public String execute(SessionStatus status) throws Exception {
    status.setComplete();
    return "redirect:login.do";
  }
}



