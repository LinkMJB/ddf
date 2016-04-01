/**
 * Copyright (c) Codice Foundation
 * <p/>
 * This is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser
 * General Public License as published by the Free Software Foundation, either version 3 of the
 * License, or any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details. A copy of the GNU Lesser General Public License
 * is distributed along with this program and can be found at
 * <http://www.gnu.org/licenses/lgpl.html>.
 **/
package ddf.catalog.content.operation.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;

import ddf.catalog.content.data.ContentItem;
import ddf.catalog.content.operation.UpdateStorageRequest;
import ddf.catalog.operation.impl.OperationImpl;

public class UpdateStorageRequestImpl extends OperationImpl implements UpdateStorageRequest {

    private List<ContentItem> contentItems = new ArrayList<>();

    private String id;

    public UpdateStorageRequestImpl(Map<String, Serializable> properties) {
        this(null, null, properties);
    }

    public UpdateStorageRequestImpl(List<ContentItem> contentItems, Map<String, Serializable> properties) {
        this(contentItems, null, properties);
    }

    public UpdateStorageRequestImpl(List<ContentItem> contentItems, String id, Map<String, Serializable> properties) {
        super(properties);
        if (StringUtils.isEmpty(id)) {
            this.id = UUID.randomUUID().toString();
        } else {
            this.id = id;
        }
        if (contentItems != null) {
            this.contentItems = contentItems;
        }
    }

    @Override
    public List<ContentItem> getContentItems() {
        return contentItems;
    }

    @Override
    public String getId() {
        return id;
    }

}
