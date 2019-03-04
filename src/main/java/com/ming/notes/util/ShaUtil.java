package com.ming.notes.util;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.digests.SHA224Digest;

import java.security.MessageDigest;

/**
 * SHA 消息摘要算法
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
public class ShaUtil {

    /**
     * JDK_SHA 加密
     * @param str
     * @return
     */
    public String jdkSha(String str){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA");
            md.update(str.getBytes());
            String sha = Hex.encodeHexString(md.digest());
            System.out.println("JDK_SHA加密:" + sha);
            return sha;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * BC_SHA 加密
     * @param str
     * @return
     */
    public String bcSha(String str){
        try {
            Digest digest = new SHA1Digest();
            digest.update(str.getBytes(), 0, str.getBytes().length);
            byte[] bytes = new byte[digest.getDigestSize()];
            digest.doFinal(bytes, 0);
            String sha = org.bouncycastle.util.encoders.Hex.toHexString(bytes);
            System.out.println("BC_SHA加密:" + sha);
            return sha;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * BC_SHA224 加密
     * @param str
     * @return
     */
    public String bcSha224(String str){
        try {
            Digest digest = new SHA224Digest();
            digest.update(str.getBytes(), 0, str.getBytes().length);
            byte[] bytes = new byte[digest.getDigestSize()];
            digest.doFinal(bytes, 0);
            String sha = org.bouncycastle.util.encoders.Hex.toHexString(bytes);
            System.out.println("BC_SHA224加密:" + sha);
            return sha;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * CC_SHA 加密
     * @param str
     * @return
     */
    public String ccSha(String str){
        String sha = DigestUtils.sha1Hex(str.getBytes());
        String sha2 = DigestUtils.sha1Hex(str);
        System.out.println("CC_SHA加密:" + sha);
        System.out.println("CC_SHA加密:" + sha2);
        return sha;
    }

}