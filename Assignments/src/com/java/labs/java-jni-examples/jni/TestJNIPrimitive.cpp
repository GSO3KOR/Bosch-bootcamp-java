#include <jni.h>
#include "TestJNIPrimitive.h" // Include the generated header file

JNIEXPORT jdouble JNICALL Java_TestJNIPrimitive_average(JNIEnv *env, jobject obj, jint n1, jint n2) {
    return (n1 + n2) / 2.0;
}
