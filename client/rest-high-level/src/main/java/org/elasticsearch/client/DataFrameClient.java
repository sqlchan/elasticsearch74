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

package org.elasticsearch.client;

import org.elasticsearch.action.ActionListener;
import org.elasticsearch.client.core.AcknowledgedResponse;
import org.elasticsearch.client.dataframe.DeleteDataFrameTransformRequest;
import org.elasticsearch.client.dataframe.GetDataFrameTransformRequest;
import org.elasticsearch.client.dataframe.GetDataFrameTransformResponse;
import org.elasticsearch.client.dataframe.GetDataFrameTransformStatsRequest;
import org.elasticsearch.client.dataframe.GetDataFrameTransformStatsResponse;
import org.elasticsearch.client.dataframe.PreviewDataFrameTransformRequest;
import org.elasticsearch.client.dataframe.PreviewDataFrameTransformResponse;
import org.elasticsearch.client.dataframe.PutDataFrameTransformRequest;
import org.elasticsearch.client.dataframe.StartDataFrameTransformRequest;
import org.elasticsearch.client.dataframe.StartDataFrameTransformResponse;
import org.elasticsearch.client.dataframe.StopDataFrameTransformRequest;
import org.elasticsearch.client.dataframe.StopDataFrameTransformResponse;
import org.elasticsearch.client.dataframe.UpdateDataFrameTransformRequest;
import org.elasticsearch.client.dataframe.UpdateDataFrameTransformResponse;

import java.io.IOException;
import java.util.Collections;

public final class DataFrameClient {

    private final RestHighLevelClient restHighLevelClient;

    DataFrameClient(RestHighLevelClient restHighLevelClient) {
        this.restHighLevelClient = restHighLevelClient;
    }

    /**
     * Creates a new transform
     * <p>
     * For additional info
     * see <a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/put-transform.html">
     *     Create transform documentation</a>
     *
     * @param request The PutDataFrameTransformRequest containing the
     * {@link org.elasticsearch.client.dataframe.transforms.DataFrameTransformConfig}.
     * @param options Additional request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @return An AcknowledgedResponse object indicating request success
     * @throws IOException when there is a serialization issue sending the request or receiving the response
     */
    public AcknowledgedResponse putDataFrameTransform(PutDataFrameTransformRequest request, RequestOptions options) throws IOException {
        return restHighLevelClient.performRequestAndParseEntity(request,
                DataFrameRequestConverters::putDataFrameTransform,
                options,
                AcknowledgedResponse::fromXContent,
                Collections.emptySet());
    }

    /**
     * Creates a new transform asynchronously and notifies listener on completion
     * <p>
     * For additional info
     * see <a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/put-transform.html">
     *     Create transform documentation</a>
     *
     * @param request The PutDataFrameTransformRequest containing the
     * {@link org.elasticsearch.client.dataframe.transforms.DataFrameTransformConfig}.
     * @param options Additional request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param listener Listener to be notified upon request completion
     */
    public void putDataFrameTransformAsync(PutDataFrameTransformRequest request, RequestOptions options,
                                      ActionListener<AcknowledgedResponse> listener) {
        restHighLevelClient.performRequestAsyncAndParseEntity(request,
                DataFrameRequestConverters::putDataFrameTransform,
                options,
                AcknowledgedResponse::fromXContent,
                listener,
                Collections.emptySet());
    }

    /**
     * Updates an existing transform
     * <p>
     * For additional info
     * see <a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/update-transform.html">
     *     Create transform documentation</a>
     *
     * @param request The UpdateDataFrameTransformRequest containing the
     * {@link org.elasticsearch.client.dataframe.transforms.DataFrameTransformConfigUpdate}.
     * @param options Additional request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @return An UpdateDataFrameTransformResponse object containing the updated configuration
     * @throws IOException when there is a serialization issue sending the request or receiving the response
     */
    public UpdateDataFrameTransformResponse updateDataFrameTransform(UpdateDataFrameTransformRequest request,
                                                                     RequestOptions options) throws IOException {
        return restHighLevelClient.performRequestAndParseEntity(request,
            DataFrameRequestConverters::updateDataFrameTransform,
            options,
            UpdateDataFrameTransformResponse::fromXContent,
            Collections.emptySet());
    }

