package scorecard.api.model;

public class TestResultStatus
{
	private String action = "TestResultStatus";
	private Long testResultId;
	private boolean updated;

	public Long getTestResultId()
	{
		return testResultId;
	}

	public void setTestResultId(Long testResultId)
	{
		this.testResultId = testResultId;
	}

	public boolean isUpdated()
	{
		return updated;
	}

	public void setUpdated(boolean updated)
	{
		this.updated = updated;
	}

}
