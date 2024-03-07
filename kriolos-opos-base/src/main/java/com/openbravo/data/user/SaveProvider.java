/*
 * Copyright (C) 2022 KriolOS
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.openbravo.data.user;

import com.openbravo.basic.BasicException;

/**
 *
 * @author poolborges
 */
public interface SaveProvider<TYPE> {

    /**
     *
     * @return
     */
    boolean canDelete();

    /**
     *
     * @return
     */
    boolean canInsert();

    /**
     *
     * @return
     */
    boolean canUpdate();

    /**
     *
     * @param value
     * @return
     * @throws BasicException
     */
    int deleteData(TYPE value) throws BasicException;

    /**
     *
     * @param value
     * @return
     * @throws BasicException
     */
    int insertData(TYPE value) throws BasicException;

    /**
     *
     * @param value
     * @return
     * @throws BasicException
     */
    int updateData(TYPE value) throws BasicException;
    
}
