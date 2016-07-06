package org.diorite.web.cms.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "static_pages")
public class StaticPage
{
    @Id
    @GeneratedValue
    private Integer id;
    private String  name;
    private boolean published;
    private boolean displayFrame;

    public StaticPage()
    {
    }

    public Integer getId()
    {
        return this.id;
    }

    public void setId(final Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public boolean isPublished()
    {
        return this.published;
    }

    public void setPublished(final boolean published)
    {
        this.published = published;
    }

    public boolean isDisplayFrame()
    {
        return this.displayFrame;
    }

    public void setDisplayFrame(final boolean displayFrame)
    {
        this.displayFrame = displayFrame;
    }
}
