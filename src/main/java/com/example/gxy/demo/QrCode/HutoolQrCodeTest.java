package com.example.gxy.demo.QrCode;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;

import java.awt.*;

/**
 * @author GXY
 * @Package com.example.gxy.demo.QrCode
 * @date 2020/12/28 15:37
 * @Copyright © 2020-2021 新流通
 * @Description:Hutool工具包生成的二维码
 * https://hutool.cn/docs/#/extra/二维码工具-QrCodeUtil
 * https://blog.csdn.net/piaoyunlive/article/details/105748193
 */
public class HutoolQrCodeTest {

    public static void main(String[] args) {
        try{
            QrCodeUtil.generate("我是高希阳，这是我用Hutool工具包生成的二维码", 300, 300, FileUtil.file("d:/qrcode.jpg"));


            QrConfig config = new QrConfig(300, 300);
            // 设置边距，既二维码和背景之间的边距
            config.setMargin(3);
            // 设置前景色，既二维码颜色（青色）
            config.setForeColor(Color.CYAN.getRGB());
            // 设置背景色（灰色）
            config.setBackColor(Color.GRAY.getRGB());
            // 生成二维码到文件，也可以到流
            QrCodeUtil.generate("http://hutool.cn/", config, FileUtil.file("d:/qrcode1.jpg"));

            System.out.println("生成二维码完成。。。");

            //解析二维码
            String s = analysisQrCode("d:/qrcode.jpg");
            System.out.println("解析二维码内容为："+s);

        }catch(Exception e) {
            System.out.println("生成二维码异常。。。");
            e.printStackTrace();
        }
    }

    /**
     * 解析二维码
     * @param path 二维码图片路径
     * @return
     */
    public static String analysisQrCode(String path){
        // decode -> "http://hutool.cn/"
        String decode = QrCodeUtil.decode(FileUtil.file("d:/qrcode.jpg"));
        return decode;
    }
}
