package cy.ac.ucy.teamc.scc;

public class Exam {
private String name;
private String age_range;
private String smoker;
private String alcohol;
private String deiktis_mazas_range;
private String gender;
private String inheritance;
private String SexualSituation;
private String description;
private String image_name;
private String frequency;

public Exam(String name,String age_range,String smoker,String alcohol,String deiktis_mazas_range,String gender,String inheritance, String SexualSituation, String  description, String image_name, String frequency)
{
	this.name=name;
	this.age_range=age_range;
	this.alcohol=alcohol;
	this.deiktis_mazas_range=deiktis_mazas_range;
	this.inheritance=inheritance;
	this.smoker=smoker;
	this.gender=gender;
	this.description=description;
	this.SexualSituation=SexualSituation;
	this.image_name=image_name;
	this.frequency=frequency;
}

public String get_frequency()
{
	return this.frequency;
}
public String get_image_name()
{
	return this.image_name;
}
public String get_name()
{
	return this.name;
}
public String get_description()
{
	return this.description;
}
public String get_age_range()
{
	return this.age_range;
}

public String get_alcohol()
{
	return this.alcohol;
}

public String get_deiktis_mazas_range()
{
	return this.deiktis_mazas_range;
}

public String get_inheritance()
{
	return this.inheritance;
}

public String get_smoker()
{
	return this.smoker;
}

public String get_gender()
{
	return this.gender;
}


public String get_SexualSituation()
{
	return this.SexualSituation;
}


public void set_name(String name)
{
	this.name=name;
}
public void set_description(String description)
{
	this.description=description;
}
public void set_age_range(String age_range)
{
	this.age_range=age_range;
}

public void set_alcohol(String alcohol)
{
	this.alcohol=alcohol;
}

public void set_deiktis_mazas_range(String deiktis_mazas_range)
{
	this.deiktis_mazas_range=deiktis_mazas_range;
}

public void set_inheritance(String inheritance)
{
	this.inheritance=inheritance;
}

public void set_smoker(String smoker)
{
	this.smoker=smoker;
}

public void set_gender(String gender)
{
	this.gender=gender;
}

public void set_SexualSituation(String SexualSituation)
{
	this.SexualSituation=SexualSituation;
}

public void set_image_name(String image_name)
{
	this.image_name=image_name;
}

public void set_frequency(String frequency)
{
	this.frequency=frequency;
}
}
