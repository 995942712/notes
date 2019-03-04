package com.ming.notes.util;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.MessageDigest;
import java.security.Security;

/**
 * MD 消息摘要算法
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
public class MdUtil {

    /**
     * JDK_MD 加密
     * @param str
     * @param type (MD5或MD2)
     * @return
     */
    public String jdkMd(String str, String type) {
        try {
            MessageDigest md = MessageDigest.getInstance(type);
            byte[] bytes = md.digest(str.getBytes());
            String mdstr = Hex.encodeHexString(bytes);
            System.out.println("JDK_"+ type +":" + mdstr);
            return mdstr;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * BC_MD4 加密
     * @param str
     * @return
     */
    public String bcMd4(String str) {
        try {
            Security.addProvider(new BouncyCastleProvider());
            String md4 = jdkMd(str, "MD4");
            System.out.println("BC_MD4:" + md4);
            return md4;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * BC_MD5 加密
     * @param str
     * @return
     */
    public String bcMd5(String str) {
        try {
            Digest digest = new MD5Digest();
            digest.update(str.getBytes(), 0, str.getBytes().length);
            byte[] bytes = new byte[digest.getDigestSize()];
            digest.doFinal(bytes, 0);
            String md5 = org.bouncycastle.util.encoders.Hex.toHexString(bytes);
            System.out.println("BC_MD5:" + md5);
            return md5;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * CC_MD5 加密
     * @param str
     * @return
     */
    public String ccMd5(String str) {
        String md5 = DigestUtils.md5Hex(str.getBytes());
        System.out.println("CC_MD5:" + md5);
        return md5;
    }

    /**
     * CC_MD2 加密
     * @param str
     * @return
     */
    public String ccMd2(String str) {
        String md2 = DigestUtils.md2Hex(str.getBytes());
        System.out.println("CC_MD2:" + md2);
        return md2;
    }

}