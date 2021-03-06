/*
 * #%L
 * share-po
 * %%
 * Copyright (C) 2005 - 2016 Alfresco Software Limited
 * %%
 * This file is part of the Alfresco software. 
 * If the software was purchased under a paid Alfresco license, the terms of 
 * the paid license agreement will prevail.  Otherwise, the software is 
 * provided under the following open source license terms:
 * 
 * Alfresco is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Alfresco is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with Alfresco. If not, see <http://www.gnu.org/licenses/>.
 * #L%
 */
package org.alfresco.po.share.site.document;

import org.apache.commons.lang3.StringUtils;

/**
 * Different Aspects of Documents.
 * 
 * @author Shan Nagarajan
 * @since 1.6.1
 */
public enum DocumentAspect
{
    CLASSIFIABLE("Classifiable (cm:generalclassifiable)", "P:cm:generalclassifiable"),
    VERSIONABLE("Versionable (cm:versionable)", "P:cm:versionable"),
    AUDIO("Audio (audio:audio)", "P:audio:audio"),
    INDEX_CONTROL("Index Control (cm:indexControl)", "P:cm:indexControl"),
    COMPLIANCEABLE("Complianceable (cm:complianceable)", "P:cm:complianceable"),
    DUBLIN_CORE("Dublin Core (cm:dublincore)", "P:cm:dublincore"),
    EFFECTIVITY("Effectivity (cm:effectivity)", "P:cm:effectivity"),
    SUMMARIZABLE("Summarizable (cm:summarizable)", "P:cm:summarizable"),
    TEMPLATABLE("Templatable (cm:templatable)", "P:cm:templatable"),
    EMAILED("Emailed (cm:emailed)", "P:cm:emailed"),
    ALIASABLE_EMAIL("Email Alias (emailserver:aliasable)", "P:emailserver:aliasable"),
    TAGGABLE("Taggable (cm:taggable)", "P:cm:taggable"),
    INLINE_EDITABLE("Inline Editable (app:inlineeditable)", "P:app:inlineeditable"),
    GOOGLE_DOCS_EDITABLE("Google Docs Editable", "P:gd:googleEditable"),
    GEOGRAPHIC("Geographic (cm:geographic)", "P:cm:geographic"),
    EXIF("EXIF (exif:exif)", "P:exif:exif"),
    RESTRICTABLE("Restrictable (dp:restrictable)", "P:dp:restrictable");

    private String value;
    private String property;

    private DocumentAspect(String value, String property)
    {
        this.value = value;
        this.property = property;
    }

    public String getValue()
    {
        return this.value;
    }

    public String getProperty()
    {
        return this.property;
    }

    /**
     * Find the {@link DocumentAspect} based it is name.
     * 
     * @param name - Aspect's Name
     * @return {@link DocumentAspect}
     * @throws Exception - Throws {@link Exception} if not able to find
     */
    public static DocumentAspect getAspect(String name) throws Exception
    {
        if (StringUtils.isEmpty(name))
        {
            throw new UnsupportedOperationException("Name can't null or empty, It is required.");
        }
        for (DocumentAspect aspect : DocumentAspect.values())
        {
            if (aspect.value.contains(name.trim()))
            {
                return aspect;
            }
        }
        throw new IllegalArgumentException("Not able to find the Document Aspect for given name : " + name);
    }

    /**
     * Find the {@link DocumentAspect} based it is property.
     *
     * @param property - Aspect's property
     * @return {@link DocumentAspect}
     * @throws Exception - Throws {@link Exception} if not able to find
     */
    public static DocumentAspect getAspectByProperty(String property) throws Exception
    {
        if (StringUtils.isEmpty(property))
        {
            throw new UnsupportedOperationException("Name can't null or empty, It is required.");
        }
        for (DocumentAspect aspect : DocumentAspect.values())
        {
            if (aspect.property != null && aspect.property.equalsIgnoreCase(property.trim()))
            {
                return aspect;
            }
        }
        throw new IllegalArgumentException("Not able to find the Document Aspect for given name : " + property);
    }
}
