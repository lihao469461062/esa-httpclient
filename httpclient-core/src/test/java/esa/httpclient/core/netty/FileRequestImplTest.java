/*
 * Copyright 2020 OPPO ESA Stack Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package esa.httpclient.core.netty;

import esa.httpclient.core.FileRequest;
import esa.httpclient.core.RequestOptions;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FileRequestImplTest {

    @Test
    void testConstructor() {
        assertThrows(NullPointerException.class, () -> new FileRequestImpl(null));

        new FileRequestImpl(mock(RequestOptions.class));
    }

    @Test
    void testGetFile() {
        final File file = new File("/abc");
        RequestOptions options = mock(RequestOptions.class);
        when(options.file()).thenReturn(file);

        FileRequest request = new FileRequestImpl(options);
        then(request.file()).isSameAs(file);
    }
}
