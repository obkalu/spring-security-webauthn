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

package net.sharplab.springframework.security.webauthn.endpoint;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.webauthn4j.request.PublicKeyCredentialType;

import java.util.Objects;

public class WebAuthnPublicKeyCredentialDescriptor {

    private PublicKeyCredentialType type;
    private String id;

    @JsonCreator
    public WebAuthnPublicKeyCredentialDescriptor(
            @JsonProperty("type") PublicKeyCredentialType type,
            @JsonProperty("id") String id) {
        this.type = type;
        this.id = id;
    }

    public WebAuthnPublicKeyCredentialDescriptor(
            String id) {
        this.type = PublicKeyCredentialType.PUBLIC_KEY;
        this.id = id;
    }

    public PublicKeyCredentialType getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WebAuthnPublicKeyCredentialDescriptor that = (WebAuthnPublicKeyCredentialDescriptor) o;
        return type == that.type &&
                Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, id);
    }
}
