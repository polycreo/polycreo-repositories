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
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Repository interface to create single entity.
 *
 * @param <E> the domain type the repository manages
 * @param <ID> the type of the id of the entity the repository manages
 */
@NoRepositoryBean
public interface CreatableRepository<E, ID extends Serializable>extends BaseRepository<E, ID> {
	
	/**
	 * Create entity.
	 *
	 * <p>{@code entity}として{@code null}を渡した場合、何もせずに{@code null}を返す。</p>
	 *
	 * @param entity entity to update
	 * @return updated entity
	 * @throws DuplicateKeyException 対象エンティティがすでにあった場合
	 * @throws DataAccessException データアクセスエラーが発生した場合
	 */
	<S extends E> S create(S entity);
}
