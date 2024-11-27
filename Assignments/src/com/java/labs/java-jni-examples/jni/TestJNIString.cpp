#include <jni.h>
#include <iostream>
#include "TestJNIString.h" // Include the generated header file

JNIEXPORT jstring JNICALL Java_TestJNIString_sayHello(JNIEnv *env, jobject obj, jstring inJNIStr) {
    // Convert jstring to C-style string
    const char *inCStr = env->GetStringUTFChars(inJNIStr, NULL);

    // Do some processing, for example, print the string
    std::cout << "Received from Java: " << inCStr << std::endl;

    // Append a string to the input (example processing)
    const char *outCStr = " - Processed in C++";

    // Convert the result back to jstring
    jstring outJNIStr = env->NewStringUTF(outCStr);

    // Release resources
    env->ReleaseStringUTFChars(inJNIStr, inCStr);

    // Return the processed string
    return outJNIStr;
}
