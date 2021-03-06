/*
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.client.dataframe.transforms;

import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.test.ESTestCase;

import java.io.IOException;

import static org.elasticsearch.test.AbstractXContentTestCase.xContentTester;

public class DataFrameTransformProgressTests extends ESTestCase {

    public void testFromXContent() throws IOException {
        xContentTester(this::createParser,
            DataFrameTransformProgressTests::randomInstance,
            DataFrameTransformProgressTests::toXContent,
            DataFrameTransformProgress::fromXContent)
           .supportsUnknownFields(true)
           .test();
    }

    public static DataFrameTransformProgress randomInstance() {
        return new DataFrameTransformProgress(
            randomBoolean() ? null : randomNonNegativeLong(),
            randomBoolean() ? null : randomNonNegativeLong(),
            randomBoolean() ? null : randomDouble(),
            randomBoolean() ? null : randomNonNegativeLong(),
            randomBoolean() ? null : randomNonNegativeLong());
    }

    public static void toXContent(DataFrameTransformProgress progress, XContentBuilder builder) throws IOException {
        builder.startObject();
        if (progress.getTotalDocs() != null) {
            builder.field(DataFrameTransformProgress.TOTAL_DOCS.getPreferredName(), progress.getTotalDocs());
        }
        if (progress.getPercentComplete() != null) {
            builder.field(DataFrameTransformProgress.PERCENT_COMPLETE.getPreferredName(), progress.getPercentComplete());
        }
        if (progress.getRemainingDocs() != null) {
            builder.field(DataFrameTransformProgress.DOCS_REMAINING.getPreferredName(), progress.getRemainingDocs());
        }
        builder.field(DataFrameTransformProgress.DOCS_INDEXED.getPreferredName(), progress.getDocumentsIndexed());
        builder.field(DataFrameTransformProgress.DOCS_PROCESSED.getPreferredName(), progress.getDocumentsProcessed());
        builder.endObject();
    }
}
