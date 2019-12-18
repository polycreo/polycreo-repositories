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
import java.util.function.Function;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.NoRepositoryBean;

import org.ws2ten1.chunkrequests.Chunkable;
import org.ws2ten1.chunkrequests.PaginationTokenEncoder;

/**
 * Repository interface to retrieve chunk of entities.
 *
 * @param <E> the domain type the repository manages
 * @param <ID> the type of the id of the entity the repository manages
 */
@NoRepositoryBean
public interface ChunkableRepository<E, ID extends Serializable & Comparable<ID>>extends ReadableRepository<E, ID> {
	
	/**
	 * Returns a {@link List} of entities meeting the chunking restriction provided in the {@code Chunkable} object.
	 *
	 * @param chunkable chunking information
	 * @return a chunk of entities
	 * @throws NullPointerException 引数に{@code null}を与えた場合
	 * @throws DataAccessException if a data access error occurred
	 */
	List<E> findAll(Chunkable chunkable);
	
	/**
	 * Returns an ID extractor function.
	 *
	 * @return an ID extractor function for this entity.
	 */
	Function<E, ID> getIdExtractor();
	
	/**
	 * Returns an ID extractor function.
	 *
	 * @return an ID extractor function for this entity.
	 */
	PaginationTokenEncoder getPaginationTokenEncoder();
	
}
