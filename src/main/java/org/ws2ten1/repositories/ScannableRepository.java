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
package org.ws2ten1.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Repository interface supported scan operations.
 *
 * @param <E> the domain type the repository manages
 * @param <ID> the type of the id of the entity the repository manages
 */
@NoRepositoryBean
public interface ScannableRepository<E, ID extends Serializable>extends ReadableRepository<E, ID> {
	
	/**
	 * Returns the number of entities available.
	 *
	 * @return the number of entities
	 * @throws DataAccessException データアクセスエラーが発生した場合
	 */
	long count();
	
	/**
	 * Returns all instances of the type.
	 *
	 * @return all entities
	 * @throws DataAccessException データアクセスエラーが発生した場合
	 */
	Iterable<E> findAll();
	
	/**
	 * Returns all entities sorted by the given options.
	 *
	 * @param sort sorting information
	 * @return all entities sorted by the given options
	 * @throws DataAccessException データアクセスエラーが発生した場合
	 */
	List<E> findAll(Sort sort);
	
}
