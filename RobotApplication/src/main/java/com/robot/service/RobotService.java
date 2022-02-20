/*********************************************************************************
 *                                                                               *
 *  Copyright (c) 2022-2022 BalaGude, This source is a part of              * 
 *   Survivor Service Application - sample application source code.                 *
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

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.robot.entity.Location;
import com.robot.entity.Survivor;
import com.robot.exception.ResourceNotFoundException;
import com.robot.exception.SurvivorInvalidValueException;
import com.robot.model.Robot;
import com.robot.model.RobotDetailsResponse;
import com.robot.model.SurvivorDetailsResponse;
import com.robot.repository.ISurvivorRepository;

/**
 * The type Robot Service.
 *
 * @author BalaGude
 */
@Service
public class RobotService implements IRobotService {

	@Autowired
	private ISurvivorRepository survivorRepository;

	@SuppressWarnings("unchecked")
	private List<LinkedHashMap<String, String>> findAll() throws URISyntaxException {
		URI uri = new URI("https://robotstakeover20210903110417.azurewebsites.net/robotcpu");
		ResponseEntity<Object> result = new RestTemplate().getForEntity(uri, Object.class);
		return (List<LinkedHashMap<String, String>>) result.getBody();
	}

	@Override
	public SurvivorDetailsResponse getSurvivorReport() throws URISyntaxException {

		List<Survivor> survivors = survivorRepository.findAll();
		SurvivorDetailsResponse survivorDetailsResponse = new SurvivorDetailsResponse();
		List<Survivor> infectedSurvivors = new ArrayList<>();
		List<Survivor> nonInfectedSurvivors = new ArrayList<>();
		for (int i = 0; i < survivors.size(); i++) {
			Survivor survivor = survivors.get(i);
			if (survivor.getStatus().equals("infected")) {
				infectedSurvivors.add(survivor);
			} else {
				nonInfectedSurvivors.add(survivor);
			}
		}

		survivorDetailsResponse.setNonInfectedPercentage(String.format("%.0f%%",(float) nonInfectedSurvivors.size() *100  / (float) survivors.size()));
		survivorDetailsResponse
				.setInfectedPercentage(String.format("%.0f%%",(float) infectedSurvivors.size() *100  / (float) survivors.size()));
		survivorDetailsResponse.setInfectedSurvivors(infectedSurvivors);
		survivorDetailsResponse.setNonInfectedSurvivors(nonInfectedSurvivors);
		return survivorDetailsResponse;
	}

	@Override
	public RobotDetailsResponse getRobotsReport() throws URISyntaxException {

		List<LinkedHashMap<String, String>> robotsList = this.findAll();
		RobotDetailsResponse robotsDetailsResponse = new RobotDetailsResponse();
		List<Robot> landRobots = new ArrayList<>();
		List<Robot> flyingRobots = new ArrayList<>();
		Robot robot;
		for (int i = 0; i < robotsList.size(); i++) {
			LinkedHashMap<String, String> ro = robotsList.get(i);

			robot = new Robot();
			robot.setCategory(ro.get("category"));
			robot.setManufacturedDate(ro.get("manufacturedDate"));
			robot.setSerialNumber(ro.get("serialNumber"));
			robot.setModel(ro.get("model"));

			if (robot.getCategory().equals("Flying")) {
				flyingRobots.add(robot);
			} else {
				landRobots.add(robot);
			}
		}

		robotsDetailsResponse.setFlyingRobotsCnt(flyingRobots.size());
		robotsDetailsResponse.setLandRobotsCnt(landRobots.size());
		robotsDetailsResponse.setLandRobots(landRobots);
		robotsDetailsResponse.setFlyingRobots(flyingRobots);
		return robotsDetailsResponse;
	}

	@Override
	public Survivor findById(Long id) throws ResourceNotFoundException {

		Survivor survivor = survivorRepository.findSurvivorByID(id);

		if (survivor != null) {
			return survivor;

		} else {
			throw new ResourceNotFoundException("Survivor not found on :: " + id);
		}

	}

	@Override
	public Survivor save(Survivor survivor) throws SurvivorInvalidValueException {

		if (survivor.getStatus() == null) {
			survivor.setStatus("non_infected");
		}
		survivor = survivorRepository.save(survivor);
		return survivor;
	}

	@Override
	public Survivor update(Long id, Location location) throws ResourceNotFoundException, SurvivorInvalidValueException {
		Survivor survivorDetails = survivorRepository.findSurvivorByID(id);

		if (survivorDetails != null) {
			survivorDetails.setLocation(location);
			survivorDetails = survivorRepository.save(survivorDetails);
			return survivorDetails;
		} else {
			throw new ResourceNotFoundException("Survivor not found on :: " + id);
		}
	}

	@Override
	public Survivor updateInfectedStatus(Long survivorId) throws ResourceNotFoundException {
		Survivor survivor = survivorRepository.findSurvivorByID(survivorId);

		if (survivor != null) {
			Integer infected = survivor.getNoTimesinfected();
			infected = infected != null ? infected + 1 : 1;
			survivor.setNoTimesinfected(infected);
			survivor.setStatus(infected >= 3 ? "infected" : "non_infected");
			survivor = survivorRepository.save(survivor);
			return survivor;
		} else {
			throw new ResourceNotFoundException("Survivor not found on :: " + survivorId);
		}
	}
}
