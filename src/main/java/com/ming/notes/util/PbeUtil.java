package com.ming.notes.util;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.security.Key;
import java.security.SecureRandom;
import java.security.Security;

/**
 * PBE 对称加密算法
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
public class PbeUtil {

    /**
     * 初始化盐
     * @return
     */
    public byte[] initPbeSalt() {
        try {
            SecureRandom random = new SecureRandom();
            byte[] salt = random.generateSeed(8);
            return salt;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * JDK_PBE 生成密钥
     * @return
     */
    public Key jdkPbeKey(String password) {
        try {
            PBEKeySpec pbeKeySpec = new PBEKeySpec(password.toCharArray());
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBEWITHMD5andDES");
            Key key = factory.generateSecret(pbeKeySpec);
            return key;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * JDK_PBE 加密
     * @param str
     * @param key
     * @return
     */
    public byte[] jdkPbeEncode(String str, Key key, byte[] salt) {
        try {
            PBEParameterSpec pbeParameterSpec = new PBEParameterSpec(salt, 10);
            Cipher cipher = Cipher.getInstance("PBEWITHMD5andDES");
            cipher.init(Cipher.ENCRYPT_MODE, key, pbeParameterSpec);
            byte[] encodes = cipher.doFinal(str.getBytes());
            System.out.println(encodes);
            String encode = Base64.toBase64String(encodes);
            System.out.println("JDK_PBE加密:" + encode);
            return encodes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * JDK_PBE 解密
     * @param bytes
     * @param key
     * @return
     */
    public String jdkPbeDecode(byte[] bytes, Key key, byte[] salt) {
        try {
            PBEParameterSpec pbeParameterSpec = new PBEParameterSpec(salt, 10);
            Cipher cipher = Cipher.getInstance("PBEWITHMD5andDES");
            cipher.init(Cipher.DECRYPT_MODE, key, pbeParameterSpec);
            byte[] decodes = cipher.doFinal(bytes);
            System.out.println(decodes);
            String decode = new String(decodes);
            System.out.println("JDK_PBE解密:" + decode);
            return decode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * BC_PBE 生成密钥
     * @return
     */
    public Key bcPbeKey(String password) {
        try {
            Security.addProvider(new BouncyCastleProvider());
            PBEKeySpec pbeKeySpec = new PBEKeySpec(password.toCharArray());
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBEWITHMD5andDES", "BC");
            Key key = factory.generateSecret(pbeKeySpec);
            return key;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * BC_PBE 加密
     * @param str
     * @param key
     * @return
     */
    public byte[] bcPbeEncode(String str, Key key, byte[] salt) {
        try {
            PBEParameterSpec pbeParameterSpec = new PBEParameterSpec(salt, 10);
            Cipher cipher = Cipher.getInstance("PBEWITHMD5andDES");
            cipher.init(Cipher.ENCRYPT_MODE, key, pbeParameterSpec);
            byte[] encodes = cipher.doFinal(str.getBytes());
            System.out.println(encodes);
            String encode = Base64.toBase64String(encodes);
            System.out.println("BC_PBE加密:" + encode);
            return encodes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * BC_PBE 解密
     * @param bytes
     * @param key
     * @return
     */
    public String bcPbeDecode(byte[] bytes, Key key, byte[] salt) {
        try {
            PBEParameterSpec pbeParameterSpec = new PBEParameterSpec(salt, 10);
            Cipher cipher = Cipher.getInstance("PBEWITHMD5andDES");
            cipher.init(Cipher.DECRYPT_MODE, key, pbeParameterSpec);
            byte[] decodes = cipher.doFinal(bytes);
            System.out.println(decodes);
            String decode = new String(decodes);
            System.out.println("BC_PBE解密:" + decode);
            return decode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}