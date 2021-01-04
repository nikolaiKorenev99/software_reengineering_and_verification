package com.github.nikolaiKorenev99.software_reengineering_and_verification.Lab8.edu.sumdu.monopoly.gui;

import com.github.nikolaiKorenev99.software_reengineering_and_verification.Lab8.edu.sumdu.monopoly.Cell;
import com.github.nikolaiKorenev99.software_reengineering_and_verification.Lab8.edu.sumdu.monopoly.gui.CellInfoFormatter;

public class GotoJailCellInfoFormatter implements CellInfoFormatter {

    public static final String GOTO_JAIL_LABEL = "<html><b>Go to Jail</b></html>";

    public String format(Cell cell) {
    	return GOTO_JAIL_LABEL;
	}
}
