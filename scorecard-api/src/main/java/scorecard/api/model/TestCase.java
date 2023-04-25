package scorecard.api.model;

import scorecard.api.controller.TestController;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
public class TestCase
{
	private @Id
	@GeneratedValue Long id;
	private String title;
	private String description;
	private List<String> categories;

	public static TestCase create(String title, String description, List<String> categories)
	{
		TestCase instance = TestCase.create(title);
		instance.setDescription(description);
		instance.setCategories(categories);
		return instance;
	}
	public static TestCase create(String title)
	{
		TestCase instance = new TestCase();
		instance.setId(TestController.nextTestId());
		instance.setTitle(title);
		return instance;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public List<String> getCategories()
	{
		return categories;
	}

	public void setCategories(List<String> categories)
	{
		this.categories = categories;
	}
}

