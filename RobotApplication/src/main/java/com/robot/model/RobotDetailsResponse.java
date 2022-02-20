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

/**
 * The RobotDetails Response.
 *
 * @author BalaGude
 */
public class RobotDetailsResponse {

	private int flyingRobotsCnt;
	
	private int landRobotsCnt;
	
	private List<Robot> flyingRobots;
	private List<Robot> landRobots;
	public int getFlyingRobotsCnt() {
		return flyingRobotsCnt;
	}
	public void setFlyingRobotsCnt(int flyingRobotsCnt) {
		this.flyingRobotsCnt = flyingRobotsCnt;
	}
	public int getLandRobotsCnt() {
		return landRobotsCnt;
	}
	public void setLandRobotsCnt(int landRobotsCnt) {
		this.landRobotsCnt = landRobotsCnt;
	}
	public List<Robot> getFlyingRobots() {
		return flyingRobots;
	}
	public void setFlyingRobots(List<Robot> flyingRobots) {
		this.flyingRobots = flyingRobots;
	}
	public List<Robot> getLandRobots() {
		return landRobots;
	}
	public void setLandRobots(List<Robot> landRobots) {
		this.landRobots = landRobots;
	}

	
}
