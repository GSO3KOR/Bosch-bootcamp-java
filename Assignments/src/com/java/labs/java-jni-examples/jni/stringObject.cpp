#include <jni.h>
#include <iostream>
#include "stringObject.h"

JNIEXPORT void JNICALL Java_stringObject_sayHello(JNIEnv *env, jobject obj, jobject messageObject) {
    // Get the class of the passed messageObject
    jclass cls = env->GetObjectClass(messageObject);

    // Get the method ID of the 'getMessage' method from the stringObject class
    jmethodID getMessageMethod = env->GetMethodID(cls, "getMessage", "()Ljava/lang/String;");

    // Call the 'getMessage' method on the messageObject to get the string
    jstring message = (jstring) env->CallObjectMethod(messageObject, getMessageMethod);

    // Convert the jstring to a C-style string
    const char* nativeMessage = env->GetStringUTFChars(message, nullptr);

    // ANSI escape code for bold text
    const char* boldStart = "\033[1m"; // Start bold
    const char* boldEnd = "\033[0m";   // Reset formatting

    // Print the message in bold
    std::cout << boldStart << nativeMessage << boldEnd << std::endl;

    // Release memory allocated for the string
    env->ReleaseStringUTFChars(message, nativeMessage);
}
