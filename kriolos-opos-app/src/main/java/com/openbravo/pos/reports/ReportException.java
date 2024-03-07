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

package com.openbravo.pos.reports;

/**
 *
 * @author JG uniCenta
 */
public class ReportException extends Exception {
    
    /**
     *
     */
    public ReportException() {
    }

    /**
     *
     * @param msg
     */
    public ReportException(String msg) {
        super(msg);
    }

    /**
     *
     * @param e
     */
    public ReportException(Exception e) {
        super(e);
    }
}
