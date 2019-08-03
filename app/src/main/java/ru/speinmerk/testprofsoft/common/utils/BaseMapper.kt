package ru.speinmerk.testprofsoft.common.utils

interface BaseMapper<in A, out B> {
    fun mapFrom(type: A): B
}