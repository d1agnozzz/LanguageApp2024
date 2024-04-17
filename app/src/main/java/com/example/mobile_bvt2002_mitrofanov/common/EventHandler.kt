package com.example.mobile_bvt2002_mitrofanov.common

interface EventHandler<E> {
    fun obtainEvent(event: E)
}