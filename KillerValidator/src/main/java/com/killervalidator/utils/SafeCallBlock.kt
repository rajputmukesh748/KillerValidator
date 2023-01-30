package com.killervalidator.utils

/**
 * Safe Call Block
 * */
fun safeCallBlock(block: () -> Unit) = try {
    block.invoke()
} catch (e: Exception) {
    e.printStackTrace()
}