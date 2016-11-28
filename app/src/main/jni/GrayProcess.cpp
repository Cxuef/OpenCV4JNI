#include <jni.h>
#include <opencv2/opencv.hpp>
#include "com_ckt_eirot_opencv4jni_GrayProcess.h"

extern "C" {
using namespace cv;
using namespace std;


JNIEXPORT jintArray JNICALL Java_com_ckt_eirot_opencv4jni_GrayProcess_grayProcess(JNIEnv *env,
                                                                                  jclass obj,
                                                                                  jintArray buf,
                                                                                  jint w, jint h) {
    jboolean ptfalse = false;
    jint *srcBuf = env->GetIntArrayElements(buf, &ptfalse);
    if (srcBuf == NULL) {
        return 0;
    }
    int size = w * h;

    Mat srcImage(h, w, CV_8UC4, (unsigned char *) srcBuf);
    Mat grayImage;
    cvtColor(srcImage, grayImage, COLOR_BGRA2GRAY);
    cvtColor(grayImage, srcImage, COLOR_GRAY2BGRA);

    jintArray result = env->NewIntArray(size);
    env->SetIntArrayRegion(result, 0, size, srcBuf);
    env->ReleaseIntArrayElements(buf, srcBuf, 0);
    return result;
}

}