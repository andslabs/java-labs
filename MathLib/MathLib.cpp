#include <jni.h>
#include <math.h>
#include "MathLib.h"

JNIEXPORT jdouble JNICALL Java_lab11_Lab11_Cbqrt(JNIEnv *env, jobject obj, jdouble n){
    return cbrt(n);
};

JNIEXPORT jdouble JNICALL Java_lab11_Lab11_Sin(JNIEnv *env, jobject obj, jdouble n){
    return sin(n);
};

JNIEXPORT jdouble JNICALL Java_lab11_Lab11_ln(JNIEnv *env, jobject obj, jdouble n){
    return log(n);
};

JNIEXPORT jint JNICALL Java_lab11_Lab11_matrSumm8(JNIEnv *env, jobject obj, jobjectArray arr8){
    jclass classInteger = (*env).FindClass("java/lang/Integer");
    jmethodID midIntValue = (*env).GetMethodID(classInteger, "intValue", "()I");
    jint sum = 0;
    for (int i = 0; i < 8; i++) {
       jintArray inJNIArray = (jintArray) env->GetObjectArrayElement(arr8, i);
       jint *element = (*env).GetIntArrayElements(inJNIArray, 0);
       for(int j = i; j < 8; j++){
           sum += element[j];
       }
    }
    return sum;
};

JNIEXPORT jint JNICALL Java_lab11_Lab11_matrSumm10(JNIEnv *env, jobject obj, jobjectArray arr10){
    jclass classInteger = (*env).FindClass("java/lang/Integer");
    jmethodID midIntValue = (*env).GetMethodID(classInteger, "intValue", "()I");
    jint sum = 0;
    for (int i = 0; i < 10; i++) {
       jintArray inJNIArray = (jintArray) env->GetObjectArrayElement(arr10, i);
       jint *element = (*env).GetIntArrayElements(inJNIArray, 0);
       for(int j = i; j < 10; j++){
           sum += element[j];
       }
    }
    return sum;
};