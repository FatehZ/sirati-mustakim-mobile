package com.ktxdevelopment.siratimustakim.android.util

enum class NetType{
    LOCAL, REMOTE;
}

fun checkNetType(str: String): NetType {
    return if (str == NetType.LOCAL.name) {
        NetType.LOCAL
    }else {
        NetType.REMOTE
    }
}