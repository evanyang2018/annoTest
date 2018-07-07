package com.example.demo;

import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.MethodDoc;
import com.sun.javadoc.RootDoc;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Evan Yang
 * @Description:
 * @Date: Create in 10:46 2018/7/7
 * @Modificd By:
 */
public class DocletTest {



        public static boolean start(RootDoc root) {
            System.out.println(root.commentText());
            ClassDoc[] classes = root.classes();
            for (ClassDoc doc : classes) {
                System.out.println("doc.getRawCommentText()>>>"+doc.getRawCommentText());
//                for (String comment : doc.getRawCommentText().split("\n")){
//                    System.out.println("每行数据>>>>"+comment);
//                }


                for (MethodDoc methodDoc :doc.methods()){
                    System.out.println("methodDoc.commentText()>>>>"+methodDoc.getRawCommentText());
                }

            }
            return true;
        }


        public static void main(String[] args) {
            /**
             *  类上注释文档==》服务名
             */
            /**
             *  方法上注释文档==》api名  作者
             *                    入参  名称，描述
             *                    出参  data 中的实体
             *  请求示例
             */
            String className = System.getProperty("user.dir") + "/src/main/java/" + "com/example/demo/TestController.java";
//            String[] docArgs = new String[]{"-doclet", DocletTest.class.getName(), className};
//            com.sun.tools.javadoc.Main.execute(docArgs);


            System.out.println("============================");

            try {
                Annotation annotations = Class.forName("com.example.demo.TestController").getAnnotation(RequestMapping.class);
//                Annotation[] annotations = Class.forName("com.example.demo.TestController").getAnnotations();
//                for (Annotation annotation : annotations){
//
//                    System.out.println("注解>>>"+annotation.toString());
//                    System.out.println(annotation.toString());
//                    System.out.println(annotation);
//                }
                /**
                 * 类上的请求url
                 */
                Class testClass = Class.forName("com.example.demo.TestController");
                RequestMapping requestMapping = (RequestMapping)testClass.getAnnotation(RequestMapping.class);
                System.out.println(requestMapping.value()[0]);
                /**
                 * 方法上的请求url  请求方式
                 */
                Method[] methods = testClass.getDeclaredMethods();
                for (Method method :methods){
                    requestMapping = (RequestMapping)method.getAnnotation(RequestMapping.class);
                    System.out.println(">>>>>>>>>>start>>>>>>>");
                    System.out.println("方法名>>>>"+method.getName());
                    System.out.println("url>>"+requestMapping.value()[0]);
                    if (requestMapping.method().length>0){
                        System.out.println("method>>"+requestMapping.method()[0]);
                    }else{
                        System.out.println("method>>get");
                    }

                    System.out.println(">>>>>>>>>>>>end>>>>>");
                }



            } catch (Exception e) {
                e.printStackTrace();
            }

        }


    }
