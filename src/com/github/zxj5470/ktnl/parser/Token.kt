package com.github.zxj5470.ktnl.parser

/**
 * Token and Status
 *
 * 0xcafe
 * 0xbabe
 * to salute Java
 *
 * @author: zxj5470
 * @date: 2017/11/7
 */

enum class Token(val token: Int= 0xcafe) {
    DEFINE,
    NUMBER,
    LAMBDA,
    FUNCTION,
    IF,
    LOOP
}

enum class Status(val status: Int = 0xbabe) {
    DEFINING,
    QUOTING,
    SETTING,
    LAMBDA_ING,
    FUNCTION_ING,
    IF_ING,
    LOOPING
}