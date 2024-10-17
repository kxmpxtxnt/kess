/*
 * Copyright 2024 Paul Kindler and contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package fyi.pauli.kess.utils.serializer

import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*
import kotlin.uuid.*

@OptIn(ExperimentalUuidApi::class)
object UuidSerializer : KSerializer<Uuid> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("uuid") {
        element<Long>("msb")
        element<Long>("lsb")
    }

    override fun deserialize(decoder: Decoder): Uuid {
        return Uuid.fromLongs(decoder.decodeLong(), decoder.decodeLong())
    }

    override fun serialize(encoder: Encoder, value: Uuid) {
        value.toLongs { mostSignificantBits, leastSignificantBits ->
            encoder.encodeLong(mostSignificantBits)
            encoder.encodeLong(leastSignificantBits)
        }
    }
}
