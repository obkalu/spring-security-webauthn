/*
 *    Copyright 2002-2019 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package net.sharplab.springframework.security.fido.server.endpoint;

import com.webauthn4j.request.UserVerificationRequirement;
import com.webauthn4j.request.extension.client.AuthenticationExtensionsClientInputs;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

public class ServerPublicKeyCredentialGetOptionsResponse extends ServerResponseBase {
    private String challenge;
    private BigInteger timeout;
    private String rpId;
    private List<ServerPublicKeyCredentialDescriptor> allowCredentials;
    private UserVerificationRequirement userVerification;
    private AuthenticationExtensionsClientInputs extensions;

    public ServerPublicKeyCredentialGetOptionsResponse(
            String challenge,
            BigInteger timeout,
            String rpId,
            List<ServerPublicKeyCredentialDescriptor> allowCredentials,
            UserVerificationRequirement userVerification,
            AuthenticationExtensionsClientInputs extensions) {
        super();
        this.challenge = challenge;
        this.timeout = timeout;
        this.rpId = rpId;
        this.allowCredentials = allowCredentials;
        this.userVerification = userVerification;
        this.extensions = extensions;
    }

    public ServerPublicKeyCredentialGetOptionsResponse(String challenge) {
        super();
        this.challenge = challenge;
    }

    public ServerPublicKeyCredentialGetOptionsResponse() {
        super();
    }

    public String getChallenge() {
        return challenge;
    }

    public BigInteger getTimeout() {
        return timeout;
    }

    public String getRpId() {
        return rpId;
    }

    public List<ServerPublicKeyCredentialDescriptor> getAllowCredentials() {
        return allowCredentials;
    }

    public UserVerificationRequirement getUserVerification() {
        return userVerification;
    }

    public AuthenticationExtensionsClientInputs getExtensions() {
        return extensions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServerPublicKeyCredentialGetOptionsResponse that = (ServerPublicKeyCredentialGetOptionsResponse) o;
        return Objects.equals(challenge, that.challenge) &&
                Objects.equals(timeout, that.timeout) &&
                Objects.equals(rpId, that.rpId) &&
                Objects.equals(allowCredentials, that.allowCredentials) &&
                userVerification == that.userVerification &&
                Objects.equals(extensions, that.extensions);
    }

    @Override
    public int hashCode() {

        return Objects.hash(challenge, timeout, rpId, allowCredentials, userVerification, extensions);
    }
}
