package com.example.kotlin.examen.data.network

import android.content.Context
import com.example.kotlin.examen.utils.Constants
import com.parse.Parse
import com.parse.ParseCloud
import com.parse.ParseException

object NetworkModuleDI {
    fun initializeParse(context: Context) {
        Parse.initialize(
            Parse.Configuration
                .Builder(context)
                .applicationId(Constants.APPLICATION_ID)
                .clientKey(Constants.CLIENT_KEY)
                .server(Constants.BASE_URL)
                .build(),
        )
    }

    fun <T> callCloudFunction(
        nombreFuncion: String,
        parametros: HashMap<String, Any>,
        callback: (T?, Exception?) -> Unit,
    ) {
        ParseCloud.callFunctionInBackground(nombreFuncion, parametros) { resultado: T?, e: ParseException? ->
            if (e == null) {
                callback(resultado, null)
            } else {
                callback(null, e)
            }
        }
    }
}
