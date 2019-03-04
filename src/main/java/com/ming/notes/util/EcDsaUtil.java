package com.ming.notes.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import java.security.*;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * ECDSA 数字签名算法
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
public class EcDsaUtil {

    /**
     * 初始化
     * @return
     */
    public KeyPair initEcDsaKey() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
            keyPairGenerator.initialize(256);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            System.out.println("ECDSA签名_KeyPair:" + keyPair);
            return keyPair;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 初始化JDK_ECDSA签名公钥
     * @return
     */
    public ECPublicKey initEcDsaPublicKey(KeyPair keyPair) {
        try {
            ECPublicKey ecPublicKey = (ECPublicKey)keyPair.getPublic();
            System.out.println("JDK_ECDSA签名公钥:" + Base64.encodeBase64String(ecPublicKey.getEncoded()));
            return ecPublicKey;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 初始化JDK_ECDSA签名私钥
     * @return
     */
    public ECPrivateKey initEcDsaPrivateKey(KeyPair keyPair) {
        try {
            ECPrivateKey ecPrivateKey = (ECPrivateKey)keyPair.getPrivate();
            System.out.println("JDK_ECDSA签名私钥:" + Base64.encodeBase64String(ecPrivateKey.getEncoded()));
            return ecPrivateKey;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * JDK_ECDSA 执行签名
     * @return
     */
    public byte[] jdkEncode(ECPrivateKey ecPrivateKey, String str) {
        try {
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(ecPrivateKey.getEncoded());
            KeyFactory keyFactory = KeyFactory.getInstance("EC");
            PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
            Signature signature = Signature.getInstance("SHA1withECDSA");
            signature.initSign(privateKey);
            signature.update(str.getBytes());
            byte[] encodes = signature.sign();
            String encode = Hex.encodeHexString(encodes);
            System.out.println("JDK_ECDSA执行签名:" + encode);
            return encodes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * JDK_ECDSA 验证签名
     * @return
     */
    public boolean jdkDecode(ECPublicKey ecPublicKey, String str, byte[] bytes) {
        try {
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(ecPublicKey.getEncoded());
            KeyFactory keyFactory = KeyFactory.getInstance("EC");
            PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
            Signature signature = Signature.getInstance("SHA1withECDSA");
            signature.initVerify(publicKey);
            signature.update(str.getBytes());
            boolean verify = signature.verify(bytes);
            System.out.println("JDK_ECDSA验证签名:" + verify);
            return verify;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}