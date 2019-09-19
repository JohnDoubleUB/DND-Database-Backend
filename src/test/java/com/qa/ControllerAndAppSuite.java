package com.qa;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.qa.controllers.InventoriesControllerTest;
import com.qa.controllers.PlayerCharactersControllerTest;
import com.qa.mainapp.AppTest;


@RunWith(Suite.class)
@SuiteClasses({InventoriesControllerTest.class, PlayerCharactersControllerTest.class, AppTest.class})
public class ControllerAndAppSuite {

}