    /**
     * Updates an existing transform asynchronously and notifies listener on completion
     * <p>
     * For additional info
     * see <a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/update-transform.html">
     *     Create transform documentation</a>
     *
     * @param request The UpdateDataFrameTransformRequest containing the
     * {@link org.elasticsearch.client.dataframe.transforms.DataFrameTransformConfigUpdate}.
     * @param options Additional request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param listener Listener to be notified upon request completion
     */
    public void updateDataFrameTransformAsync(UpdateDataFrameTransformRequest request,
                                              RequestOptions options,
                                              ActionListener<UpdateDataFrameTransformResponse> listener) {
        restHighLevelClient.performRequestAsyncAndParseEntity(request,
            DataFrameRequestConverters::updateDataFrameTransform,
            options,
            UpdateDataFrameTransformResponse::fromXContent,
            listener,
            Collections.emptySet());
    }

    /**
     * Get the running statistics of a transform
     * <p>
     * For additional info
     * see <a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/get-transform-stats.html">
     *     Get transform stats documentation</a>
     *
     * @param request Specifies the which transforms to get the stats for
     * @param options Additional request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @return The transform stats
     * @throws IOException when there is a serialization issue sending the request or receiving the response
     */
    public GetDataFrameTransformStatsResponse getDataFrameTransformStats(GetDataFrameTransformStatsRequest request, RequestOptions options)
            throws IOException {
        return restHighLevelClient.performRequestAndParseEntity(request,
                DataFrameRequestConverters::getDataFrameTransformStats,
                options,
                GetDataFrameTransformStatsResponse::fromXContent,
                Collections.emptySet());
    }

    /**
     * Get the running statistics of a transform asynchronously and notifies listener on completion
     * <p>
     * For additional info
     * see <a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/get-transform-stats.html">
     *     Get transform stats documentation</a>
     *
     * @param request Specifies the which transforms to get the stats for
     * @param options Additional request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param listener Listener to be notified upon request completion
     */
    public void getDataFrameTransformStatsAsync(GetDataFrameTransformStatsRequest request, RequestOptions options,
                                           ActionListener<GetDataFrameTransformStatsResponse> listener) {
        restHighLevelClient.performRequestAsyncAndParseEntity(request,
                DataFrameRequestConverters::getDataFrameTransformStats,
                options,
                GetDataFrameTransformStatsResponse::fromXContent,
                listener,
                Collections.emptySet());
    }

    /**
     * Delete a transform
     * <p>
     * For additional info
     * see <a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/delete-transform.html">
     *     Delete transform documentation</a>
     *
     * @param request The delete transform request
     * @param options Additional request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @return An AcknowledgedResponse object indicating request success
     * @throws IOException when there is a serialization issue sending the request or receiving the response
     */
    public AcknowledgedResponse deleteDataFrameTransform(DeleteDataFrameTransformRequest request, RequestOptions options)
            throws IOException {
        return restHighLevelClient.performRequestAndParseEntity(request,
                DataFrameRequestConverters::deleteDataFrameTransform,
                options,
                AcknowledgedResponse::fromXContent,
                Collections.emptySet());
    }

    /**
     * Delete a transform asynchronously and notifies listener on completion
     * <p>
     * For additional info
     * see <a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/delete-transform.html">
     *     Delete transform documentation</a>
     *
     * @param request The delete transform request
     * @param options Additional request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param listener Listener to be notified upon request completion
     */
    public void deleteDataFrameTransformAsync(DeleteDataFrameTransformRequest request, RequestOptions options,
                                              ActionListener<AcknowledgedResponse> listener) {
        restHighLevelClient.performRequestAsyncAndParseEntity(request,
                DataFrameRequestConverters::deleteDataFrameTransform,
                options,
                AcknowledgedResponse::fromXContent,
                listener,
                Collections.emptySet());
    }

    /**
     * Preview the result of a transform
     * <p>
     * For additional info
     * see <a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/preview-transform.html">
     *     Preview transform documentation</a>
     *
     * @param request The preview transform request
     * @param options Additional request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @return A response containing the results of the applied transform
     * @throws IOException when there is a serialization issue sending the request or receiving the response
     */
    public PreviewDataFrameTransformResponse previewDataFrameTransform(PreviewDataFrameTransformRequest request, RequestOptions options)
            throws IOException {
        return restHighLevelClient.performRequestAndParseEntity(request,
                DataFrameRequestConverters::previewDataFrameTransform,
                options,
                PreviewDataFrameTransformResponse::fromXContent,
                Collections.emptySet());
    }

