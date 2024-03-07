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
package com.openbravo.pos.util;

import javax.print.DocFlavor;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;

/**
 *
 * @author adrianromero
 */
public class ReportUtils {
    
    private ReportUtils() {
    }
    
    /**
     *
     * @param printername
     * @return
     */
    public static PrintService getPrintService(String printername) {
        
        // Initalize print service
        
        if (printername == null) {
            return PrintServiceLookup.lookupDefaultPrintService();       
        } else {
            
            switch (printername) {
                case "(Show dialog)":
                    return null; // null means "you have to show the print dialog"
                case "(Default)":
                    return PrintServiceLookup.lookupDefaultPrintService();
                default:
                    PrintService[] pservices =
                            PrintServiceLookup.lookupPrintServices(DocFlavor.SERVICE_FORMATTED.PRINTABLE , null);
                    for (PrintService s : pservices) {
                            if (printername.equals(s.getName())) {
                                    return s;
                                    }
                            }
                    return PrintServiceLookup.lookupDefaultPrintService();                
            }
        }                 
    }
    
    /**
     *
     * @return
     */
    public static String[] getPrintNames() {
        PrintService[] pservices = 
                PrintServiceLookup.lookupPrintServices(DocFlavor.SERVICE_FORMATTED.PRINTABLE , null);
        
        String printers[] = new String[pservices.length];
        for (int i = 0; i < pservices.length; i++) {    
            printers[i] = pservices[i].getName();
        }
        
        return printers;
    }

}
