package com.deer.component.enumm;

/**
 * @ClassName: ContentEnum
 * @Author: Mr_Deer
 * @Date: 2019/5/23 16:35
 * @Description:
 */
public enum ContentEnum {

    SYSTEM_CONSOLE_EXCEPTION_INFO("控制台日志报错：\n{}", "在报错时，日志通过控制台打印错误原因格式"),
    SYSTEM_GLOBAL_EXCEPTION_INFO("\n全局异常处理：是否为 ajax 请求\t[ {} ]" +
            "\n发生异常的请求：\t[ {} ]" +
            "\n发生异常的 ClassName：\t[ {} ]" +
            "\n发生异常的 MethodName: \t[ {} ]" +
            "\n异常类型: \t[ {} ]" +
            "\n异常简报: \t[ {} ]" +
            "\n异常详情: \n", "在报错时，日志通过控制台打印错误原因格式");

    private String code;

    ContentEnum(String code, String mean) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
