package com.tsdproject.pokerplanning.database

import io.paperdb.Paper

object LocalDatabase {

    fun putUserToken(token: String) {
        Paper.book().write(DatabaseKeys.TOKEN, token)
    }

    fun getUserToken(): String? {
        return Paper.book().read(DatabaseKeys.TOKEN)
    }
}