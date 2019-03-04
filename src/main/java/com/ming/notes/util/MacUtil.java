package com.ming.notes.util;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * MAC 消息摘要算法
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
public class MacUtil {

    /**
     * JDK_MAC_MD5 加密
     * @param str
     * @return
     */
    public String jdkMacMd5(String str, String salt) {
        try {
            //初始化
            KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");
            //生成密钥
            SecretKey key = keyGenerator.generateKey();
            //获得密钥
//            byte[] bytes = key.getEncoded();
            byte[] bytes = Hex.decodeHex(salt.toCharArray());
            //还原密钥
            SecretKey secretKey = new SecretKeySpec(bytes, "HmacMD5");
            //实例化Mac
            Mac mac = Mac.getInstance(secretKey.getAlgorithm());
            //初始化Mac
            mac.init(secretKey);
            //执行摘要
            byte[] md5s = mac.doFinal(str.getBytes());
            String md5 = Hex.encodeHexString(md5s);
            System.out.println("JDK_MAC_MD5加密:" + md5);
            return md5;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * BC_MAC_MD5 加密
     * @param str
     * @param salt
     * @return
     */
    public String bcMacMd5(String str, String salt) {
        try {
            HMac mac = new HMac(new MD5Digest());
            byte[] bytes = org.bouncycastle.util.encoders.Hex.decode(salt);
            mac.init(new KeyParameter(bytes));
            mac.update(str.getBytes(), 0, str.getBytes().length);
            byte[] md5s = new byte[mac.getMacSize()];
            mac.doFinal(md5s, 0);
            String md5 = org.bouncycastle.util.encoders.Hex.toHexString(md5s);
            System.out.println("BC_MAC_MD5加密:" + md5);
            return md5;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}