package com.github.zxj5470.ktnl.model

/*
 * @date 2017/11/17
 */
data class KtnlString(val name: String,
                      var value: String) : KtnlObject(name, value, "String")