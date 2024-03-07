--    KriolOS POS - Open Source Point Of Sale
--    Copyright (c) 2019-2023 KriolOS
--    
--    This program is free software: you can redistribute it and/or modify
--    it under the terms of the GNU General Public License as published by
--    the Free Software Foundation, either version 3 of the License, or
--    (at your option) any later version.
--
--    This program is distributed in the hope that it will be useful,
--    but WITHOUT ANY WARRANTY; without even the implied warranty of
--    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
--    GNU General Public License for more details.
--
--    You should have received a copy of the GNU General Public License
--    along with this program.  If not, see <http://www.gnu.org/licenses/>.

-- Database upgrade script for MySQL
-- v4.3 - v4.3.1 3MAY2017

--
-- CLEAR THE DECKS
--
DELETE FROM sharedtickets;

--
-- UPDATE THE REMOTE PRINTER
UPDATE `resources` SET `content` = $FILE{/com/openbravo/pos/templates/script.SendOrder.txt} WHERE `name` = 'script.SendOrder';
UPDATE `resources` SET `content` = $FILE{/com/openbravo/pos/templates/Printer.Ticket.P1.xml} WHERE `name` = 'Printer.Ticket.P1';
UPDATE `resources` SET `content` = $FILE{/com/openbravo/pos/templates/Printer.Ticket.P2.xml} WHERE `name` = 'Printer.Ticket.P2';
UPDATE `resources` SET `content` = $FILE{/com/openbravo/pos/templates/Printer.Ticket.P3.xml} WHERE `name` = 'Printer.Ticket.P3';
UPDATE `resources` SET `content` = $FILE{/com/openbravo/pos/templates/Printer.Ticket.P4.xml} WHERE `name` = 'Printer.Ticket.P4';
UPDATE `resources` SET `content` = $FILE{/com/openbravo/pos/templates/Printer.Ticket.P5.xml} WHERE `name` = 'Printer.Ticket.P5';
UPDATE `resources` SET `content` = $FILE{/com/openbravo/pos/templates/Printer.Ticket.P6.xml} WHERE `name` = 'Printer.Ticket.P6';

-- UPDATE App' version
UPDATE applications SET NAME = $APP_NAME{}, VERSION = $APP_VERSION{} WHERE ID = $APP_ID{};