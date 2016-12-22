package com.itclub.ssh.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class CheckCodeUtil {

    /**
     * 生成验证码图片
     *
     * @param securityCode 验证码字符
     * @return BufferedImage 图片
     */
    public static BufferedImage createImage(String securityCode) {
//验证码长度
        int codeLength = securityCode.length();
//字体大小
        int fSize = 15;
        int fWidth = fSize + 1;
        //图片宽度
        int width = codeLength * fWidth + 6;
        //图片高度
        int height = fSize * 2 - 5;

        //图片
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.createGraphics();

        //设置背景色
        g.setColor(Color.WHITE);
        //填充背景,用白色填充
        g.fillRect(0, 0, width, height);

        //设置边框颜色
        g.setColor(Color.LIGHT_GRAY);
        //边框字体样式
        g.setFont(new Font("Arial", Font.BOLD, height - 2));
        //绘制边框
        g.drawRect(0, 0, width - 1, height - 1);

        //绘制噪点
        Random rand = new Random();
        //设置噪点颜色
        //g.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i < codeLength * 7; i++) {
            int x = rand.nextInt(width);
            int y = rand.nextInt(height);
            g.setColor(new Color(rand.nextInt(255),
                    rand.nextInt(255), rand.nextInt(255)));
            //绘制1*1大小的矩形
            g.drawRect(x, y, 1, 1);
            //g.setColor(Color.LIGHT_GRAY);
        }

        //绘制验证码
        int codeY = height - 10;
        //设置字体颜色和样式
        //g.setColor(new Color(19,148,246));
        g.setFont(new Font("Georgia", Font.BOLD, fSize + 2));
        for (int i = 0; i < codeLength; i++) {
            g.setColor(new Color(rand.nextInt(255),
                    rand.nextInt(255), rand.nextInt(255)));
            g.drawString(String.valueOf(securityCode.charAt(i)),
                    i * 16 + 5, codeY);

        }
        //关闭资源
        g.dispose();

        return image;
    }

    /**
     * 返回验证码图片的流格式
     *
     * @param securityCode 验证码
     * @return ByteArrayInputStream 图片流
     */
    public static ByteArrayInputStream getImageAsInputStream(String securityCode) {
        BufferedImage image = createImage(securityCode);
        return convertImageToStream(image);
    }

    /**
     * 将BufferedImage转换成ByteArrayInputStream
     *
     * @param image 图片
     * @return ByteArrayInputStream 流
     */
    private static ByteArrayInputStream convertImageToStream(BufferedImage image) {
        ByteArrayInputStream inputStream = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] bimage = null;
        try {
            ImageIO.write(image, "jpeg", bos);
            bimage = bos.toByteArray();
            inputStream = new ByteArrayInputStream(bimage);
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
        //JPEGImageEncoder
        /*JPEGImageEncoder jpeg = JPEGCodec.createJPEGEncoder(bos);
   try {
            jpeg.encode(image);
            byte[] bts = bos.toByteArray();
            inputStream = new ByteArrayInputStream(bts);
        } catch (ImageFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputStream;*/
        //返回输入流
        return inputStream;
    }

}
