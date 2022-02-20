/*********************************************************************************
 *                                                                               *
 *  Copyright (c) 2022-2022 Bala Gude, This source is a part of              * 
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
package com.robot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.robot.entity.Location;
import com.robot.entity.Survivor;
import com.robot.model.RobotDetailsResponse;
import com.robot.model.SurvivorDetailsResponse;
import com.robot.service.IRobotService;

/**
 * The type Robot controller.
 *
 * @author Bala Gude
 */
@RestController
@RequestMapping("/api/v1/")
public class RobotController {

	@Autowired
	private IRobotService robotService;

	
	/**
	 * Get Survivor based on ID.
	 *
	 * @return the Survivor
	 * @throws Exception
	 */
	@GetMapping("/survivor/{survivorId}")
	public Survivor findByID(@PathVariable (value = "survivorId") Long survivorId) throws Exception {
		return robotService.findById(survivorId);
	}

	/**
	 * Create Survivor.
	 *
	 * @param Robot the Robot
	 * @return the Survivor
	 * @throws Exception
	 */
	@PostMapping("/survivor")
	public Survivor createSurvivor(@RequestBody Survivor survivor) throws Exception {
		return robotService.save(survivor);
	}

	/**
	 * Update Survivor Location
	 *
	 * @param survivorId     the survivor id
	 * @param Robot the Robot
	 * @return the response entity
	 * @throws Exception
	 */
	@PutMapping("/survivor/{survivorId}")
	public Object updateSurvivor(@PathVariable(value = "survivorId") Long survivorId, @RequestBody Location location)
			throws Exception {
		return ResponseEntity.ok(robotService.update(survivorId, location));
	}

	/**
	 * update infected.
	 *
	 * @param survivorId     the survivor id
	 * @return the Survivor
	 * @throws Exception
	 */
	@PostMapping("/infected/{survivorId}")
	public Survivor addInfected(@PathVariable(value="survivorId") Long survivorId) throws Exception {
		return robotService.updateInfectedStatus(survivorId);
	}

	/**
	 * Get details robot details.
	 *
	 * @return the RobotDetailsResponse
	 * @throws Exception
	 */
	@GetMapping("/reports/survivors")
	public SurvivorDetailsResponse getReports() throws Exception {
		return robotService.getSurvivorReport();
	}
	
	/**
	 * Get all Robot
	 *
	 * @return the list
	 * @throws Exception
	 */
	@GetMapping("/reports/robots")
	public RobotDetailsResponse getAll() throws Exception {
		return robotService.getRobotsReport();
	}

}