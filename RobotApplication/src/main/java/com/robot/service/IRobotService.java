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
package com.robot.service;

import java.net.URISyntaxException;

import com.robot.entity.Location;
import com.robot.entity.Survivor;
import com.robot.exception.ResourceNotFoundException;
import com.robot.exception.SurvivorInvalidValueException;
import com.robot.model.RobotDetailsResponse;
import com.robot.model.SurvivorDetailsResponse;

/**
 * The type Robot Service Interface.
 *
 * @author BalaGude
 */
public interface IRobotService {

	Survivor findById(Long robotId) throws ResourceNotFoundException;

	Survivor save(Survivor survivor) throws Exception;

	Survivor update(Long lectureId, Location location) throws ResourceNotFoundException, SurvivorInvalidValueException;

	RobotDetailsResponse getRobotsReport() throws URISyntaxException;

	SurvivorDetailsResponse getSurvivorReport() throws URISyntaxException;

	Survivor updateInfectedStatus(Long survivorId) throws ResourceNotFoundException;

}
