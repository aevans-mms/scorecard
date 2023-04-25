package scorecard.api.model;

import javax.persistence.*;

public class TestResult
{
	private @Id @GeneratedValue Long id;
	private @ManyToOne Long testCaseId;
	private String status;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Long getTestCaseId()
	{
		return testCaseId;
	}

	public void setTestCaseId(Long testCaseId)
	{
		this.testCaseId = testCaseId;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

}
