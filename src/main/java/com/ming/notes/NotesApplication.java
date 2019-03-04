package com.ming.notes;

import com.ming.notes.util.*;
import javax.crypto.SecretKey;
import java.io.IOException;
import java.security.Key;
import java.security.KeyPair;
import java.security.interfaces.*;
import java.util.Map;

/**
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
public class NotesApplication {

    private static String str = "hello,world!";
    private static String password = "123456";

    public static void main(String[] args) {

//        Base64Util base64Util = new Base64Util();
//        System.out.println("=============================");
//        String jdkEncode = base64Util.jdkBase64Encode(str);
//        base64Util.jdkBase64Decoder(jdkEncode);
//        System.out.println("=============================");
//        String bcEncode = base64Util.bouncyCastleBase64Encode(str);
//        base64Util.bouncyCastleBase64Decoder(bcEncode.getBytes());
//        System.out.println("=============================");
//        String commonsEncode = base64Util.commonsBase64Encode(str);
//        base64Util.commonsBase64Decoder(commonsEncode.getBytes());
//        System.out.println("=============================");

//        DesUtil desUtil = new DesUtil();
//        System.out.println("=============================");
//        Key jdkKey = desUtil.jdkDesKey();
//        byte[] jdkEncode = desUtil.jdkDesEncode(str, jdkKey);
//        desUtil.jdkDesDecode(jdkEncode, jdkKey);
//        System.out.println("=============================");
//        Key bdKey = desUtil.bcDesKey();
//        byte[] bcEncode = desUtil.bcDesEncode(str, bdKey);
//        desUtil.bcDesDecode(bcEncode, bdKey);
//        System.out.println("=============================");

//        Des3Util desUtil = new Des3Util();
//        System.out.println("=============================");
//        Key jdkKey = desUtil.jdk3DesKey();
//        byte[] jdkEncode = desUtil.jdk3DesEncode(str, jdkKey);
//        desUtil.jdk3DesDecode(jdkEncode, jdkKey);
//        System.out.println("=============================");
//        Key bdKey = desUtil.bc3DesKey();
//        byte[] bcEncode = desUtil.bc3DesEncode(str, bdKey);
//        desUtil.bc3DesDecode(bcEncode, bdKey);
//        System.out.println("=============================");

//        AesUtil aesUtil = new AesUtil();
//        System.out.println("=============================");
//        Key jdkKey = aesUtil.jdkAesKey();
//        byte[] jdkEncode = aesUtil.jdkAesEncode(str, jdkKey);
//        aesUtil.jdkAesDecode(jdkEncode, jdkKey);
//        System.out.println("=============================");
//        Key bdKey = aesUtil.bcAesKey();
//        byte[] bcEncode = aesUtil.bcAesEncode(str, bdKey);
//        aesUtil.bcAesDecode(bcEncode, bdKey);
//        System.out.println("=============================");

//        PbeUtil pbeUtil = new PbeUtil();
//        byte[] salt = pbeUtil.initPbeSalt();
//        System.out.println("=============================");
//        Key jdkKey = pbeUtil.jdkPbeKey(password);
//        byte[] jdkEncode = pbeUtil.jdkPbeEncode(str, jdkKey, salt);
//        pbeUtil.jdkPbeDecode(jdkEncode, jdkKey, salt);
//        System.out.println("=============================");
//        Key bdKey = pbeUtil.bcPbeKey(password);
//        byte[] bcEncode = pbeUtil.bcPbeEncode(str, bdKey, salt);
//        pbeUtil.bcPbeDecode(bcEncode, bdKey, salt);
//        System.out.println("=============================");

//        DhUtil dhUtil = new DhUtil();
//        System.out.println("=============================");
//        KeyPair sendKeyPair = dhUtil.initSendKey();
//        System.out.println("=============================");
//        Map map = dhUtil.initRecvKey(sendKeyPair);
//        System.out.println("=============================");
//        Map<String, SecretKey> keys = dhUtil.createKey(sendKeyPair, map);
//        System.out.println("=============================");
//        byte[] bytes = dhUtil.dhEncode(str, keys);
//        System.out.println("=============================");
//        String s = dhUtil.dhDecode(bytes, keys);
//        System.out.println("=============================");

//        RsaUtil rsaUtil = new RsaUtil();
//        System.out.println("=============================");
//        KeyPair keyPair = rsaUtil.initRsaKey();
//        RSAPrivateKey rsaPrivateKey = rsaUtil.initRsaPrivateKey(keyPair);
//        RSAPublicKey rsaPublicKey = rsaUtil.initRsaPublicKey(keyPair);
//        System.out.println("=============================");
//        byte[] bytes = rsaUtil.privateEncode(rsaPrivateKey, str);
//        rsaUtil.publicDecode(rsaPublicKey, bytes);
//        System.out.println("=============================");
//        byte[] bytes1 = rsaUtil.publicEncode(rsaPublicKey, str);
//        rsaUtil.privateDecode(rsaPrivateKey, bytes1);
//        System.out.println("=============================");

//        MdUtil mdUtil = new MdUtil();
//        System.out.println("=============================");
//        mdUtil.jdkMd(str, "MD5");
//        mdUtil.jdkMd(str, "MD2");
//        System.out.println("=============================");
//        mdUtil.bcMd5(str);
//        mdUtil.bcMd4(str);
//        System.out.println("=============================");
//        mdUtil.ccMd5(str);
//        mdUtil.ccMd2(str);
//        System.out.println("=============================");

//        ShaUtil shaUtil = new ShaUtil();
//        System.out.println("=============================");
//        shaUtil.jdkSha(str);
//        System.out.println("=============================");
//        shaUtil.bcSha(str);
//        System.out.println("=============================");
//        shaUtil.bcSha224(str);
//        System.out.println("=============================");
//        shaUtil.ccSha(str);
//        System.out.println("=============================");

//        MacUtil macUtil = new MacUtil();
//        System.out.println("=============================");
//        macUtil.jdkMacMd5(str, password);
//        System.out.println("=============================");
//        macUtil.bcMacMd5(str, password);
//        System.out.println("=============================");

//        RsaSzqmUtil rsaSzqmUtil = new RsaSzqmUtil();
//        System.out.println("=============================");
//        KeyPair keyPair = rsaSzqmUtil.initRsaKey();
//        RSAPrivateKey rsaPrivateKey = rsaSzqmUtil.initRsaPrivateKey(keyPair);
//        RSAPublicKey rsaPublicKey = rsaSzqmUtil.initRsaPublicKey(keyPair);
//        System.out.println("=============================");
//        byte[] bytes = rsaSzqmUtil.jdkEncode(rsaPrivateKey, str);
//        rsaSzqmUtil.jdkDecode(rsaPublicKey, str, bytes);
//        System.out.println("=============================");

//        DsaUtil dsaUtil = new DsaUtil();
//        System.out.println("=============================");
//        KeyPair keyPair = dsaUtil.initDsaKey();
//        DSAPrivateKey dsaPrivateKey = dsaUtil.initDsaPrivateKey(keyPair);
//        DSAPublicKey dsaPublicKey = dsaUtil.initDsaPublicKey(keyPair);
//        System.out.println("=============================");
//        byte[] bytes = dsaUtil.jdkEncode(dsaPrivateKey, str);
//        dsaUtil.jdkDecode(dsaPublicKey, str, bytes);
//        System.out.println("=============================");

//        EcDsaUtil ecDsaUtil = new EcDsaUtil();
//        System.out.println("=============================");
//        KeyPair keyPair = ecDsaUtil.initEcDsaKey();
//        ECPrivateKey ecPrivateKey = ecDsaUtil.initEcDsaPrivateKey(keyPair);
//        ECPublicKey ecPublicKey = ecDsaUtil.initEcDsaPublicKey(keyPair);
//        System.out.println("=============================");
//        byte[] bytes = ecDsaUtil.jdkEncode(ecPrivateKey, str);
//        ecDsaUtil.jdkDecode(ecPublicKey, str, bytes);
//        System.out.println("=============================");

    }

}