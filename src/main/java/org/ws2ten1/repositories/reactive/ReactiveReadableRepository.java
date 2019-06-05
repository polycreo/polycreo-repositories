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
import org.springframework.data.repository.Repository;

import org.reactivestreams.Publisher;

import reactor.core.publisher.Mono;

/**
 * Repository interface to retrieve single entity.
 *
 * @param <T> the domain type the repository manages
 * @param <ID> the type of the id of the entity the repository manages
 */
@NoRepositoryBean
public interface ReactiveReadableRepository<T, ID extends Serializable>
		extends Repository<T, ID> {
	
	/**
	 * Retrieves an entity by its id.
	 *
	 * @param id must not be {@literal null}.
	 * @return {@link Mono} emitting the entity with the given id or {@link Mono#empty()} if none found.
	 * @throws IllegalArgumentException in case the given {@code id} is {@literal null}.
	 * @throws DataAccessException if a data access error occurred
	 */
	Mono<T> findById(ID id);
	
	/**
	 * Retrieves an entity by its id supplied by a {@link Publisher}.
	 *
	 * @param id must not be {@literal null}. Uses the first emitted element to perform the find-query.
	 * @return {@link Mono} emitting the entity with the given id or {@link Mono#empty()} if none found.
	 * @throws IllegalArgumentException in case the given {@link Publisher} {@code id} is {@literal null}.
	 * @throws DataAccessException if a data access error occurred
	 */
	Mono<T> findById(Publisher<ID> id);
	
	/**
	 * Returns whether an entity with the id exists.
	 *
	 * @param id must not be {@literal null}.
	 * @return {@link Mono} emitting {@literal true} if an entity with the given id exists, {@literal false} otherwise.
	 * @throws IllegalArgumentException in case the given {@code id} is {@literal null}.
	 * @throws DataAccessException if a data access error occurred
	 */
	Mono<Boolean> existsById(ID id);
	
	/**
	 * Returns whether an entity with the given id, supplied by a {@link Publisher}, exists. Uses the first emitted
	 * element to perform the exists-query.
	 *
	 * @param id must not be {@literal null}.
	 * @return {@link Mono} emitting {@literal true} if an entity with the given id exists, {@literal false} otherwise
	 * @throws IllegalArgumentException in case the given {@link Publisher} {@code id} is {@literal null}.
	 * @throws DataAccessException if a data access error occurred
	 */
	Mono<Boolean> existsById(Publisher<ID> id);
}
