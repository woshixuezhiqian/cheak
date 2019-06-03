package tk.wkkany.web.servlet;

import org.apache.commons.beanutils.BeanUtils;
import tk.wkkany.domain.User;
import tk.wkkany.service.UserService;
import tk.wkkany.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取验证码
        String verifycode = request.getParameter("verifycode");
        //校验验证码
        HttpSession session = request.getSession();
        String  checkCode_session =(String) session.getAttribute("checkCode_session");
        session.removeAttribute("checkCode_session");
        if (!checkCode_session.equalsIgnoreCase(verifycode)){
            //验证码不正确
            //提示，且跳转登陆界面
            request.setAttribute("login_msg","验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }
        //封装user对象
        Map<String, String[]> map = request.getParameterMap();
        User user =new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //调用service查询
        UserService service=new UserServiceImpl();
        User loginUser = service.login(user);
        if (loginUser!=null){
            //登陆成功
            //存入用户到session
            session.setAttribute("user",loginUser);
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }else {
            //登陆失败
            //提示，且跳转登陆界面
            request.setAttribute("login_msg","账号密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
