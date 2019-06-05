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
package org.ws2ten1.repositories.reactive;

import java.io.Serializable;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.NoRepositoryBean;

import org.reactivestreams.Publisher;

import reactor.core.publisher.Flux;

import org.ws2ten1.repositories.UpsertableRepository;

/**
 * Repository interface to upsert multiple entities.
 *
 * @param <T> the domain type the repository manages
 * @param <ID> the type of the id of the entity the repository manages
 */
@NoRepositoryBean
public interface ReactiveBatchUpsertableRepository<T, ID extends Serializable>extends UpsertableRepository<T, ID> {
	
	/**
	 * Saves all given entities.
	 *
	 * @param entities must not be {@literal null}.
	 * @return {@link Flux} emitting the saved entities.
	 * @throws IllegalArgumentException in case the given {@link Iterable} {@code entities} is {@literal null}.
	 * @throws DataAccessException if a data access error occurred
	 */
	<S extends T> Flux<S> saveAll(Iterable<S> entities);
	
	/**
	 * Saves all given entities.
	 *
	 * @param entityStream must not be {@literal null}.
	 * @return {@link Flux} emitting the saved entities.
	 * @throws IllegalArgumentException in case the given {@code Publisher} {@code entityStream} is {@literal null}.
	 * @throws DataAccessException if a data access error occurred
	 */
	<S extends T> Flux<S> saveAll(Publisher<S> entityStream);
}