package com.example.demo;

import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.MethodDoc;
import com.sun.javadoc.RootDoc;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
                for (MethodDoc methodDoc :doc.methods()){
                    System.out.println("methodDoc.commentText()>>>>"+methodDoc.getRawCommentText());
                }
            }
            return true;
        }


        public static void main(String[] args) {
            System.out.println("============================");
            try {
                Class testClass = Class.forName("com.example.demo.TestController");
                getInfoFromMethod(testClass);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    /**
     * 获取注释模板中的属性
     */
    public static String getInfoFromRemark(String classDir){
        /**
         *  类上注释文档==》服务名
         */
        /**
         *  方法上注释文档==》api名  作者
         *                    入参  名称，描述
         *                    出参  data 中的实体
         *  请求示例
         */
//        String className = System.getProperty("user.dir") + "/src/main/java/" + "com/example/demo/TestController.java";
        String[] docArgs = new String[]{"-doclet", DocletTest.class.getName(), classDir};
        com.sun.tools.javadoc.Main.execute(docArgs);
        return "";
    }


    /**
     * 获取方法上的有关属性和注解属性
     */
    public static String getInfoFromClass(Class testClass)throws Exception{

        RequestMapping requestMapping = (RequestMapping)testClass.getAnnotation(RequestMapping.class);
        System.out.println(requestMapping.value()[0]);
        return "";
    }
    /**
     * 获取方法上的有关属性和注解属性
     */
    public static String getInfoFromMethod(Class testClass) throws Exception{
            /**
             * 方法上的请求url  请求方式
             */
            Method[] methods = testClass.getDeclaredMethods();
            //循环方法
            for (Method method :methods){
//                    requestMapping = (RequestMapping)method.getAnnotation(RequestMapping.class);
                Annotation[]  methodAnnotations = method.getDeclaredAnnotations();
                for (Annotation methodAnnotation : methodAnnotations){
                    if("RequestMapping".equals(methodAnnotation.annotationType().getSimpleName())){
                        RequestMapping methodRequestMapping = (RequestMapping)methodAnnotation;
                        System.out.println(">方法上的url>>>"+methodRequestMapping.value()[0]);
                        if (methodRequestMapping.method().length>0){
                            System.out.println("请求方式>>"+methodRequestMapping.method()[0]);
                        }else{
                            System.out.println("请求方式>>get");
                        }
                        System.out.println("方法名>>>>"+method.getName());
                    }
                }
                //获取方法参数上的属性
                getInfoFromMethodParams(method);
            }
            return "";
        }

    /**
     * 获取方法参数上的属性
     */
    public static String getInfoFromMethodParams(Method method){
        for(Parameter parameter : method.getParameters()){
            Annotation[] parameterAnnotations = parameter.getAnnotations();
            if(parameterAnnotations == null && parameterAnnotations.length > 0){
                //Get 请求 没有注释
                System.out.println("请求参数>>>" + parameter.getName());
                System.out.println("参数必要性>>true" );
            }else if ("RequestParam".equals(parameterAnnotations[0].annotationType().getSimpleName())){
                //Get 请求  有注释
                System.out.println("请求参数>>>" + ((RequestParam)parameterAnnotations[0]).value());
                System.out.println("参数必要性>>" + ((RequestParam)parameterAnnotations[0]).required());
            }else if("RequestBody".equals(parameterAnnotations[0].annotationType().getSimpleName())){
                //Post 请求
                System.out.println("请求参数>>>" + parameter.getName() );
                System.out.println("参数必要性>>true");
            }
        }
        return "";
    }


    /**
     *  从示例url中获取相应的示例里参数 和返回值的示例
     */
    public String getSampleValueFromUrl(String url){
        /**
         * 1.获取请求参数的示例值
         * 2.发送请求
         * 3.获取返回参数的示例值
         */
        return "";
    }



}
