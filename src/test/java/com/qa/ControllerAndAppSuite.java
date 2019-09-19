package com.qa;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.qa.controllers.InventoriesControllerTestDeprecated;
import com.qa.controllers.PlayerCharactersControllerTestDeprecated;
import com.qa.mainapp.AppTest;


@RunWith(Suite.class)
@SuiteClasses({InventoriesControllerTestDeprecated.class, PlayerCharactersControllerTestDeprecated.class, AppTest.class})
public class ControllerAndAppSuite {

}