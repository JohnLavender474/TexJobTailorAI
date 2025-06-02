package com.texjobtailorai.utils

interface Provider<T, V> {

    fun get(key: T): V
}