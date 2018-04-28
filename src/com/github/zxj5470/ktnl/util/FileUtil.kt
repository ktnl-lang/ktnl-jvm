package com.github.zxj5470.ktnl.util

/**
 * @author zxj5470
 * @date 2017/11/12
 */
import java.io.File

class FileUtil(fileName: String) {
    var file: File?= File(fileName)
    fun readText()=file!!.readText()
}