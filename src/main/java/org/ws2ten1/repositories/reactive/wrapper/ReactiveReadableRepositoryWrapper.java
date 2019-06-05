/*
 * Copyright 2019 the original author or authors.
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
package org.ws2ten1.repositories.reactive.wrapper;

import java.io.Serializable;

import org.reactivestreams.Publisher;

import reactor.core.publisher.Mono;

import org.ws2ten1.repositories.ReadableRepository;
import org.ws2ten1.repositories.reactive.ReactiveReadableRepository;

/**
 * TODO miyamoto.daisuke.
 */
public interface ReactiveReadableRepositoryWrapper<T, ID extends Serializable>
		extends ReactiveRepositoryWrapper<T, ID, ReadableRepository<T, ID>>, ReactiveReadableRepository<T, ID> {
	
	@Override
	default Mono<T> findById(ID id) {
		return findById(Mono.just(id));
	}
	
	@Override
	default Mono<T> findById(Publisher<ID> id) {
		return Mono.from(id)
			.publishOn(getScheduler())
			.map(v -> getDelegate().findById(v))
			.flatMap(optional -> optional.map(Mono::just).orElseGet(Mono::empty));
	}
	
	@Override
	default Mono<Boolean> existsById(ID id) {
		return existsById(Mono.just(id));
	}
	
	@Override
	default Mono<Boolean> existsById(Publisher<ID> id) {
		return Mono.from(id)
			.publishOn(getScheduler())
			.map(v -> getDelegate().existsById(v));
	};
}
