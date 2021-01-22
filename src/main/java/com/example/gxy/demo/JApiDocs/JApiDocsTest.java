package com.example.gxy.demo.JApiDocs;

import io.github.yedaxia.apidocs.Docs;
import io.github.yedaxia.apidocs.DocsConfig;

/**
 * @author GXY
 * @Package com.example.gxy.demo.JApiDocs
 * @date 2020/11/8 18:17
 * @Copyright © 2020-2021 新流通
 * @Description: JApiDocsTest
 */
public class JApiDocsTest {
    public static void main(String[] args) {
        DocsConfig config = new DocsConfig();
        config.setProjectPath("D:\\workspaces\\idea\\spring-boot1"); // 项目根目录
        config.setProjectName("spring-boot1"); // 项目名称
        config.setApiVersion("V1.0");       // 声明该API的版本
        config.setDocsPath("D:\\workspaces\\test"); // 生成API 文档所在目录
        config.setAutoGenerate(Boolean.TRUE);  // 配置自动生成
        Docs.buildHtmlDocs(config); // 执行生成文档
    }
}
