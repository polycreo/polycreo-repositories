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
package org.polycreo.repositories;

import java.io.Serializable;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

/**
 * Repository interface to delete multiple entities.
 *
 * @param <E> the domain type the repository manages
 * @param <ID> the type of the id of the entity the repository manages
 */
@NoRepositoryBean
public interface BatchDeletableRepository<E, ID extends Serializable>extends Repository<E, ID> {
	
	/**
	 * Returns all instances of the type with the given IDs.
	 *
	 * @param ids set of ID
	 * @return set of entities
	 * @throws DataAccessException if a data access error occurred
	 */
	Iterable<E> deleteAllById(Iterable<ID> ids);
	
	/**
	 * Deletes the given entities.
	 *
	 * @param entities entities to delete
	 * @throws IllegalArgumentException in case the given {@link Iterable} is {@literal null}.
	 * @throws DataAccessException データアクセスエラーが発生した場合
	 * @throws DataAccessException if a data access error occurred
	 */
	void deleteAll(Iterable<? extends E> entities);
}
