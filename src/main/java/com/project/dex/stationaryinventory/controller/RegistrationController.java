package com.project.dex.stationaryinventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.project.dex.stationaryinventory.common.jfxsupport.FXMLController;
import com.project.dex.stationaryinventory.config.PropertiesConfig;

@FXMLController
public class RegistrationController {

    @Autowired
	private ApplicationContext context;

	@Autowired
	private PropertiesConfig config;
    
}
