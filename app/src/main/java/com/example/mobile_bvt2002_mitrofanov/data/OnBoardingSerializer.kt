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

object OnBoardingSerializer : Serializer<ShowOnBoarding> {
    override val defaultValue: ShowOnBoarding
        get() = ShowOnBoarding.getDefaultInstance().toBuilder().setShowOnboarding(true).build()

    override suspend fun readFrom(input: InputStream): ShowOnBoarding {
        try {
            return ShowOnBoarding.parseFrom(input)
        } catch (e: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read onboarding proto", e)

        }
    }

    override suspend fun writeTo(t: ShowOnBoarding, output: OutputStream) = t.writeTo(output)


}

val Context.onBoardingDataStore: DataStore<ShowOnBoarding> by dataStore(
    fileName = "onboarding_flag.pb",
    serializer = OnBoardingSerializer,
    corruptionHandler = ReplaceFileCorruptionHandler { ShowOnBoarding.getDefaultInstance() }
)

