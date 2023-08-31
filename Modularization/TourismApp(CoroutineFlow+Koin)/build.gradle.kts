// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.0" apply false
    id("com.android.dynamic-feature") version "8.1.0" apply false
}
ext {
    extra["coreKtxVersion"] = "1.10.1"
    extra["appCompatVersion"] = "1.6.1"
    extra["materialVersion"] = "1.9.0"
    extra["constraintVersion"] = "2.1.4"
    extra["jUnitVersion"] = "4.13.2"
    extra["androidxJunitVersion"] = "1.1.5"
    extra["espressoVersion"] = "3.5.1"
    extra["legacySupportVersion"] = "1.0.0"
    extra["multidexVersion"] = "2.0.1"
    extra["cardviewVersion"] = "1.0.0"
    extra["recyclerviewVersion"] = "1.3.1"
    extra["glideVersion"] = "4.11.0"
    extra["koinVersion"] = "3.0.1"
    extra["materialVersion"] = "1.9.0"
    extra["roomVersion"] = "2.5.2"
    extra["retrofitVersion"] = "2.9.0"
    extra["loggingInterceptorVersion"] = "4.9.3"
    extra["kotlinCoroutinesVersion"] = "1.6.4"
    extra["lifecycleVersion"] = "2.6.1"
}