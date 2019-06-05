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

import reactor.core.publisher.Flux;

import org.ws2ten1.repositories.BatchCreatableRepository;
import org.ws2ten1.repositories.reactive.ReactiveBatchCreatableRepository;

/**
 * TODO miyamoto.daisuke.
 */
public interface ReactiveBatchCreatableRepositoryWrapper<T, ID extends Serializable>
		extends ReactiveRepositoryWrapper<T, ID, BatchCreatableRepository<T, ID>>,
		ReactiveBatchCreatableRepository<T, ID> {
	
	@Override
	default <S extends T> Flux<S> createAll(Iterable<S> entities) {
		return createAll(Flux.fromIterable(entities));
	}
	
	@Override
	default <S extends T> Flux<S> createAll(Publisher<S> entityStream) {
		return Flux.from(entityStream)
			.publishOn(getScheduler())
			.buffer(32)
			.flatMap(entity -> Flux.fromIterable(getDelegate().createAll(entity)));
	}
}
