package org.diorite.web.cms.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account
{
    @Id
    @GeneratedValue
    private int    id;
    @Column(nullable = false, unique = true)
    private String userName;
    @Column(unique = true)
    private String displayName;
}
