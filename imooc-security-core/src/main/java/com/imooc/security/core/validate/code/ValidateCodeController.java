package com.imooc.security.core.validate.code;

import org.springframework.http.HttpRequest;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @program: imooc-security
 * @description:
 * @author: Neo.Wang
 * @create: 2018-03-18 19:28
 **/
@RestController
public class ValidateCodeController {
    public static final String SESSION_KEY = "SESSION_KEY_IMAGE_CODE";

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @GetMapping("/code/image")
    public void createCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ImageCode imageCode = createImageCode(request);
        sessionStrategy.setAttribute(new ServletWebRequest(request),SESSION_KEY,imageCode);
        ImageIO.write(imageCode.getImage(),"jpeg",response.getOutputStream());
    }

    private ImageCode createImageCode(HttpServletRequest request) {
        int width = 67;
        int height = 23;
        //生成图片
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
        //给图片画线
        Graphics graphics = image.getGraphics();
        Random random = new Random();
        graphics.setColor(getRandColor(200,250));
        graphics.fillRect(0,0,width,height);
        graphics.setFont(new Font("Times New Rome",Font.ITALIC,20));
        graphics.setColor(getRandColor(160,200));
        for (int i = 0; i < 155; i++){
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            graphics.drawLine(x,y,xl,yl);
        }

        //生成四位的随机数写到图片上
        String sRand = "";
        for(int i = 0; i < 4; i++){
            String rand = String.valueOf(random.nextInt(10));
            sRand += rand;
            graphics.setColor(new Color(20 + random.nextInt(110),20 + random.nextInt(110),20 + random.nextInt(110)));
            graphics.drawString(rand,13 * i + 6,16);
        }
        graphics.dispose();
        return new ImageCode(image,sRand,60);
    }

    private Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }
}
