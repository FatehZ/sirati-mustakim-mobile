package com.ktxdevelopment.siratimustakim.domain.model.util

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


inline fun <reified T> T.stringify(): String {
    return Json.encodeToString(this)
}

inline fun <reified T> String.destringify(): T {
    return Json.decodeFromString(this)
}