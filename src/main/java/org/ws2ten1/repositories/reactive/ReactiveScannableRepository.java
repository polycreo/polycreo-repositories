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
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Repository interface supported scan operations.
 *
 * @param <T> the domain type the repository manages
 * @param <ID> the type of the id of the entity the repository manages
 */
@NoRepositoryBean
public interface ReactiveScannableRepository<T, ID extends Serializable>extends ReactiveReadableRepository<T, ID> {
	
	/**
	 * Returns all instances of the type.
	 *
	 * @return {@link Flux} emitting all entities.
	 * @throws DataAccessException if a data access error occurred
	 */
	Flux<T> findAll();
	
	/**
	 * Returns all entities sorted by the given options.
	 *
	 * @param sort must not be {@literal null}.
	 * @return all entities sorted by the given options.
	 * @throws IllegalArgumentException in case the given {@link Sort} is {@literal null}.
	 * @throws DataAccessException if a data access error occurred
	 */
	Flux<T> findAll(Sort sort);
	
	/**
	 * Returns the number of entities available.
	 *
	 * @return {@link Mono} emitting the number of entities.
	 * @throws DataAccessException if a data access error occurred
	 */
	Mono<Long> count();
}
