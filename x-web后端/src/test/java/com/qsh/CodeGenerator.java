package com.qsh;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class CodeGenerator {
        public static void main(String[] args) {
            String url = "jdbc:mysql:///xdb";
            String username = "root";
            String password = "7456";
            String author = "qsh";
            String outputDir = "E:\\code\\java\\x-web\\src\\main\\java";
            String basePackage = "com.qsh";
            String moduleName = "sys";
            String mapperLocation = "E:\\code\\java\\x-web\\src\\main\\resources\\mapper\\" + moduleName;
            String tableName = "x_user,x_menu,x_role,x_role_menu,x_user_role";
            String tablePrefix = "x_";
            FastAutoGenerator.create(url, username, password)
                    .globalConfig(builder -> {
                        builder.author(author) // 设置作者
                                //.enableSwagger() // 开启 swagger 模式
                                //.fileOverride() // 覆盖已生成文件
                                .outputDir(outputDir); // 指定输出目录
                    })
                    .packageConfig(builder -> {
                        builder.parent(basePackage) // 设置父包名
                                .moduleName(moduleName) // 设置父包模块名
                                .pathInfo(Collections.singletonMap(OutputFile.xml, mapperLocation)); // 设置mapperXml生成路径
                    })
                    .strategyConfig(builder -> {
                        builder.addInclude(tableName) // 设置需要生成的表名
                                .addTablePrefix(tablePrefix); // 设置过滤表前缀
                    })
                    .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                    .execute();
        }

    }
