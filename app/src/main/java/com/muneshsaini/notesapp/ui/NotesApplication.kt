package com.muneshsaini.notesapp.ui

import android.app.Application

class NotesApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        SharedPref.init(this)
    }
}