/*
 * Copyright 2014-2015 Amazon Technologies, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at:
 *
 *    http://aws.amazon.com/apache2.0
 *
 * This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES
 * OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and
 * limitations under the License.
 */

package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;

import java.nio.ByteBuffer;

/**
 * An unmarshaller that unmarshals Binary values as Java {@code byte[]}s.
 */
public class ByteArrayUnmarshaller extends BUnmarshaller {

    private static final ByteArrayUnmarshaller INSTANCE =
            new ByteArrayUnmarshaller();

    public static ByteArrayUnmarshaller instance() {
        return INSTANCE;
    }

    private ByteArrayUnmarshaller() {
    }

    @Override
    public Object unmarshall(AttributeValue value) {
        ByteBuffer buffer = value.getB();

        if (buffer.hasArray()) {
            return buffer.array();
        }

        byte[] array = new byte[buffer.remaining()];
        buffer.get(array);
        return array;
    }
}
