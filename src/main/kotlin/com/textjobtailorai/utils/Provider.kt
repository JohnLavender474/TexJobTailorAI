package com.textjobtailorai.utils

interface Provider<T, V> {

    fun get(key: T): V
}