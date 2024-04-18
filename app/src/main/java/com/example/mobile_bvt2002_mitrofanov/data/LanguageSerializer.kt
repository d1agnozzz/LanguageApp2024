package com.example.mobile_bvt2002_mitrofanov.data

import android.content.Context
import androidx.datastore.core.CorruptionException
import androidx.datastore.core.DataStore
import androidx.datastore.core.Serializer
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.dataStore
import com.google.protobuf.InvalidProtocolBufferException
import java.io.InputStream
import java.io.OutputStream

object LanguageSelectedSerializer : Serializer<LanguageSelected> {
    override val defaultValue: LanguageSelected
        get() = LanguageSelected.getDefaultInstance();

    override suspend fun readFrom(input: InputStream): LanguageSelected {
        try {

            return LanguageSelected.parseFrom(input)
        } catch (e: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read onboarding proto", e)

        }
    }

    override suspend fun writeTo(t: LanguageSelected, output: OutputStream) = t.writeTo(output)


}

val Context.languageSelectedDataStore: DataStore<LanguageSelected> by dataStore(
    fileName = "language_selected.pb",
    serializer = LanguageSelectedSerializer,
    corruptionHandler = ReplaceFileCorruptionHandler { LanguageSelected.getDefaultInstance() }
)
