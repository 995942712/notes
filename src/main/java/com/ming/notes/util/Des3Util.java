package com.ming.notes.util;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import java.security.Key;
import java.security.SecureRandom;
import java.security.Security;

/**
 * 3重 DES 对称加密算法
 *
 * ///////////////////////////////////////////////////
 * //                    _ooOoo_                    //
 * //                   o8888888o                   //
 * //                   88" . "88                   //
 * //                   (| -_- |)                   //
 * //                   O\  =  /O                   //
 * //                ____/`---'\____                //
 * //              .'  \\|     |//  `.              //
 * //             /  \\|||  :  |||//  \             //
 * //            /  _||||| -:- |||||-  \            //
 * //            |   | \\\  -  /// |   |            //
 * //            | \_|  ''\---/''  |   |            //
 * //            \  .-\__  `-`  ___/-. /            //
 * //          ___`. .'  /--.--\  `. . __           //
 * //       ."" '<  `.___\_<|>_/___.'  >'"".        //
 * //      | | :  `- \`.;`\ _ /`;.`/ - ` : | |      //
 * //      \  \ `-.   \_ __\ /__ _/   .-` /  /      //
 * // ======`-.____`-.___\_____/___.-`____.-'====== //
 * //                    `=---='                    //
 * // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ //
 * //          佛祖保佑        永无BUG               //
 * // 佛曰:                                         //
 * //        写字楼里写字间,写字间里程序员.            //
 * //        程序人员写程序,又拿程序换酒钱.            //
 * //        酒醒只在网上坐,酒醉还来网下眠.            //
 * //        酒醉酒醒日复日,网上网下年复年.            //
 * //        但愿老死电脑间,不愿鞠躬老板前.            //
 * //        奔驰宝马贵者趣,公交自行程序员.            //
 * //        别人笑我忒疯癫,我笑自己命太贱.            //
 * //        不见满街漂亮妹,哪个归得程序员.            //
 * ///////////////////////////////////////////////////
 */
public class Des3Util {

    /**
     * JDK_3DES 生成key,并转换
     * @return
     */
    public Key jdk3DesKey() {
        try {
            //生成key
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DESede");
            keyGenerator.init(new SecureRandom());
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] encodeds = secretKey.getEncoded();
            //key转换
            DESedeKeySpec deSedeKeySpec = new DESedeKeySpec(encodeds);
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DESede");
            Key key = secretKeyFactory.generateSecret(deSedeKeySpec);
            return key;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * JDK_3DES加密
     * @param str
     * @param key
     * @return
     */
    public byte[] jdk3DesEncode(String str, Key key) {
        try {
            Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encodes = cipher.doFinal(str.getBytes());
            System.out.println(encodes);
            String encode = Hex.encodeHexString(encodes);
            System.out.println("JDK_3DES加密:" + encode);
            return encodes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * JDK_3DES解密
     * @param bytes
     * @param key
     * @return
     */
    public String jdk3DesDecode(byte[] bytes, Key key) {
        try {
            Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decodes = cipher.doFinal(bytes);
            System.out.println(decodes);
            String decode = new String(decodes);
            System.out.println("JDK_3DES解密:" + decode);
            return decode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * BC_3DES 生成key,并转换
     * @return
     */
    public Key bc3DesKey() {
        try {
            Security.addProvider(new BouncyCastleProvider());
            //生成key
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DESede", "BC");
            keyGenerator.getProvider();
            keyGenerator.init(new SecureRandom());
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] encodeds = secretKey.getEncoded();
            //key转换
            DESedeKeySpec deSedeKeySpec = new DESedeKeySpec(encodeds);
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DESede");
            Key key = secretKeyFactory.generateSecret(deSedeKeySpec);
            return key;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * BC_3DES 加密
     * @param str
     * @param key
     * @return
     */
    public byte[] bc3DesEncode(String str, Key key) {
        try {
            Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encodes = cipher.doFinal(str.getBytes());
            System.out.println(encodes);
            String encode = Hex.encodeHexString(encodes);
            System.out.println("BC_3DES加密:" + encode);
            return encodes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * BC_3DES 解密
     * @param bytes
     * @param key
     * @return
     */
    public String bc3DesDecode(byte[] bytes, Key key) {
        try {
            Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decodes = cipher.doFinal(bytes);
            System.out.println(decodes);
            String decode = new String(decodes);
            System.out.println("BC_3DES解密:" + decode);
            return decode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}