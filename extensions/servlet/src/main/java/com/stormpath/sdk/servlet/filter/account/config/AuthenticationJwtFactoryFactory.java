/*
 * Copyright 2014 Stormpath, Inc.
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
package com.stormpath.sdk.servlet.filter.account.config;

import com.stormpath.sdk.servlet.config.ConfigSingletonFactory;
import com.stormpath.sdk.servlet.filter.account.AuthenticationJwtFactory;
import com.stormpath.sdk.servlet.filter.account.DefaultAuthenticationJwtFactory;
import com.stormpath.sdk.servlet.filter.account.JwtSigningKeyResolver;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.servlet.ServletContext;

public class AuthenticationJwtFactoryFactory extends ConfigSingletonFactory<AuthenticationJwtFactory> {

    public static final String JWT_SIGNATURE_ALGORITHM = "stormpath.web.account.jwt.signatureAlgorithm";
    public static final String JWT_SIGNING_KEY_RESOLVER = "stormpath.web.account.jwt.signingKey.resolver";

    @Override
    protected AuthenticationJwtFactory createInstance(ServletContext servletContext) throws Exception {
        JwtSigningKeyResolver resolver = getConfig().getInstance(JWT_SIGNING_KEY_RESOLVER);
        String algName = getConfig().get(JWT_SIGNATURE_ALGORITHM);
        SignatureAlgorithm alg = SignatureAlgorithm.forName(algName);
        int ttl = getConfig().getAccountJwtTtl();
        return new DefaultAuthenticationJwtFactory(resolver, alg, ttl);
    }
}