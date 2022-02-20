/*********************************************************************************
 *                                                                               *
 *  Copyright (c) 2022-2022 BalaGude, This source is a part of              * 
 *   Robot Service Application - sample application source code.                 *
 *                                                                               *
 *   Licensed under the Apache License, Version 2.0 (the "License");             *
 *   you may not use this file except in compliance with the License.            *
 *   You may obtain a copy of the License at                                     *
 *                                                                               *
 *      http://www.apache.org/licenses/LICENSE-2.0                               *
 *                                                                               *
 *   Unless required by applicable law or agreed to in writing, software         *
 *   distributed under the License is distributed on an "AS IS" BASIS,           *
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.    *
 *   See the License for the specific language governing permissions and         *
 *   limitations under the License.                                              *
 *                                                                               *
 *********************************************************************************/
package com.robot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.robot.entity.Survivor;

/**
 * The interface Robot repository.
 *
 * @author BalaGude
 */
@Repository
public interface ISurvivorRepository extends JpaRepository<Survivor, Long>,
		PagingAndSortingRepository<Survivor, Long>, JpaSpecificationExecutor<Survivor> {

	@Query("select s from Survivor s where s.id =:id")
	Survivor findSurvivorByID(Long id);
}