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
package com.robot.model;

import java.util.List;

import com.robot.entity.Survivor;

/**
 * The RobotDetails Response.
 *
 * @author BalaGude
 */
public class SurvivorDetailsResponse {

	private String nonInfectedPercentage;
	
	private String infectedPercentage;
	
	List<Survivor> infectedSurvivors;
	List<Survivor> nonInfectedSurvivors;

	public String getNonInfectedPercentage() {
		return nonInfectedPercentage;
	}

	public void setNonInfectedPercentage(String nonInfectedPercentage) {
		this.nonInfectedPercentage = nonInfectedPercentage;
	}

	public List<Survivor> getInfectedSurvivors() {
		return infectedSurvivors;
	}

	public void setInfectedSurvivors(List<Survivor> infectedSurvivors) {
		this.infectedSurvivors = infectedSurvivors;
	}

	public List<Survivor> getNonInfectedSurvivors() {
		return nonInfectedSurvivors;
	}

	public void setNonInfectedSurvivors(List<Survivor> nonInfectedSurvivors) {
		this.nonInfectedSurvivors = nonInfectedSurvivors;
	}

	public String getInfectedPercentage() {
		return infectedPercentage;
	}

	public void setInfectedPercentage(String infectedPercentage) {
		this.infectedPercentage = infectedPercentage;
	}
}
