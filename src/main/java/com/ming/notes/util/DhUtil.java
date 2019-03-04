package com.ming.notes.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import java.security.*;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * DH 非对称加密算法
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
public class DhUtil {

    /**
     * DH 发送方密钥
     * @return
     */
    public KeyPair initSendKey() {
        try {
            KeyPairGenerator sendKeyPairGenerator = KeyPairGenerator.getInstance("DH");
            sendKeyPairGenerator.initialize(512);
            KeyPair sendKeyPair = sendKeyPairGenerator.generateKeyPair();
//            System.out.println("send KeyPair:" + sendKeyPair);
            return sendKeyPair;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * DH 接收方密钥
     * @return
     */
    public Map initRecvKey(KeyPair sendKeyPair) {
        try {
            Map map = new HashMap();
            byte[] sendPublicKeys = sendKeyPair.getPublic().getEncoded();

            KeyFactory recvKeyFactory = KeyFactory.getInstance("DH");
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(sendPublicKeys);
            PublicKey recvPublicKey = recvKeyFactory.generatePublic(x509EncodedKeySpec);

            DHParameterSpec params = ((DHPublicKey) recvPublicKey).getParams();
            KeyPairGenerator recvKeyPairGenerator = KeyPairGenerator.getInstance("DH");
            recvKeyPairGenerator.initialize(params);
            KeyPair recvKeyPair = recvKeyPairGenerator.generateKeyPair();
            PrivateKey recvPrivateKey = recvKeyPair.getPrivate();
            byte[] recvPublicKeys = recvKeyPair.getPublic().getEncoded();

//            System.out.println("DH recvPublicKey:" + recvPublicKey);
//            System.out.println("DH recvPublicKeys:" + recvPublicKeys);
//            System.out.println("DH recvPrivateKey:" + recvPrivateKey);
            map.put("recvPublicKey", recvPublicKey);
            map.put("recvPublicKeys", recvPublicKeys);
            map.put("recvPrivateKey", recvPrivateKey);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * DH 密钥构建
     * @return
     */
    public Map<String, SecretKey> createKey(KeyPair sendKeyPair, Map map) {
        try {
            Map<String, SecretKey> keys = new HashMap<>();

            PrivateKey recvPrivateKey = (PrivateKey) map.get("recvPrivateKey");
            PublicKey recvPublicKey = (PublicKey) map.get("recvPublicKey");
            byte[] recvPublicKeys = (byte[]) map.get("recvPublicKeys");
//            System.out.println("recvPrivateKey:" + recvPrivateKey);
//            System.out.println("recvPublicKey:" + recvPublicKey);
//            System.out.println("recvPublicKeys:" + recvPublicKeys);

            KeyAgreement recvKeyAgreement = KeyAgreement.getInstance("DH");
            recvKeyAgreement.init(recvPrivateKey);
            recvKeyAgreement.doPhase(recvPublicKey, true);
            SecretKey recvSecretKey = recvKeyAgreement.generateSecret("DES");
//            System.out.println("recvSecretKey:" + recvSecretKey);

            KeyFactory sendKeyFactory = KeyFactory.getInstance("DH");
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(recvPublicKeys);
            PublicKey sendPublicKey = sendKeyFactory.generatePublic(x509EncodedKeySpec);
            KeyAgreement sendKeyAgreement = KeyAgreement.getInstance("DH");
            sendKeyAgreement.init(sendKeyPair.getPrivate());
            sendKeyAgreement.doPhase(sendPublicKey, true);
            SecretKey sendSecretKey = sendKeyAgreement.generateSecret("DES");
//            System.out.println("sendSecretKey:" + sendSecretKey);

            if (Objects.equals(recvSecretKey, sendSecretKey)) {
                System.out.println("ok");
            }
            keys.put("sendSecretKey", sendSecretKey);
            keys.put("recvSecretKey", recvSecretKey);
            return keys;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * DH 加密
     * @return
     */
    public byte[] dhEncode(String str, Map<String, SecretKey> map) {
        try {
            SecretKey sendSecretKey = map.get("sendSecretKey");
            System.out.println("sendSecretKey:" + sendSecretKey);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, sendSecretKey);
            byte[] encodes = cipher.doFinal(str.getBytes());
            String encode = Base64.encodeBase64String(encodes);
            System.out.println("DH加密:" + encode);
            return encodes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * DH 解密
     * @return
     */
    public String dhDecode(byte[] bytes, Map<String, SecretKey> map) {
        try {
            SecretKey recvSecretKey = map.get("recvSecretKey");
            System.out.println("recvSecretKey:" + recvSecretKey);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, recvSecretKey);
            byte[] decodes = cipher.doFinal(bytes);
            String decode = new String(decodes);
            System.out.println("DH解密:" + decode);
            return decode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}