package com.ckt.eirot.opencv4jni;

/**
 * Created by eirot on 16-11-23 16:44.
 * Email: xuefan.chen@ck-telecom.com
 */

public class GrayProcess {
    /**
     * @param buf
     * @param w
     * @param h
     * @return
     */
    public static native int[] grayProcess(int[] buf, int w, int h);
}
