package org.diorite.web.cms.core;

import org.hibernate.cfg.NamingStrategy;

public class DioriteNamingStrategy implements NamingStrategy
{
    private static final String PREFIX = "dioritecms_";

    private String addPrefix(final String composedTableName)
    {
        return PREFIX + composedTableName;
    }

    @Override
    public String classToTableName(final String s)
    {
        return null;
    }

    @Override
    public String propertyToColumnName(final String s)
    {
        return null;
    }

    @Override
    public String tableName(final String s)
    {
        return null;
    }

    @Override
    public String columnName(final String s)
    {
        return null;
    }

    @Override
    public String collectionTableName(final String s, final String s1, final String s2, final String s3, final String s4)
    {
        return null;
    }

    @Override
    public String joinKeyColumnName(final String s, final String s1)
    {
        return null;
    }

    @Override
    public String foreignKeyColumnName(final String s, final String s1, final String s2, final String s3)
    {
        return null;
    }

    @Override
    public String logicalColumnName(final String s, final String s1)
    {
        return null;
    }

    @Override
    public String logicalCollectionTableName(final String s, final String s1, final String s2, final String s3)
    {
        return null;
    }

    @Override
    public String logicalCollectionColumnName(final String s, final String s1, final String s2)
    {
        return null;
    }
}