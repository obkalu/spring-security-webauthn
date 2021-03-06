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

package net.sharplab.springframework.security.webauthn.endpoint;

import com.webauthn4j.registry.Registry;
import org.junit.Test;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.authentication.MFATokenEvaluator;
import org.springframework.security.authentication.MFATokenEvaluatorImpl;

import static org.assertj.core.api.Assertions.assertThat;

public class OptionsEndpointFilterTest {

    private Registry registry = new Registry();

    @Test
    public void getter_setter_test() {
        OptionsEndpointFilter optionsEndpointFilter = new OptionsEndpointFilter(null, registry);
        MFATokenEvaluator mfaTokenEvaluator = new MFATokenEvaluatorImpl();
        AuthenticationTrustResolver trustResolver = new AuthenticationTrustResolverImpl();
        optionsEndpointFilter.setMFATokenEvaluator(mfaTokenEvaluator);
        optionsEndpointFilter.setTrustResolver(trustResolver);
        assertThat(optionsEndpointFilter.getMFATokenEvaluator()).isEqualTo(mfaTokenEvaluator);
        assertThat(optionsEndpointFilter.getTrustResolver()).isEqualTo(trustResolver);
    }


}
