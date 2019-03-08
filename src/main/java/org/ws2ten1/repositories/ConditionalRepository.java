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

import org.springframework.data.repository.NoRepositoryBean;

/**
 * Base repository interface for Spring Data Chunk.
 *
 * @param <E> the domain type the repository manages
 * @param <ID> the type of the id of the entity the repository manages
 */
@NoRepositoryBean
public interface ConditionalRepository<E, ID extends Serializable, C>extends BaseRepository<E, ID> {
	
	/**
	 * Returns condition of specified entity.
	 *
	 * @param entity to extract condition
	 * @return condition
	 * @throws org.springframework.dao.DataAccessException データアクセスエラーが発生した場合
	 */
	C getCondition(E entity);
}