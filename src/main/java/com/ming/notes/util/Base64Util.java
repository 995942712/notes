package com.ming.notes.util;

import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * Base64加解密算法
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
public class Base64Util {

    /**
     * JDK_BASE64加密
     * @param str
     * @return
     */
    public String jdkBase64Encode(String str) {
        BASE64Encoder encoder = new BASE64Encoder();
        String encode = encoder.encode(str.getBytes());
        System.out.println("JDK_BASE64加密:" + encode);
        return encode;
    }

    /**
     * JDK_BASE64解密
     * @param str
     * @return
     */
    public String jdkBase64Decoder(String str) {
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            String decode = new String(decoder.decodeBuffer(str));
            System.out.println("JDK_BASE64解密:" + decode);
            return decode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * COMMONS_BASE64加密
     * @param str
     * @return
     */
    public String commonsBase64Encode(String str) {
        byte[] encodes = Base64.encodeBase64(str.getBytes());
        String encode = new String(encodes);
        System.out.println("COMMONS_BASE64加密:" + encode);
        return encode;
    }

    /**
     * COMMONS_BASE64解密
     * @param bytes
     * @return
     */
    public String commonsBase64Decoder(byte[] bytes) {
        try {
            byte[] decodes = Base64.decodeBase64(bytes);
            String decode = new String(decodes);
            System.out.println("COMMONS_BASE64解密:" + decode);
            return decode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * BOUNCYCASTLE_BASE64加密
     * @param str
     * @return
     */
    public String bouncyCastleBase64Encode(String str) {
        byte[] encodes = org.bouncycastle.util.encoders.Base64.encode(str.getBytes());
        String encode = new String(encodes);
        System.out.println("BOUNCYCASTLE_BASE64加密:" + encode);
        return encode;
    }

    /**
     * BOUNCYCASTLE_BASE64解密
     * @param bytes
     * @return
     */
    public String bouncyCastleBase64Decoder(byte[] bytes) {
        try {
            byte[] decodes = org.bouncycastle.util.encoders.Base64.decode(bytes);
            String decode = new String(decodes);
            System.out.println("BOUNCYCASTLE_BASE64解密:" + decode);
            return decode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}