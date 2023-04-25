package com.example.scorecard;


import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;

public class OptionsLoaded
{
	public static ExpectedCondition<Boolean> numberOfOptionsAtLeast(final Select select, final int size)
	{
		return new ExpectedCondition<Boolean>()
		{
			public Boolean apply(WebDriver driver)
			{
				return checkNumberOfOptions(select, size);
			}
		};
	}

	public static ExpectedCondition<Boolean> numberOfOptionsAtLeast(final WebElement element, final int size)
	{
		return new ExpectedCondition<Boolean>()
		{
			public Boolean apply(WebDriver driver)
			{
				Select select = new Select(element);
				return checkNumberOfOptions(select, size);
			}
		};
	}

	public static ExpectedCondition<Boolean> numberOfOptionsAtLeast(final By locator, final int size)
	{
		return new ExpectedCondition<Boolean>()
		{
			public Boolean apply(WebDriver driver)
			{
				WebElement element = driver.findElement(locator);
				Select select = new Select(element);
				return checkNumberOfOptions(select, size);
			}
		};
	}


	public static Boolean checkNumberOfOptions(Select select, int size)
	{
		try
		{
			return select.getOptions().size() >= size;
		}
		catch (StaleElementReferenceException e)
		{
			return false;
		}
	}
}