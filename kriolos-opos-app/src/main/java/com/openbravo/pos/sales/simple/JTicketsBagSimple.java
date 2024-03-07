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

package com.openbravo.pos.sales.simple;

import com.openbravo.pos.forms.AppView;
import com.openbravo.pos.sales.*;
import com.openbravo.pos.sales.shared.JTicketsBagShared;

/**
 *
 * @author JG uniCenta
 */
public class JTicketsBagSimple extends JTicketsBagShared {
    
    /**
     * 
     * @param app
     * @param panelticket 
     */
    public JTicketsBagSimple(AppView app, TicketsEditor panelticket) {
        super(app, panelticket);
        this.setEnabledPanel(true);
        this.disableAllButtons();
        this.setEnabledButtonDel(true);
    }

 
    
}
