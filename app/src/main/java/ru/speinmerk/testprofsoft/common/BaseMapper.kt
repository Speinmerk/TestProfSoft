package ru.speinmerk.testprofsoft.common

interface BaseMapper<in A, out B> {
    fun mapFrom(type: A): B
}