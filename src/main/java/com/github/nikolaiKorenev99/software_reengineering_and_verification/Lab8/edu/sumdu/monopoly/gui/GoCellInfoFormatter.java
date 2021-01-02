package com.github.nikolaiKorenev99.software_reengineering_and_verification.Lab8.edu.sumdu.monopoly.gui;

import com.github.nikolaiKorenev99.software_reengineering_and_verification.Lab8.edu.sumdu.monopoly.Cell;

public class GoCellInfoFormatter implements CellInfoFormatter {
    
    public static final String GO_CELL_LABEL = "<html><b>Go</b></html>";
    
    public String format(Cell cell) {
        return GO_CELL_LABEL;
    }
}
