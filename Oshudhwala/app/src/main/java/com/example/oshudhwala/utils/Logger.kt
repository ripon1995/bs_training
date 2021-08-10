package com.example.oshudhwala.utils

open class Logger {

    companion object {

        fun d(anyObject: Any?) {
                com.orhanobut.logger.Logger.d(anyObject)
        }

        fun e(message: String) {
                com.orhanobut.logger.Logger.e(message)
        }
    }
}