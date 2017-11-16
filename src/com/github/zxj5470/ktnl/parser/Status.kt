package com.github.zxj5470.ktnl.parser

/**
 * (val status: Int = 0xbabe)
 * @date: 2017/11/17
 */
enum class Status {
    DEFINING,
    QUOTING,
    SETTING,
    LAMBDA_ING,
    FUNCTION_ING,
    IF_ING,
    LOOPING
}