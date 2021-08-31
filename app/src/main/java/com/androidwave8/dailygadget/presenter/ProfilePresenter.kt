package com.androidwave8.dailygadget.presenter

import com.androidwave8.dailygadget.App
import com.androidwave8.dailygadget.view.ProfileActivityView
import com.androidwave8.dailygadget.utils.SharePref

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ProfilePresenter(private val v: ProfileActivityView){
    fun getUser(email:String, password : String){
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val user = App.dbUser
                    ?.usersDao()
                    ?.getUser(email, password)

                launch(Dispatchers.Main) {
                    SharePref.isLogin = true
                    v.getProfileSuccess()
                }
            } catch (e: Exception) {
                launch(Dispatchers.Main) {
                    v.getProfileFailed(e.message.toString())
                }
            }
        }

    }

}