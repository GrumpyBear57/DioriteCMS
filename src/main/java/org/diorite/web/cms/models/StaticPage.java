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
}
