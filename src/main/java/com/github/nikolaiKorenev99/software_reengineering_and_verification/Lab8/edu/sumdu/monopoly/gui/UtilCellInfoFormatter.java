package com.github.nikolaiKorenev99.software_reengineering_and_verification.Lab8.edu.sumdu.monopoly.gui;

import com.github.nikolaiKorenev99.software_reengineering_and_verification.Lab8.edu.sumdu.monopoly.Cell;
import com.github.nikolaiKorenev99.software_reengineering_and_verification.Lab8.edu.sumdu.monopoly.Player;
import com.github.nikolaiKorenev99.software_reengineering_and_verification.Lab8.edu.sumdu.monopoly.UtilityCell;

public class UtilCellInfoFormatter implements CellInfoFormatter {

	public String format(Cell cell) {
        UtilityCell c = (UtilityCell)cell;
        StringBuffer buf = new StringBuffer();
        Player owner = cell.getPlayer();
        String ownerName = "";
        if(owner != null) {
        	ownerName = owner.getName();
        }
        buf.append("<html><b><font color='olive'>")
                .append(cell.getName())
                .append("</font></b><br>")
                .append("$").append(c.getPrice())
				.append("<br>Owner: ").append(ownerName)
                .append("</html>");
        return buf.toString();
	}
}
