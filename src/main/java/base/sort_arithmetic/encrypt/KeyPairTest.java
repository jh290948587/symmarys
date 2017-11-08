package base.sort_arithmetic.encrypt;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;

import javax.crypto.Cipher;

import org.junit.Test;
/**
 * Created by Administrator on 2017/6/19.
 */
public class KeyPairTest {
    private static final String ALGOGRITHM = "RSA";
//    private static final String PUBLIC_KEY_PATH = "public.key";
//    private static final String PRIVATE_KEY_PATH = "private.key";
    private static final String PUBLIC_KEY_PATH = "E:\\key\\public";
    private static final String PRIVATE_KEY_PATH = "E:\\key\\private";

    @Test
    public void testGenerate() throws Exception {
        //KeyPairGenerator引擎类用于产生密钥对，JDK(7)默认支持的算法有，DiffieHellman、DSA、RSA、EC
        KeyPairGenerator generator = KeyPairGenerator.getInstance(ALGOGRITHM);
        //产生密钥对
        KeyPair keyPair = generator.generateKeyPair();
        //获取公钥
        RSAPublicKey publicKey = (RSAPublicKey)keyPair.getPublic();
        //获取私钥
        PrivateKey privateKey = keyPair.getPrivate();

        //将公钥与私钥写入文件，以备后用
        System.out.println(publicKey.getAlgorithm());
        System.out.println(publicKey.getFormat());
        byte[] encoded = publicKey.getEncoded();
        for(byte b : encoded){
            System.out.println(b);
        }
//        System.out.println(encoded);
        writeKey(PUBLIC_KEY_PATH, publicKey);
        writeKey(PRIVATE_KEY_PATH, privateKey);
    }

    @Test
    public void testEncryptAndDecrypt() throws Exception {
        Cipher cipher = Cipher.getInstance(ALGOGRITHM);
        //读取私钥，进行加密
        PublicKey privateKey = (PublicKey) readKey(PUBLIC_KEY_PATH);
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        //加密
        String sendInfo = "我的明文";
        byte[] results = cipher.doFinal(sendInfo.getBytes());

        //读取公钥，进行解密
        PrivateKey publicKey = (PrivateKey) readKey(PRIVATE_KEY_PATH);
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        //解密
        byte[] deciphered = cipher.doFinal(results);
        //得到明文
        String recvInfo = new String(deciphered);
        System.out.println(recvInfo);
    }

    public void writeKey(String path, Key key) throws Exception {
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(key);
        oos.close();
    }

    public Key readKey(String path) throws Exception {
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream bis = new ObjectInputStream(fis);
        Object object = bis.readObject();
        bis.close();
        return (Key) object;
    }
}
