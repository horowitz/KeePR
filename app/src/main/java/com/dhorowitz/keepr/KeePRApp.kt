package com.dhorowitz.keepr

import android.app.Application
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinAware
import com.github.salomonbrys.kodein.lazy

class KeePRApp : Application(), KodeinAware {

    override val kodein by Kodein.lazy {
        /* ... */
    }

}