    /**
     * Preview the result of a transform asynchronously and notifies listener on completion
     * <p>
     * see <a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/preview-transform.html">
     *     Preview transform documentation</a>
     *
     * @param request The preview transform request
     * @param options Additional request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param listener Listener to be notified upon request completion
     */
    public void previewDataFrameTransformAsync(PreviewDataFrameTransformRequest request, RequestOptions options,
                                             ActionListener<PreviewDataFrameTransformResponse> listener) {
        restHighLevelClient.performRequestAsyncAndParseEntity(request,
                DataFrameRequestConverters::previewDataFrameTransform,
                options,
                PreviewDataFrameTransformResponse::fromXContent,
                listener,
                Collections.emptySet());
    }

    /**
     * Start a transform
     * <p>
     * For additional info
     * see <a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/start-transform.html">
     *     Start transform documentation</a>
     *
     * @param request The start transform request
     * @param options Additional request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @return A response object indicating request success
     * @throws IOException when there is a serialization issue sending the request or receiving the response
     */
    public StartDataFrameTransformResponse startDataFrameTransform(StartDataFrameTransformRequest request, RequestOptions options)
            throws IOException {
        return restHighLevelClient.performRequestAndParseEntity(request,
                DataFrameRequestConverters::startDataFrameTransform,
                options,
                StartDataFrameTransformResponse::fromXContent,
                Collections.emptySet());
    }

    /**
     * Start a transform asynchronously and notifies listener on completion
     * <p>
     * For additional info
     * see <a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/start-transform.html">
     *     Start transform documentation</a>
     *
     * @param request The start transform request
     * @param options Additional request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param listener Listener to be notified upon request completion
     */
    public void startDataFrameTransformAsync(StartDataFrameTransformRequest request, RequestOptions options,
                                            ActionListener<StartDataFrameTransformResponse> listener) {
        restHighLevelClient.performRequestAsyncAndParseEntity(request,
                DataFrameRequestConverters::startDataFrameTransform,
                options,
                StartDataFrameTransformResponse::fromXContent,
                listener,
                Collections.emptySet());
    }

    /**
     * Stop a transform
     * <p>
     * For additional info
     * see <a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/stop-transform.html">
     *     Stop transform documentation</a>
     *
     * @param request The stop transform request
     * @param options Additional request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @return A response object indicating request success
     * @throws IOException when there is a serialization issue sending the request or receiving the response
     */
    public StopDataFrameTransformResponse stopDataFrameTransform(StopDataFrameTransformRequest request, RequestOptions options)
            throws IOException {
        return restHighLevelClient.performRequestAndParseEntity(request,
                DataFrameRequestConverters::stopDataFrameTransform,
                options,
                StopDataFrameTransformResponse::fromXContent,
                Collections.emptySet());
    }

    /**
     * Stop a transform asynchronously and notifies listener on completion
     * <p>
     * For additional info
     * see <a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/stop-transform.html">
     *     Stop transform documentation</a>
     *
     * @param request The stop transform request
     * @param options Additional request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param listener Listener to be notified upon request completion
     */
    public void stopDataFrameTransformAsync(StopDataFrameTransformRequest request, RequestOptions options,
                                            ActionListener<StopDataFrameTransformResponse> listener) {
        restHighLevelClient.performRequestAsyncAndParseEntity(request,
                DataFrameRequestConverters::stopDataFrameTransform,
                options,
                StopDataFrameTransformResponse::fromXContent,
                listener,
                Collections.emptySet());
    }

    /**
     * Get one or more transform configurations
     * <p>
     * For additional info
     * see <a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/get-transform.html">
     *     Get transform documentation</a>
     *
     * @param request The get transform request
     * @param options Additional request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @return An GetDataFrameTransformResponse containing the requested transforms
     * @throws IOException when there is a serialization issue sending the request or receiving the response
     */
    public GetDataFrameTransformResponse getDataFrameTransform(GetDataFrameTransformRequest request, RequestOptions options)
            throws IOException {
        return restHighLevelClient.performRequestAndParseEntity(request,
                DataFrameRequestConverters::getDataFrameTransform,
                options,
                GetDataFrameTransformResponse::fromXContent,
                Collections.emptySet());
    }

    /**
     * Get one or more transform configurations asynchronously and notifies listener on completion
     * <p>
     * For additional info
     * see <a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/get-transform.html">
     *     Get transform documentation</a>
     *
     * @param request The get transform request
     * @param options Additional request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param listener Listener to be notified upon request completion
     */
    public void getDataFrameTransformAsync(GetDataFrameTransformRequest request, RequestOptions options,
                                           ActionListener<GetDataFrameTransformResponse> listener) {
        restHighLevelClient.performRequestAsyncAndParseEntity(request,
                DataFrameRequestConverters::getDataFrameTransform,
                options,
                GetDataFrameTransformResponse::fromXContent,
                listener,
                Collections.emptySet());
    }
}
