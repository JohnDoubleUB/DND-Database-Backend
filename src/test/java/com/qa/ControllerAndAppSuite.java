package com.qa;

import com.qa.controllers.InventoryControllerTest;
import com.qa.controllers.PlayerCharacterControllerTest;
import com.qa.service.InventoryServiceTest;
import com.qa.service.PlayerCharacterServiceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


import com.qa.mainapp.AppTest;


@RunWith(Suite.class)
@SuiteClasses({InventoryServiceTest.class, PlayerCharacterServiceTest.class, InventoryControllerTest.class, PlayerCharacterControllerTest.class, AppTest.class})
public class ControllerAndAppSuite {

}