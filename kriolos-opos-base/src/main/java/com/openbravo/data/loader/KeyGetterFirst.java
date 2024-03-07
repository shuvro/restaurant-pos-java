//    KriolOS POS
//    Copyright (c) 2019-2023 KriolOS
//
//    This program is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    This program is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with this program.  If not, see <http://www.gnu.org/licenses/>.

package com.openbravo.data.loader;

/**
 *
 * @author  adrian
 */
public class KeyGetterFirst implements IKeyGetter {
    
    private final int [] m_aElems;
    
    /** Creates a new instance of KeyGetterBasic
     * @param aElems */
    public KeyGetterFirst(int[] aElems) {
        m_aElems = aElems;
    }
    
    /**
     *
     * @param value
     * @return
     */
    @Override
    public Object getKey(Object value) {
        if (value == null) {
            return null;
        } else {
            Object[] avalue = (Object []) value;
            return avalue[m_aElems[0]];
        }
    }   
}
