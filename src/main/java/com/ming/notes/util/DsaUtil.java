package com.ming.notes.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import java.security.*;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * DSA 数字签名算法
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
public class DsaUtil {

    /**
     * 初始化
     * @return
     */
    public KeyPair initDsaKey() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DSA");
            keyPairGenerator.initialize(512);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            System.out.println("DSA签名_KeyPair:" + keyPair);
            return keyPair;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 初始化JDK_DSA签名公钥
     * @return
     */
    public DSAPublicKey initDsaPublicKey(KeyPair keyPair) {
        try {
            DSAPublicKey dsaPublicKey = (DSAPublicKey)keyPair.getPublic();
            System.out.println("JDK_DSA签名公钥:" + Base64.encodeBase64String(dsaPublicKey.getEncoded()));
            return dsaPublicKey;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 初始化JDK_DSA私钥
     * @return
     */
    public DSAPrivateKey initDsaPrivateKey(KeyPair keyPair) {
        try {
            DSAPrivateKey dsaPrivateKey = (DSAPrivateKey)keyPair.getPrivate();
            System.out.println("JDK_DSA签名私钥:" + Base64.encodeBase64String(dsaPrivateKey.getEncoded()));
            return dsaPrivateKey;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * JDK_DSA 执行签名
     * @return
     */
    public byte[] jdkEncode(DSAPrivateKey dsaPrivateKey, String str) {
        try {
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(dsaPrivateKey.getEncoded());
            KeyFactory keyFactory = KeyFactory.getInstance("DSA");
            PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
            Signature signature = Signature.getInstance("SHA1withDSA");
            signature.initSign(privateKey);
            signature.update(str.getBytes());
            byte[] encodes = signature.sign();
            String encode = Hex.encodeHexString(encodes);
            System.out.println("JDK_DSA执行签名:" + encode);
            return encodes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * JDK_DSA 验证签名
     * @return
     */
    public boolean jdkDecode(DSAPublicKey dsaPublicKey, String str, byte[] bytes) {
        try {
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(dsaPublicKey.getEncoded());
            KeyFactory keyFactory = KeyFactory.getInstance("DSA");
            PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
            Signature signature = Signature.getInstance("SHA1withDSA");
            signature.initVerify(publicKey);
            signature.update(str.getBytes());
            boolean verify = signature.verify(bytes);
            System.out.println("JDK_DSA验证签名:" + verify);
            return verify;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}