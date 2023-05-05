package com.example.smarthome.utils

import android.content.Context

class SharePrefManager private constructor(private val mCtx: Context) {

    val isLoggedIn: Boolean
        get() {
            val sharedPreferences =
                mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
            return sharedPreferences.getBoolean("success", false)
        }
    val nameUser: String?
        get() {
            val sharedPreferences =
                mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
            return sharedPreferences.getString("name", null)
        }

    fun saveUser(name: String?,logged:Boolean) {

        val sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putBoolean("success",logged)
        editor.putString("name", name)
        editor.apply()

    }
    companion object {
        private val SHARED_PREF_NAME = "app_shared_pref"
        private var mInstance: SharePrefManager? = null


        fun getInstance(mCtx: Context): SharePrefManager {
            if (mInstance == null) {
                mInstance = SharePrefManager(mCtx)
            }
            return mInstance as SharePrefManager
        }

    }
}