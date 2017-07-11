LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

#opencv
include /home/android/projects/Eirot/study/OpenCV/OpenCV-android-sdk/sdk/native/jni/OpenCV.mk
OPENCV_CAMERA_MODULES:=on
OPENCV_INSTALL_MODULES:=on
OPENCV_LIB_TYPE:=SHARED

LOCAL_SRC_FILES := GrayProcess.cpp

LOCAL_LDLIBS += -llog
LOCAL_MODULE := grayprocess

include $(BUILD_SHARED_LIBRARY)