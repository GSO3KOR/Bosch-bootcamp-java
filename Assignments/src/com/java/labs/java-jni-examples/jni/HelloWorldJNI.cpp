#include <jni.h>
#include <iostream>
#include "HelloWorldJNI.h"

JNIEXPORT void JNICALL Java_HelloWorldJNI_sayHello(JNIEnv *env, jobject obj) {
    std::cout << "Hello, World from C++!" << std::endl;
}
