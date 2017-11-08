package base.sort_arithmetic.encrypt.whole;

import java.util.Map;

/**
 * Created by Administrator on 2017/6/23.
 */
public class RSATester {
    static String publicKey;
    static String privateKey;

    static {
        try {
            Map<String, Object> keyMap = RSAUtils.genKeyPair();
            publicKey = RSAUtils.getPublicKey(keyMap);
            privateKey = RSAUtils.getPrivateKey(keyMap);
            System.err.println("公钥: \n\r" + publicKey);
            System.err.println("私钥： \n\r" + privateKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        test();
//        testSign();
    }

    static void test() throws Exception {
        System.err.println("公钥加密——私钥解密");
//        String source = "这是一行没有任何意义的文字，你看完了等于没看，不是吗？";
        String source = "{\n" +
                "\t\t\"retcode\" : \"000000\",\n" +
                "\t\t\"response_sn\" : \"20161025151206392CRPR\",\n" +
                "\t\t\"retmsg\" : \"交易成功\",\n" +
                "\t\t\"request_sn\" : \"f5934bf6fceb4440ab4561c98429fb14\",\n" +
                "\t\t\"retdate\" : 1477379527402,\n" +
                "\t\t\"version\" : \"1.0\",\n" +
                "\t\t\"retdata\" : {\n" +
                "\t\t\t\"idNo\" : \"32058219810425261X\",\n" +
                "\t\t\t\"riskInfo\" : [{\n" +
                "\t\t\t\t\t\"riskSort\" : \"04\",\n" +
                "\t\t\t\t\t\"amountZone\" : \"0\",\n" +
                "\t\t\t\t\t\"txnDate\" : \"2014/11/07\"\n" +
                "\t\t\t\t}, {\n" +
                "\t\t\t\t\t\"riskSort\" : \"03\",\n" +
                "\t\t\t\t\t\"amountZone\" : \"0\",\n" +
                "\t\t\t\t\t\"txnDate\" : \"2016/04/15\"\n" +
                "\t\t\t\t}\n" +
                "\t\t\t],\n" +
                "\t\t\t\"name\" : \"赵建国\",\n" +
                "\t\t\t\"idNoType\" : \"101\"\n" +
                "\t\t}\n" +
                "\t}";
        System.out.println("\r加密前文字：\r\n" + source);
        byte[] data = source.getBytes();
        byte[] encodedData = RSAUtils.encryptByPublicKey(data, publicKey);
        System.out.println("加密后文字：\r\n" + new String(encodedData));
        byte[] decodedData = RSAUtils.decryptByPrivateKey(encodedData, privateKey);
        String target = new String(decodedData);
        System.out.println("解密后文字: \r\n" + target);
    }

    static void testSign() throws Exception {
        System.err.println("私钥加密——公钥解密");
        String source = "这是一行测试RSA数字签名的无意义文字";
        System.out.println("原文字：\r\n" + source);
        byte[] data = source.getBytes();
        byte[] encodedData = RSAUtils.encryptByPrivateKey(data, privateKey);
        System.out.println("加密后：\r\n" + new String(encodedData));
        byte[] decodedData = RSAUtils.decryptByPublicKey(encodedData, publicKey);
        String target = new String(decodedData);
        System.out.println("解密后: \r\n" + target);
        System.err.println("私钥签名——公钥验证签名");
        String sign = RSAUtils.sign(encodedData, privateKey);
        System.err.println("签名:\r" + sign);
        boolean status = RSAUtils.verify(encodedData, publicKey, sign);
        System.err.println("验证结果:\r" + status);
    }
}
