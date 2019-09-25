package com.qa.selenium;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;



@RunWith(Suite.class)
@SuiteClasses({NavigationTest.class, CharacterCreateTest.class, CharacterUpdateTest.class, InventoryCreateTest.class, InventoryUpdateTest.class, InventoryDeleteTest.class, CharacterDeleteTest.class})
public class SeleniumSuite {
}