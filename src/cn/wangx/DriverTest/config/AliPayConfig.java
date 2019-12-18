package cn.wangx.DriverTest.config;

public class AliPayConfig {
        // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数
        public static String return_url = "http://localhost:8080/success.jsp";
        // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
        public static String notify_url = "http://localhost:8080/notify";
        // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
        public static String app_id = "2016092600599379";
        // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
        public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwgjxNi5sJRqfSkzEXl7H8gnLLAFShKG4Jb2Vcvgaqm+wTrrEvYC6GbQkTVOwblhHgRe4bWziurhFOujXbwaftr7uWXuAUZPrBvqxMCLvtZ2HrSWXxMZqtKno5YRVA+sHPP0Ju6ppDeaaglDohjFUdKuZbQh/TudjEqWDQbbnORXBdGddt7c63WN71Pt8LmsMBzpNgdTn9oijlB4aUhdDvPNaga6qxB3fvfTdoS4qjY1dua8k7CJT4EI7qAxmsAAIUbUAR/v5eYDj79aQxnxnhw1P7A22ZGSZR60InsMo7yM6qjKyXrUpdlhshV9p72j+ky1hhl7wYnugQsDsJwXN5QIDAQAB";
        // 商户私钥，您的PKCS8格式RSA2私钥
        public static String merchant_private_key = "";
        // 签名方式
        public static String sign_type = "RSA2";
        // 字符编码格式
        public static String charset = "utf-8";
        // 支付宝网关
        public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
}
