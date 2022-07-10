#include <jni.h>
#include <string>
#include <cstring>

JNIEnv *GetStringUTFChars(const char *str, int i);

extern "C" JNIEXPORT jint JNICALL
Java_com_examen_ndkjniapp_MainActivity_getTxtLen(JNIEnv *env, jobject instance, jstring txt_) {
    const char *txt = env->GetStringUTFChars(txt_, 0);
    int len = strlen(txt);
    return len;
}



