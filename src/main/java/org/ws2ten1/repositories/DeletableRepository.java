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

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

/**
 * Repository interface to delete single entity.
 *
 * @param <E> the domain type the repository manages
 * @param <ID> the type of the id of the entity the repository manages
 */
@NoRepositoryBean
public interface DeletableRepository<E, ID extends Serializable>
		extends Repository<E, ID> {
	
	/**
	 * Deletes the entity with the given id.
	 *
	 * @param id must not be {@literal null}.
	 * @throws IllegalArgumentException in case the given {@code id} is {@literal null}
	 * @throws DataAccessException データアクセスエラーが発生した場合
	 */
	void deleteById(ID id);
	
	/**
	 * Deletes a given entity.
	 *
	 * @param entity entity to delete
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 * @throws DataAccessException データアクセスエラーが発生した場合
	 */
	void delete(E entity);
}
