/*
 * Copyright 2002-2019 the original author or authors.
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

package net.sharplab.springframework.security.webauthn.metadata;

import com.webauthn4j.extras.fido.metadata.HttpClient;
import org.springframework.web.client.RestTemplate;

/**
 * Client for FIDO Metadata Service
 */
public class RestTemplateAdaptorHttpClient implements HttpClient {

    private RestTemplate restTemplate;

    public RestTemplateAdaptorHttpClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String fetch(String url) {
//        String url = fidoMetadataServiceEndpoint + "?token=" + token;
//        url = "https://fidoalliance.co.nz/mds/execute/0f19dfa625f7f56c626e528b79d75946fe92337355681ac47f25f4ccb55aa601"; //TODO
        return restTemplate.getForObject(url, String.class);
    }
}
