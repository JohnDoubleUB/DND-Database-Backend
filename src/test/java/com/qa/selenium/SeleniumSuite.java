package com.qa.selenium;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;



@RunWith(Suite.class)
@SuiteClasses({NavigationTest.class, CharacterCreateTest.class, CharacterCreatePersistenceTest.class, CharacterUpdateTest.class, CharacterUpdatePersistenceTest.class, InventoryCreateTest.class, InventoryCreatePersistenceTest.class, InventoryUpdateTest.class, InventoryUpdatePersistenceTest.class, InventoryDeleteTest.class})
public class SeleniumSuite {

}