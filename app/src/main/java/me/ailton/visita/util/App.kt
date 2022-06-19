package me.ailton.visita.util

import android.app.Application
import me.ailton.visita.data.AppDatabase
import me.ailton.visita.data.BusinessCardRepository

class App :Application(){

    val database by lazy { AppDatabase.getDatabase( this) }
    val repository by lazy { BusinessCardRepository(database.businessDao()) }
}