package login_cyh.demo.controller;

import login_cyh.demo.dao.RegisterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @创建人 Missbear
 * @创建时间 2018.9.28
 * @描述
 */
@Controller
@RequestMapping("/Register")
public class RegisterController {

    @Autowired
    private RegisterMapper registerMapper;

    @RequestMapping("/register")
    public String register()
    {
        return "/Register/register";
    }

    @RequestMapping(value="/register_success",method= RequestMethod.GET)
    public String register_success(){
        return "/Register/register_success";
    }

    @RequestMapping("/user_inserttodb")
    @ResponseBody
    public String user_inserttodb(HttpServletRequest request)throws ServletException,IOException
    {
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式;
        String id=df.format(new Date()).toString();
        String uu="";
        try
        {
            registerMapper.insertDb(id, username, pwd);
            uu = "[{msg:'success'}]";
        }
        catch (Exception e)
        {
            uu = "[{msg:'fail',failInfo:'" + e.toString() + "'}]";
        }
        return uu;
    }

}
