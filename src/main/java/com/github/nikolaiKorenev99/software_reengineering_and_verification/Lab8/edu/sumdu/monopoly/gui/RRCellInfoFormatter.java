package com.github.nikolaiKorenev99.software_reengineering_and_verification.Lab8.edu.sumdu.monopoly.gui;

import com.github.nikolaiKorenev99.software_reengineering_and_verification.Lab8.edu.sumdu.monopoly.Cell;
import com.github.nikolaiKorenev99.software_reengineering_and_verification.Lab8.edu.sumdu.monopoly.Player;
import com.github.nikolaiKorenev99.software_reengineering_and_verification.Lab8.edu.sumdu.monopoly.RailRoadCell;

public class RRCellInfoFormatter implements CellInfoFormatter {
    public String format(Cell cell) {
        RailRoadCell c = (RailRoadCell)cell;
        StringBuffer buf = new StringBuffer();
        Player owner = cell.getOwner();
        String ownerName = "";
        if(owner != null) {
        	ownerName = owner.getName();
        }
        buf.append("<html><b><font color='lime'>")
                .append(cell.getName())
                .append("</font></b><br>")
                .append("$").append(c.getPrice())
				.append("<br>Owner: ").append(ownerName)
                .append("</html>");
        return buf.toString();
    }
}
