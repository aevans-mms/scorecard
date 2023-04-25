package com.example.scorecard;

import org.testng.annotations.Test;

public class ScorecardTest extends SeleniumTest
{
    String scorecardUrl = "https://scoresapp.netlify.app/";

    @Test
    public void selectTeams()
    {
        driver.get(scorecardUrl);
    }
}