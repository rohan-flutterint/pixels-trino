/*
 * Copyright 2022 PixelsDB.
 *
 * This file is part of Pixels.
 *
 * Pixels is free software: you can redistribute it and/or modify
 * it under the terms of the Affero GNU General Public License as
 * published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 *
 * Pixels is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * Affero GNU General Public License for more details.
 *
 * You should have received a copy of the Affero GNU General Public
 * License along with Pixels.  If not, see
 * <https://www.gnu.org/licenses/>.
 */
package io.pixelsdb.pixels.trino;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;
import io.pixelsdb.pixels.executor.join.JoinType;

/**
 * @author hank
 * @date 18/05/2022
 */
public final class PixelsJoinHandle
{
    private final PixelsTableHandle leftTable;
    private final PixelsTableHandle rightTable;
    private final JoinType joinType;

    @JsonCreator
    public PixelsJoinHandle(
            @JsonProperty("leftTable") PixelsTableHandle leftTable,
            @JsonProperty("rightTable") PixelsTableHandle rightTable,
            @JsonProperty("joinType") JoinType joinType)
    {
        this.leftTable = leftTable;
        this.rightTable = rightTable;
        this.joinType = joinType;
    }

    @JsonProperty
    public PixelsTableHandle getLeftTable()
    {
        return leftTable;
    }

    @JsonProperty
    public PixelsTableHandle getRightTable()
    {
        return rightTable;
    }

    @JsonProperty
    public JoinType getJoinType()
    {
        return joinType;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PixelsJoinHandle that = (PixelsJoinHandle) o;
        return Objects.equal(leftTable, that.leftTable) &&
                Objects.equal(rightTable, that.rightTable) &&
                joinType == that.joinType;
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(leftTable, rightTable, joinType);
    }
}
