package com.github.zxj5470.ktnl

/**
 * @author zxj5470
 * @date 17-11-7
 */

import com.github.zxj5470.ktnl.core.parse
import com.github.zxj5470.ktnl.util.FileUtil
import com.github.zxj5470.ktnl.util.handleArgs

fun main(args: Array<String>) {
	val args1 = handleArgs(args)
	val fileName = args1[0]

	val fileUtil = FileUtil(fileName)
	if (fileUtil.file != null) {
		val ktnlFileContent = fileUtil.readText()
		parse(ktnlFileContent)
	}
}