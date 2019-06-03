package tk.wkkany.web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/cheakCodeServlet")
public class CheakBoxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置图片的宽高
            int width=100;
            int height=50;
         //创建图片对象
            BufferedImage img=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
            //美化图片
            //创建画笔
        Graphics g = img.getGraphics();
        g.setColor(Color.pink);
        g.fillRect(0,0,width,height);
        //2.2画边框
        g.setColor(Color.blue);
        g.drawRect(0,0,width-1,height-1);
        //生成字符串包括验证码的字符
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz0123456789~@#$%^&*()_+-";
        //生成随机数据
        Random random=new Random();
        StringBuilder sb=new StringBuilder();
        for (int i = 1; i < 5; i++) {
            //获取随机下标
            int index = random.nextInt(str.length());
            //获取随机随机字符串
            char ch = str.charAt(index);
            sb.append(ch);
            //填写验证码
            g.drawString(ch+"",width/5*i,height/2);
        }
        String checkCode_session = sb.toString();
        //将验证码存入session
        request.getSession().setAttribute("checkCode_session",checkCode_session);

        //2.4画干扰线
        g.setColor(Color.GREEN);

        //随机生成坐标点

        for (int i = 0; i < 10; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);

            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            g.drawLine(x1,y1,x2,y2);
        }






        //3.将图片输出到页面展示
        ImageIO.write(img,"jpg",response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doPost(request,response);
    }
}
